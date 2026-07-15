class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int m = nums.length / 2;
        int l = 0;
        int r = nums.length - 1;
        int min = nums[m];
        while(l <= r && m >= 0 && m < nums.length){
            if(nums[m] < min){
                min = nums[m];
            }
            if(nums[r] >= nums[m]){
                r = m - 1;
            } else{
                l = m + 1;
            }
            m = (l + r) / 2;
        }
        return min;
    }
}
