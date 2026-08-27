class Twitter {
    Map<Integer,List<int[]>> map = new HashMap<>();
    Map<Integer,Set<Integer>> followerMap = new HashMap<>();
    int counter;
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        counter++;
        map.computeIfAbsent(userId, k->new ArrayList<>()).add(new int[]{tweetId,counter});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->Integer.compare(a.getValue(),b.getValue()));
            if(map.containsKey(userId)){
                List<int[]> userOwn = map.get(userId);
            for(int[] n:userOwn){
                pq.offer(new AbstractMap.SimpleEntry<>(n[0],n[1]));
                while(pq.size()>10){
                            pq.poll();
                }
             }
            }        
        if(followerMap.containsKey(userId)){
            Set<Integer> userList= followerMap.get(userId);
            for(int user:userList){
                if(map.containsKey(user)){
                    List<int[]> list = map.get(user);
                    for(int[] num:list){
                        pq.offer(new AbstractMap.SimpleEntry<>(num[0],num[1]));
                        while(pq.size()>10){
                            pq.poll();
                        }
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int count=0;
        while(!pq.isEmpty() && count<10){
            res.add(0,pq.poll().getKey());
            count++;
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
