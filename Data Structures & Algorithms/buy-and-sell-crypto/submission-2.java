class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = prices[0];
        int tempBuy = prices[0];
        int length = prices.length;
        for(int i = 1; i < length; i++){
            if((prices[i] - tempBuy) > (sell - buy)){
                buy = tempBuy;
                sell = prices[i];
            } else if((prices[i] - buy) > (sell - buy)){
                sell = prices[i];
            } else if(prices[i] < buy || prices[i] < tempBuy){
                tempBuy = prices[i];
            }
        }
        return sell - buy;
    }
}
