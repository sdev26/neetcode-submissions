class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        return searchBinary(matrix,0,m*n-1,target);
    }
    public boolean searchBinary(int[][]matrix,int left,int right,int target){
        if(left>right)
            return false;
        int n=matrix[0].length;
        int mid=left+(right-left)/2;
        int r=mid/n,c=mid%n;
        if(matrix[r][c]==target)return true;
        if(matrix[r][c]>target)
           return searchBinary(matrix,left,mid-1,target);
        else
            return searchBinary(matrix,mid+1,right,target);
        
    }
}
