class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        if(length == 0 || length % 2 == 1){
            return false;
        }
        Stack<Character> brackets = new Stack<>();
        for(int i = 0; i < length; i++){
            char curr = s.charAt(i);
            if(curr == '(' || curr == '[' || curr == '{'){
                brackets.push(curr);
            } else{
                if(brackets.isEmpty()){
                    return false;
                }
                char check = brackets.peek();
                if((check == '(' && curr == ')') || (check == '[' && curr == ']') || (check == '{' && curr == '}')){
                    brackets.pop();
                } else{
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}
