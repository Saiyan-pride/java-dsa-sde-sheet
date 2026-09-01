import java.util.*;
import java.io.*;
public class SubArrayXOREqualsK {

    public static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException{
            while(st==null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }

    public static int bruteForce(int[] arr, int n, int k){
        int cnt = 0;
        for(int i=0; i<n; i++){
            int xor = 0;
            for(int j=i; j<n; j++){
                xor ^= arr[j];
                if(xor==k) cnt++;
            }
        }
        return cnt;
    }

    
    public static void main(String[] args) throws IOException{
        FastScanner fc = new FastScanner();
        int n = fc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = fc.nextInt();
        int k = fc.nextInt();
        
        int count = bruteForce(arr, n, k);

        // no monotonicity in XOR - can't use sliding window

        // optimal - coming soon

        System.out.println(count);
    }
}

