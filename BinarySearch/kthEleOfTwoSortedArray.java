import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kthEleOfTwoSortedArray {
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

        int k = Integer.parseInt(br.readLine());

        int res = kthElement(arr, brr,k);
        System.out.println(res);

    }
    public static  int kthElement(int a[], int b[], int k) {
        int[] res = merge(a, b);
        return res[k-1];
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
