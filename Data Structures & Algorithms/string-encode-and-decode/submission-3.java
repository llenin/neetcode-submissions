class Solution {
    public String encode(List<String> strs) {
        String encoded_string = "";
        int size = strs.size();
        for (int i = 0; i < size; i++) {
            String str = strs.get(i);
            int length = str.length();
            for(int j = 0; j < length; j++){
                int newCharNum = str.charAt(j) + 1;
                if(newCharNum == 256){
                    newCharNum = 0;
                }
                encoded_string += (char)newCharNum;
            }
            encoded_string += " ";
        }
        return encoded_string;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int length = str.length();
        String currString = "";
        for(int i = 0; i < length; i++){
            char currChar = str.charAt(i);
            if(currChar == ' '){
                strs.add(currString);
                currString = "";
            } else{
                int charNum = currChar - 1;
                if(charNum == -1){
                    charNum = 255;
                }
                currString += (char)charNum;
            }
        }
        return strs;
    }
}
