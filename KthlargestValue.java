import java.util.Collections;
import java.util.PriorityQueue;

public class KthlargestValue {
    class KthLargest {
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k=k;
            minHeap = new PriorityQueue<>(k);
            for(int i=0;i<nums.length;i++) add(nums[i]);
        }

        public int add(int val) {
            minHeap.add(val);
            if(minHeap.size()>k){
                minHeap.poll();
            }

            return minHeap.peek();
        }
    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */

    public static void main(String[] args) {
        int [] nums={3,4,5,6,8};
//        System.out.println(findKthLargest(nums,3));
    }
}