import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class searchInRotatedSortedArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = br.readLine().split("\\s+");

        int[] arr = new int[srr.length];
        for(int i=0; i<srr.length; i++)
            arr[i] = Integer.parseInt(srr[i]);

        int k = Integer.parseInt(br.readLine());

        int res = search(arr, k);

        System.out.println(res);
    }
    public static  int search(int[] a, int x) {
        int n = a.length;
        int lo=0, hi=n-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(a[mid]==x) return mid;
            else if(a[mid]>a[n-1]){
                if(a[mid]>x){
                    if(a[0]>x) lo = mid+1;
                    else hi = mid-1;
                }
                else lo = mid+1;
            }
            else{
                if(a[mid]>x) hi = mid-1;
                else{
                    if(a[n-1]<x) hi = mid-1;
                    else lo = mid+1;
                }
            }
        }
        return -1;
    }
}
