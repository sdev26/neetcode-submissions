class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer>al=new ArrayList<>();
        int carry=0;
        int n=digits.length;
        for(int i=n-1;i>=0;i--){
            int sum=digits[i]+carry;
            if(i==n-1)
            sum+=1;
            if(sum>=10){
                carry=sum/10;
                al.add(sum%10);
            }
            else{
                carry=0;
                al.add(sum);
            }
        }
        if(carry > 0)
        al.add(carry);
        Collections.reverse(al);
       int[] ans = new int[al.size()];
        for(int i = 0; i < al.size(); i++)
    ans[i] = al.get(i);
        return ans;
    }
}
