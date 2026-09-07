class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        while(i<stones.length){
            heap.offer(stones[i]);
            i++;
        }

        while(heap.size()>1){
            int x=heap.poll();
            int y=heap.poll();
            if(y<x) {
                heap.offer(x-y);
            }
        }
        return heap.size()==1?heap.poll():0;

    }
}
