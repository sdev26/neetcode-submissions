class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
      char[]array=s.toCharArray();
      StringBuilder sb=new StringBuilder();
        for(char c:array){
            if(Character.isLetterOrDigit(c))
                sb.append(c);
        }
        s=sb.toString();
        int start=0,end=s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;end--;
        }
        return true;
    }
}
