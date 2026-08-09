class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(tokens[i].equals("+")||tokens[i].equals("*")||tokens[i].equals("-")||tokens[i].equals("/")){
                int num2=st.pop();
                int num1=st.pop();
                if(tokens[i].equals("+")){
                    st.push(num2+num1);
                }
                else if (tokens[i].equals("*")){
                    st.push(num1*num2);
                }
                else if(tokens[i].equals("-")){
                    st.push(num1-num2);
                }
                else if(tokens[i].equals("/")){
                    st.push(num1/num2);
                }
            }
            else
                st.push(Integer.parseInt(tokens[i]));
        }
        return st.peek();
    }
}
