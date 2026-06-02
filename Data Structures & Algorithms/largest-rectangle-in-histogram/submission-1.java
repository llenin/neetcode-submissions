class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> s = new Stack<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            if(s.isEmpty() || s.peek()[1] < heights[i]){
                // if(!s.isEmpty()){
                //     max = Math.max(max, s.peek()[1] * (i - s.peek()[0]));
                // }
                max = Math.max(heights[i], max);
                s.push(new int[]{i, heights[i]});
            } else if(s.peek()[1] > heights[i]){
                int index = i;
                while(!s.isEmpty() && s.peek()[1] > heights[i]){
                    int[] curr = s.pop();
                    max = Math.max(max, curr[1] * (i - curr[0]));
                    index = curr[0];
                }
                if(s.isEmpty()){
                    s.push(new int[]{0, heights[i]});
                } else{
                    s.push(new int[]{index, heights[i]});
                }
            }
        }
        while(!s.isEmpty()){
            int[] rect = s.pop();
            max = Math.max(max, rect[1] * (heights.length - rect[0]));
        }
        return max;
    }
}
