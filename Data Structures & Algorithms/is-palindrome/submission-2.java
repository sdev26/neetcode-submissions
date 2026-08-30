class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
                sb.append(s.charAt(i));
        }
        s=sb.toString().toLowerCase();
        int left=0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;right--;
        }
        return true;
    }
}
