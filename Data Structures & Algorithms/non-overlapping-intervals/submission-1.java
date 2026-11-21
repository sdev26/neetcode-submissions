class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start[]=intervals[0];
        int count=0;
        for(int i=1;i<intervals.length;i++){
            int curr[]=intervals[i];
           if(start[1]>curr[0]){
            count++;
            start[1]=Math.min(curr[1],start[1]);
           }
           else
            start=curr;
        }
        return count;
    }
}
