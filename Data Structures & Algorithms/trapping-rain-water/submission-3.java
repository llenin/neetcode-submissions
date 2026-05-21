class Solution {
    public int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int maxL = height[0];
        int maxR = height[r];
        int area = 0;
        while(l < r){
            if(maxL <= maxR){
                l++;
                if(height[l] < maxL){
                    area += maxL - height[l];
                } else{
                    maxL = height[l];
                }
            } else{
                r--;
                if(height[r] < maxR){
                    area += maxR - height[r];
                } else{
                    maxR = height[r];
                }
            }
        }

        return area;
    }
}
