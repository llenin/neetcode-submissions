class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.add(num);
        }
        if(k < nums.length){
            for(int i = 0; i < nums.length - k; i++){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k || val > minHeap.peek()){
            minHeap.add(val);
        }
        if(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
