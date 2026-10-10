class Solution {
    public int reverse(int x) {
        long re=0;
        while(x!=0){
            int dig=x%10;
            re=re*10+dig;
            x=x/10;
        }
        if(re>Integer.MAX_VALUE||re<Integer.MIN_VALUE)
            return 0;
        return (int)re;
    }
}
