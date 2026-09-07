class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num: nums) {
            maxHeap.offer(num);
        }
        int i=0;
        while(i<k-1){
            maxHeap.poll();
            i++;
        }
        return maxHeap.poll();
    }
}
