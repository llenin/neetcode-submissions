class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            int l = i + 1;
            int r = nums.length - 1;
            while(nums[i] <= 0 && (i == 0 || nums[i] != nums[i - 1]) && l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
                    if(!triplets.contains(triplet)){
                        triplets.add(triplet);
                    }
                    l++;
                    r--;
                } else if(sum < 0){
                    l++;
                } else{
                    r--;
                }
            }
        }
        return triplets;
    }
}
