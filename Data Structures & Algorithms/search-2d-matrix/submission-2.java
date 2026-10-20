class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        return search(matrix,target,0,m*n-1);
    }
    public boolean search(int[][]matrix,int target,int left,int right){
        int m=matrix.length,n=matrix[0].length;
        if(left>right)
            return false;
        int mid=left+(right-left)/2;
        int r=mid/n,c=mid%n;
        if(matrix[r][c]==target)
            return true;
        else if(matrix[r][c]<target){
           return search(matrix,target,mid+1,right);
        }
        else
            return search(matrix,target,left,mid-1);
    }
}
