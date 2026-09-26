class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]>ans=new ArrayList<>();
        for(int []i:intervals){
            if(i[1]<newInterval[0]){
                ans.add(i);
            }
            else if(i[0]>newInterval[1]){
                ans.add(newInterval);
                newInterval=i;
            }
            else{
                newInterval[0]=Math.min(i[0],newInterval[0]);
                newInterval[1]=Math.max(i[1],newInterval[1]);
               
            }
        }
         ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}
