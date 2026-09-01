class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int hold[]=new int[n];
        int sell[]=new int[n];
        int rest[]=new int[n];
        hold[0]=-prices[0];
        sell[0]=0;
        rest[0]=0;
        for(int i=1;i<n;i++){
            hold[i]=Math.max(hold[i-1],rest[i-1]-prices[i]);
            sell[i]=hold[i-1]+prices[i];
            rest[i]=Math.max(rest[i-1],sell[i-1]);
        }
        return Math.max(rest[n-1],sell[n-1]);
    }
}
