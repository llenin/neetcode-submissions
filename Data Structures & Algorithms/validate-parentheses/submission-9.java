class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0 || s.length() % 2 == 1){
            return false;
        }
        Stack<Character> brackets = new Stack<>();
        for(int i = 0; i < s.length(); i++){
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
