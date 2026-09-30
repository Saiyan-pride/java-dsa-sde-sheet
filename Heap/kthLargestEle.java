import java.util.*;
import java.io.*;
public class kthLargestEle {
    public static void main(String[] args) {
       try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int k = Integer.parseInt(br.readLine());
            String[] srr = br.readLine().split(" ");
            int n = srr.length;

            int[] arr = new int[n];
            for(int i=0; i<n; i++) arr[i] = Integer.parseInt(srr[i]);

            int res = kthlargest(arr, k);
            System.out.println(res);

            int res2 = kthsmallest(arr, k);
            System.out.println(res2);
       } catch (Exception e) {
            System.out.println("invalid input");
       }
    }
    public static int kthlargest(int[] arr, int k){
        if(k>arr.length) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : arr){
            pq.add(ele);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek();
    }
    public static int kthsmallest(int[] arr, int k){
        if(k>arr.length) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : arr){
            pq.add(ele);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek();
    }
}
