class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
    }
    public void addNum(int num) {
        if(minHeap.isEmpty() && maxHeap.isEmpty()){
            maxHeap.offer(num);
            return;
        }
        if(num>maxHeap.peek()){
            minHeap.offer(num);
        }else{
            maxHeap.offer(num);
        }
        while(maxHeap.size()-minHeap.size()>1){
            minHeap.offer(maxHeap.poll());
        }
        while(minHeap.size()-maxHeap.size()>0){
            maxHeap.offer(minHeap.poll());
        }
    }
    public double findMedian() {
        int size = minHeap.size()+maxHeap.size();
        if(size%2!=0){
            return maxHeap.peek();
        }else{
            int first = maxHeap.peek();
            int second = minHeap.peek();
            return (first+second)/2.0;
        }
        
    }
}