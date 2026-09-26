class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 1){
            return 1;
        }
        Map<Character, Integer> counts = new HashMap<>();
        counts.put(s.charAt(0), 1);
        int l = 0;
        int r = 1;
        int longest = 1;
        int highCount = 1;
        char highChar = s.charAt(0);
        while(r < s.length()){
            char curr = s.charAt(r);
            if(counts.containsKey(curr) && counts.get(curr) != null){
                counts.put(curr, counts.get(curr) + 1);
                if(counts.get(curr) > highCount){
                    highCount = counts.get(curr);
                    highChar = curr;
                }
            } else{
                counts.put(curr, 1);
            }
            int length = r - l + 1;
            if((length > longest) && ((length - highCount) <= k)){
                longest = length;
            }
            while(((length - highCount) > k) && l <= r){
                counts.put(s.charAt(l), counts.get(s.charAt(l)) - 1);
                if(s.charAt(l) == highChar){
                    highCount--;
                    for(char c : counts.keySet()){
                        if(counts.get(c) != null && counts.get(c) > highCount){
                            highCount = counts.get(c);
                            highChar = c;
                        }
                    }
                }
                l++;
                length--;
            }
            r++;
        }
        return longest;
    }
}
