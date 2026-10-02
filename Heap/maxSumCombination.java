import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class maxSumCombination {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] srr= br.readLine().split(" ");
            int n = srr.length;
            int[] a = new int[n];
            for(int i=0; i<n; i++) a[i] = Integer.parseInt(srr[i]);
            srr = br.readLine().split(" ");
            int[] b = new int[n];
            for(int i=0; i<n; i++) b[i] = Integer.parseInt(srr[i]);
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> res = find(a, b, k);
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
    public static ArrayList<Integer> find(int[] a, int[] b, int k){
        // brute force approach (TC=n^2*log(n^2), SC=n^2)
        // int n = a.length;
        // ArrayList<Integer> temp = new ArrayList<>();
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         int sum = a[i]+b[j];
        //         temp.add(sum);
        //     }
        // }
        // Collections.sort(temp, Collections.reverseOrder());

        // ArrayList<Integer> res = new ArrayList<>();
        // for(int i=0; i<k; i++)
        //     res.add(temp.get(i));
        // return res;
        
        // better approach (TC=n^2*log(k), SC=n^2)

        int n = a.length;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int curSum = a[i]+b[j];
                temp.add(curSum);
            }
        }
        
        // heap
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<n*n; i++){
            pq.add(temp.get(i));
            if(pq.size()>k) pq.poll();
        }
            
        while(!pq.isEmpty()) res.add(pq.poll());
        
        Collections.reverse(res);
        
        return res;
    }
}
