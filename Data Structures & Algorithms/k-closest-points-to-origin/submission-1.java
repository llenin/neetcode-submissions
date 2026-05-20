class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = (int)Math.pow(x, 2) + (int)Math.pow(y, 2);
            minHeap.add(new int[]{dist, x, y});
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] point = minHeap.poll();
            res[i][0] = point[1];
            res[i][1] = point[2];
        }
        return res;
    }
}
