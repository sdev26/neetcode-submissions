class Solution {
      public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;

        for (int right = 0; right < n; right++) {

            // 1. Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            // 2. Remove elements smaller than current element
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            // 3. Add current index
            deque.offerLast(right);

            // 4. Record maximum once the first window is complete
            if (right >= k - 1) {
                result[idx++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
