import java.util.*;
import java.io.*;
public class TwoSum {

    public static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
    public static int[] find(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            int need = target - arr[i];
            if(map.containsKey(need)){
                return new int[]{i, map.get(need)};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) throws IOException{
        FastScanner fc = new FastScanner();
        int n = fc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = fc.nextInt();
        int target = fc.nextInt();

        int[] res = find(arr, target);

        System.out.println(res[0]+" "+res[1]);
        
    }
}
