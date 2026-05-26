class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for(String token : tokens){
            if(token.equals("+")) {
                int sum = s.pop() + s.pop();
                s.push(sum);
            } else if(token.equals("-")){
                int num2 = s.pop();
                int diff = s.pop() - num2;
                s.push(diff);
            } else if(token.equals("*")){
                int prod = s.pop() * s.pop();
                s.push(prod);
            } else if(token.equals("/")){
                int num2 = s.pop();
                int quot = s.pop() / num2;
                s.push(quot);
            } else{
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
}
