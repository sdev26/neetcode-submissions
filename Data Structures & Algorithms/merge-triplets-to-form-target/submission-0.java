class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean targetXFound = false;
        boolean targetYFound = false;
        boolean targetZFound = false;
        
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            if (triplet[0] == target[0]) targetXFound = true;
            if (triplet[1] == target[1]) targetYFound = true;
            if (triplet[2] == target[2]) targetZFound = true;
            if (targetXFound && targetYFound && targetZFound) {
                return true;
            }
        }
        
        return targetXFound && targetYFound && targetZFound;
    }
}
