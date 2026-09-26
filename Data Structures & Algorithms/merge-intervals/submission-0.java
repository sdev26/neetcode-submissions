class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]>ans=new ArrayList<>();
        int start=intervals[0][0],end=intervals[0][1];
        for(int []i:intervals){
            if(i[0]<=end){
                end=Math.max(i[1],end);
            }
            else{
                ans.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}
