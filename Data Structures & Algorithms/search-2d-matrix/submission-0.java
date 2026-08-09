class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int left=0,right=m*n-1;
        return search(matrix,left,right,target);
    }
    public boolean search(int[][]matrix,int left,int right,int target){
        if(left>right)
            return false;
        int m=matrix.length,n=matrix[0].length;
        int mid=left+(right-left)/2;
        int r=mid/n,c=mid%n;
        if(matrix[r][c]==target)return true;
        if(matrix[r][c]>target)
            return search(matrix,left,mid-1,target);
        else
          return  search(matrix,mid+1,right,target);
        
    }
}
