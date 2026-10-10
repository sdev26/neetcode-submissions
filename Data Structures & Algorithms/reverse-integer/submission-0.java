class Solution {
    public int reverse(int x) {
        int re=0;
        while(x!=0){
            int dig=x%10;
        if (re > Integer.MAX_VALUE / 10 || (re == Integer.MAX_VALUE / 10 && dig > 7)) {
            return 0;
        }
        if (re < Integer.MIN_VALUE / 10 || (re == Integer.MIN_VALUE / 10 && dig < -8)) {
            return 0;
        }
            re=re*10+dig;
            x=x/10;
        }
        return re;
    }
}
