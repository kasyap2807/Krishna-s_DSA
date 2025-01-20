// 6. Best T
// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
// Example 2:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.
 

// Constraints:

// 1 <= prices.length <= 105
// 0 <= prices[i] <= 104



// 178/212
class Solution {
    public int maxProfit(int[] prices) {
        
        int min = 0;

        for(int i = 0 ; i < prices.length-1 ; i++){
            if(prices[min]>prices[i] ){
                min = i;
            }

        }

        if(min == prices.length-1){
            return 0 ;
        }

        int maxpoint = prices[min];

        for(int i = min+1 ; i < prices.length ; i++){
            if(maxpoint<prices[i]){
                maxpoint = prices[i];
            }
        }

        return maxpoint - prices[min];
    }
}

// 203/212
class Solution2 {
    public int maxProfit(int[] prices) {
        int finsum = 0;

        for(int i = 0 ; i < prices.length-1 ; i++){

        int maxpoint = prices[i];

        for(int i1 = i+1 ; i1 < prices.length ; i1++){
            if(maxpoint<prices[i1]){
                maxpoint = prices[i1];
            }
        }

        if(finsum<maxpoint - prices[i]){
            finsum = maxpoint - prices[i];
        }

        }

        if(finsum!=0){
            return finsum;
        }

        return 0;

        
    }
}


// 202/212

class Solution3 {
    public int maxProfit(int[] prices) {
        int finsum = rax(0,prices,0);

        if(finsum!=0){
            return finsum;
        }

        return 0;

        
    }

    public int rax(int i,int[] prices, int finsum){
        if(i<prices.length){
        int maxpoint = prices[i];

        for(int i1 = i+1 ; i1 < prices.length-1 ; i1++){
            if(maxpoint<prices[i1]){
                maxpoint = prices[i1];
            }
        }
        if(finsum<maxpoint - prices[i]){
            finsum = maxpoint - prices[i];
        }
        return rax(++i,prices,finsum);
        }
        else{
            return finsum;
        }
    }
}

// 0/212

class Solution5 {
    public int maxProfit(int[] prices) {
        int finsum = rax(0,prices,0);

        if(finsum!=0){
            return finsum;
        }

        return 0;

        
    }

    public int rax(int i,int[] prices, int finsum){
        if(i<prices.length){
        int maxpoint = rax2(i+1,prices,prices[i]);

        if(finsum<maxpoint - prices[i]){
            finsum = maxpoint - prices[i];
        }
        return rax(++i,prices,finsum);
        }
        else{
            return finsum;
        }
    }

    public int rax2(int i, int[] prices,int maxpoint){
            if(maxpoint<prices[i] && i < prices.length-1){
                return rax2(++i,prices,prices[i]);
            }
            return maxpoint;
    }
}

// 212/212

class Solution6 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0]; // Initialize minPrice with the first price.
        int maxProfit = 0; // Initially, no profit can be made.

        // Loop through the prices array.
        for (int i = 1; i < prices.length; i++) {
            // Update the minPrice if a lower price is encountered.
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate profit if we sold at prices[i] and update maxProfit.
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}



// Sample Input 

// prices = [7,1,5,3,6,4]

// sample output 

// 5