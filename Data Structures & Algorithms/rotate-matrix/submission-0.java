class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=i+1;j<n;j++){
                reverse(matrix,i,j);
            }
        }
        for(int arr[]:matrix){
            reverse(arr);
        }
    }
    public void reverse(int[][]matrix,int i,int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    public void reverse(int []arr){
        int n=arr.length;
        int left=0,right=n-1;
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;right--;
        }
    }
}
