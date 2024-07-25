import java.util.PriorityQueue;

class KthLargestValueInStreamOfNumbers {
    private PriorityQueue<Integer> minheap;
    private int k;

    public KthLargestValueInStreamOfNumbers(int k, int[] nums) {
        this.k = k;
        this.minheap = new PriorityQueue<>();
        for (int i = 0; i < k && i < nums.length; i++) {
            minheap.add(nums[i]);
        }
    }

    public int findKthLargest(int num) {
        if (minheap.size() < k) {
            minheap.add(num);
        } else if (minheap.peek() < num) {
            minheap.poll();
            minheap.add(num);
        }
        return minheap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {10, 7, 11, 5, 27, 8, 9, 45};
        KthLargestValueInStreamOfNumbers kthlarge = new KthLargestValueInStreamOfNumbers(3, nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(kthlarge.findKthLargest(nums[i]));
        }
    }
}