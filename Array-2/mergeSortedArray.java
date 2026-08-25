import java.util.Scanner;

public class mergeSortedArray {
    public static void print(int[] arr, int n){
            for(int j=0; j<n; j++)
                System.out.print(arr[j]+" ");
            System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num1 = new int[n];
        int[] num2 = new int[m];
        for(int i=0; i<n; i++) num1[i] = sc.nextInt();
        for(int i=0; i<m; i++) num2[i] = sc.nextInt();

        if(n==0){
            print(num2, m);
            return;
        }
        if(m==0){
            print(num1, n);
            return;
        }

        int[] res = new int[n+m];

        int i=0, j=0, k=0;
        while(i<n && j<m){
            if(num1[i]<num2[j]){
                res[k++] = num1[i++];
            }else{
                res[k++] = num2[j++];
            }
        }
        while(i<n) res[k++] = num1[i++];
        while(j<m) res[k++] = num2[j++];

        print(res, n+m);

    }    
}
