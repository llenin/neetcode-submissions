class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones){
            heap.add(stone);
        }
        while(heap.size() > 1){
            int stone1 = heap.remove();
            int stone2 = heap.remove();
            int newStone = Math.max(stone1, stone2) - Math.min(stone1, stone2);
            if(newStone != 0){
                heap.add(newStone);
            }
        }
        if(heap.peek() != null){
            return heap.peek();
        }
        return 0;
    }
}
