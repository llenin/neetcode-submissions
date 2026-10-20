class Solution {
    List<List<Integer>> combos;
    int[] nums;
    int target;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combos = new ArrayList<>();
        this.nums = nums;
        this.target = target;
        comboSum(new ArrayList<>(), 0, 0);
        return combos;
    }

    private void comboSum(List<Integer> combo, int sum, int i){
        // if(i < nums.length){
        //     int newSum = nums[i] + sum;
        //     if(newSum == target){
        //         combo.add(nums[i]);
        //         combos.add(new ArrayList<>(combo));
        //         combo.remove(combo.size() - 1);
        //         comboSum(combo, sum, i);
        //         comboSum(combo, sum, i + 1);
        //     } else if(newSum < target){
        //         combo.add(nums[i]);
        //         comboSum(combo, newSum, i);
        //         comboSum(combo, sum, i + 1);
        //     }
        // }
        if(sum == target){
            combos.add(new ArrayList<>(combo));
            return;
        }
        if(i >= nums.length || sum > target){
            return;
        }
        combo.add(nums[i]);
        comboSum(combo, sum + nums[i], i);
        combo.remove(combo.size() - 1);
        comboSum(combo, sum, i + 1);
    }
}