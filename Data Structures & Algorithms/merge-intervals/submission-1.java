class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]>al=new ArrayList<>();
        int []newInterval=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=newInterval[1]){
               newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            }
            else{
                al.add(newInterval);
                newInterval=intervals[i];
            }
        }
        al.add(newInterval);
        int mat[][]=new int[al.size()][2];
        for(int k=0;k<al.size();k++){
            mat[k]=al.get(k);
        }
        return mat;
    }
}
