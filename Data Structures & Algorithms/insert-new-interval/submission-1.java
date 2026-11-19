class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]>ans=new ArrayList<>();
        for(int curr[]:intervals){
            if(curr[1]< newInterval[0])
                ans.add(curr);
            else if(curr[0]>newInterval[1]){
                ans.add(newInterval);
                newInterval=curr;
            }
            else{
                newInterval[0]=Math.min(curr[0],newInterval[0]);
                newInterval[1]=Math.max(curr[1],newInterval[1]);
               
            }
            
        }
         ans.add(newInterval);
       int mat[][]=new int[ans.size()][2];
       int i=0;
     for(int k=0;k<ans.size();k++){
    mat[k]=ans.get(k);
}
return mat;
    }
}
