class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
            sb.append(s.charAt(i));
        }
       String word=(sb.toString());
       int size=word.length();
       int left=0,right=size-1;
       while(left<right){
        if(word.charAt(left)!=(word.charAt(right))){
            return false;}
        left++;right--;
       }
        return true;
    }
}
