class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        Stack<Integer> indices = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            int temp = temperatures[i];
            while(!s.isEmpty() && s.peek() < temp){
                s.pop();
                result[indices.peek()] = i - indices.pop();
            }
            s.push(temp);
            indices.push(i);
        }
        return result;
    }
}
