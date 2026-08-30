import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class reversePair {
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

    public static int mergeSort(int[] arr, int low, int high){
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low+high)/2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return cnt;
    }
    public static void merge(int[] arr, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();
        int i=low, j=mid+1;
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }else{
                temp.add(arr[j]);
                j++;
            }
        }
        while(i<=mid){
            temp.add(arr[i]);
            i++;
        }
        while(j<=high){
            temp.add(arr[j]);
            j++;
        }
        for(i=low; i<=high; i++) arr[i] = temp.get(i-low);
    }
    public static int countPairs(int[] arr, int low, int mid, int high){
        int cnt =0;
        int right = mid+1;
        for(int i=low; i<=mid; i++){
            while(right <= high && (long)arr[i]>2*(long)arr[right]){
                right++;
            }
            cnt += right-(mid+1);
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException{
        FastScanner fc = new FastScanner();
        int n = fc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = fc.nextInt();

        int res = mergeSort(arr, 0, n-1);

        System.out.println(res);
    }
}
