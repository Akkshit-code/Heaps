import java.util.Collections;
import java.util.PriorityQueue;
public class priorityqueue {
    public static void minHeap(int [] nums){
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            heap.add(nums[i]);
            System.out.print(heap.peek()+" ");
        }
        System.out.println();
        for (int i=0;i<nums.length;i++){
            heap.poll();
            System.out.print(heap.peek() + " ");
        }
        System.out.println();
    }
    public static void maxHeap(int [] nums){
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<nums.length;i++){
            heap.add(nums[i]);
            System.out.print(heap.peek() + " ");
        }
        for(int i=0;i<nums.length;i++){
            heap.poll();
            System.out.print(heap.peek() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] nums={10,7,11,5,3,5,13,1};
        minHeap(nums);
//        maxHeap(nums);
    }
}
