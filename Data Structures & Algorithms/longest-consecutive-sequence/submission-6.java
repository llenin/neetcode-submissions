class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        Set<Integer> s = new HashSet<>();
        for(int num : nums){
            s.add(num);
        }
        int longest = 1;
        for(int num : s){
            if(!s.contains(num - 1)){
                int length = 1;
                while(s.contains(num + 1)){
                    length++;
                    num++;
                }
                longest = Math.max(length, longest);
            }
        }

        return longest;
    }
}
