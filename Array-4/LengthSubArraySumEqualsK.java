import java.util.*;
import java.io.*;
public class LengthSubArraySumEqualsK {

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
        int len = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                if(sum==k) len = Math.max(len, j-i+1);
            }
        }
        return len;
    }

    public static int slidingWindow(int[] a, int n, int k){
        int res = 0, left = 0, right = 0;
        int sum = a[0];
        
        while(right<n){
            while(left<=right && sum>k){
                sum -= a[left];
                left++;
            }
            if(sum==k) res = Math.max(res, right-left+1);
            right++;
            if(right<n) sum+=a[right];
        }
        return res;
    }
    
    public static void main(String[] args) throws IOException{
        FastScanner fc = new FastScanner();
        int n = fc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = fc.nextInt();
        int k = fc.nextInt();
        // int len = bruteForce(arr, n, k);

        // for positive element only
        int len = slidingWindow(arr, n, k);

        // as arr may contains neg elements - can't use sliding window

        // optimal - coming soon

        System.out.println(len);
    }
}
