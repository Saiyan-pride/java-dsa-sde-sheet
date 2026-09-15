import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class medianOfTwoSortedArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = br.readLine().split("\\s+");


        int[] arr = new int[srr.length];
        for(int i=0; i<srr.length; i++)
            arr[i] = Integer.parseInt(srr[i]);

        srr = br.readLine().split("\\s+");

        int[] brr = new int[srr.length];
        for(int i=0; i<srr.length; i++)
            brr[i] = Integer.parseInt(srr[i]);

        double res = findMedianSortedArrays(arr, brr);
        System.out.println(res);


    }
     public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = merge(nums1, nums2);
        int n = a.length;
        if(n%2!=0) return (double)a[n/2];
        else return (double)(a[n/2]+a[(n/2) -1])/2;
    }
    public static  int[] merge(int[] a, int[] b){
        int n = a.length, m= b.length;
        if(m==0) return a;
        else if(n==0) return b;
        else{
            int[] res = new int[m+n];
            int i=0, j=0, k=0;
            while(i<n && j<m){
                if(a[i]<b[j]){
                    res[k] = a[i];
                    i++; k++; 
                }else{
                    res[k] = b[j];
                    j++; k++;
                }
            }
            while(i<n) res[k++] = a[i++];
            while(j<m) res[k++] = b[j++];
            return res;
        }
    }
}
