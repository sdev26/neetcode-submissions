class Solution {
    HashSet<Integer>hs=new HashSet<>();
    boolean res=true;
    public boolean isHappy(int n) {
        if(n==1)return true;
        return digit(n);
    }
public boolean digit(int n){
      if (n == 1)
            return true;

        if (hs.contains(n))
            return false;

        hs.add(n);

        int sum = 0;

        while (n > 0) {
            int dig = n % 10;
            sum += dig * dig;
            n /= 10;
        }

        return digit(sum);
    }
}
