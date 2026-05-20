class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] pair = new int[2];
        while(right > left && numbers[left] != numbers[right]){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                pair[0] = left + 1;
                pair[1] = right + 1;
                return pair;
            }
            if(sum > target){
                right--;
            } else{
                left++;
            }
        }
        return pair;
    }
}
