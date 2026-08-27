class Twitter {
    
    int counter;
    Map<Integer,List<int[]>> map;
    Map<Integer,Set<Integer>> followerMap;
    public Twitter() {
        this.counter=0;
        this.map = new HashMap<>();
        this.followerMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        counter++;
        map.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{tweetId,counter});     
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->Integer.compare(b.time,a.time));
        if(map.containsKey(userId)){
            List<int[]> userOwn = map.get(userId);
            int index = userOwn.size()-1;
            int[] tweet = userOwn.get(index);
            pq.offer(new Tweet(userId,index,tweet[0],tweet[1]));
        }
         if (followerMap.containsKey(userId)) {
            for (int followee : followerMap.get(userId)) {
                if (map.containsKey(followee)) {
                    List<int[]> list = map.get(followee);
                    int index = list.size() - 1;
                    int[] tweet = list.get(index);
                    pq.offer(new Tweet(
                        followee,
                        index,
                        tweet[0],
                        tweet[1]
                    ));
                }
            }
        }
         List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 10) {
            Tweet current = pq.poll();
            res.add(current.tweetId);
            int nextIndex = current.index - 1;
            if (nextIndex >= 0) {
                List<int[]> list = map.get(current.userId);
                int[] nextTweet = list.get(nextIndex);
                pq.offer(new Tweet(
                    current.userId,
                    nextIndex,
                    nextTweet[0],
                    nextTweet[1]
                ));
            }
        }
        return res;
    }     
    
    public void follow(int followerId, int followeeId) {
        followerMap.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerMap.containsKey(followerId))
        {
            Set<Integer> list =followerMap.get(followerId);
            if(list.contains(followeeId)){
                list.remove(followeeId);
            }
        }
        
    }
}

class Tweet{
    int userId;
    int tweetId;
    int index;
    int time;
    public Tweet(int userId,int index,int tweetId,int time){
        this.userId = userId;
        this.index=index;
        this.tweetId = tweetId;
        this.time = time;
    }

}
