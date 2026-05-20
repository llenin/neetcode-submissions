class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")){
            return 0;
        }
        int lengthOfS = s.length();
        if(lengthOfS == 1){
            return 1;
        }
        int longest = 1;
        int left = 0;
        int right = 1;
        for(int i = 1; i < lengthOfS; i++){
            System.out.println(left);
            char currChar = s.charAt(i);
            String currSubstring = s.substring(left, right);
            if(currSubstring.contains(currChar + "")){
                left += currSubstring.indexOf(currChar) + 1;
                right++;
            } else{
                right++;
                if((right - left) > longest){
                    longest = right - left;
                }
            }
        }
        return longest;
    }
}
