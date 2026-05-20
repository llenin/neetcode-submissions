class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prevNums = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(prevNums.containsKey(diff)){
                res[0] = prevNums.get(diff);
                res[1] = i;
                return res;
            }
            prevNums.put(nums[i], i);
        }
        return res;
    }
}
