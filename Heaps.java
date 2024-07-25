import java.util.ArrayList;
import java.util.List;

public class Heaps {

    private static void swap(List<Integer> heap, int l, int r){
        int temp=heap.get(l);
        heap.set(l,heap.get(r));
        heap.set(r,temp);
    }
    private static void push_up_in_minheap(List<Integer> heap,int index){  // Minheap
        int parent_index=(index-1)/2;
        if(index==0 || heap.get(parent_index)<heap.get(index)) return;

        // swap
        swap(heap,index,parent_index);
        push_up_in_minheap(heap,parent_index);
    }

    // When we delete in heap
    // 1) Swap first and last value
    // 2) Then, we push down in the heap till the all the elements are in their correct position
    private static void deleteFromMinheap(List<Integer> heap){
        swap(heap,0,heap.size()-1);
//        heap.remove(heap.size()-1);
        push_down_in_Minheap(heap,0,heap.size()-2);
    }

    // Heapify -> Building a heap
    private static void heapify(List<Integer> heap){
        int first_non_leaf_node= ((heap.size()-1)-1)/2; // Last element ka parent
        for (int i=first_non_leaf_node;i>=0;i--){
            push_down_in_Maxheap(heap,i,heap.size()-1);
        }
    }

    // Heap-Sort
    private static void heapSort(List<Integer> heap){
        // Convert into Max heap
        heapify(heap);
        for (int i=heap.size()-1;i>=0;i--){
            swap(heap,0,i);
            push_down_in_Maxheap(heap,0,i-1);
        }
    }

    private static void push_down_in_Minheap(List<Integer> heap,int index,int n){
        if(index==n) return;
        int left=(2*index)+1;
        int right=(2*index)+2;
        int smallest=index;
        if(left<=n && heap.get(left)<heap.get(index)){
            smallest=left;
        }
        if(right<=n && heap.get(right)<heap.get(smallest)){
            smallest=right;
        }
        if(smallest==index) return ;
        swap(heap,index,smallest);
        push_down_in_Minheap(heap,smallest,n);
    }

    private static void push_down_in_Maxheap(List<Integer> heap,int index,int n){
        if(index==n) return;
        int left=(2*index)+1;
        int right=(2*index)+2;
        int biggest=index;
        if(left<=n && heap.get(left)>heap.get(index)){
            biggest=left;
        }
        if(right<=n && heap.get(right)>heap.get(biggest)){
            biggest=right;
        }
        if(biggest==index) return ;
        swap(heap,index,biggest);
        push_down_in_Maxheap(heap,biggest,n);
    }
    private static void push_up_in_maxheap(List<Integer> heap,int index){  // Minheap
        int parent_index=(index-1)/2;
        if(index==0 || heap.get(parent_index)>heap.get(index)) return;

        // swap
        swap(heap,index,parent_index);
        push_up_in_maxheap(heap,parent_index);
    }

    private static void insert_in_Minheap(List<Integer> heap,int element){
        heap.add(element);
        int index=heap.size()-1;
        push_up_in_minheap(heap,index);
    }
    private static void insert_in_Maxheap(List<Integer> heap,int element){
        heap.add(element);
        int index=heap.size()-1;
        push_up_in_maxheap(heap,index);
    }
    public static void main(String[] args) {
        ArrayList<Integer> heap=new ArrayList<>();
        heap.add(60);
        heap.add(50);
        heap.add(40);
        heap.add(30);
        heap.add(20);
        System.out.println(heap);
        heapSort(heap);
        System.out.println(heap);
    }
}
