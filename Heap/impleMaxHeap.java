import java.util.ArrayList;

public class impleMaxHeap {

    static class maxHeap { // similarly for minHeap
        ArrayList<Integer> arr;
        // Constructor
        public maxHeap() {
            // Initialize your data members
            arr = new ArrayList<>();
        }

        public void push(int x) {
            // Insert x into the heap
            arr.add(x);
        }

        public void pop() {
            // Remove the top (maximum) element
            if(arr.size()==0) return;
                int max = arr.get(0);
                int idx = 0;
                for(int i=1; i<arr.size(); i++){
                    if(max<arr.get(i)){
                        max = arr.get(i);
                        idx = i;
                    }
                }
            arr.remove(idx);
        }

        public int peek() {
            // Return the top element or -1 if empty
            if(arr.isEmpty()) return -1;
            int max = arr.get(0);
            for(int i=1; i<arr.size(); i++){
                max = Math.max(max, arr.get(i));
            }
            return max;
        }

        public int size() {
            // Return the number of elements in the heap
            return arr.size()   ;
        }
    }
    public static void main(String[] args) {
        maxHeap heap = new maxHeap();
        System.out.println(heap.size());
        System.out.println(heap.peek());
        heap.push(1);
        heap.push(3);
        heap.push(-2);

        System.out.println(heap.peek());
        heap.pop();
        System.out.println(heap.peek());
    }

    
}
