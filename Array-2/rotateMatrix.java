import java.util.Scanner;

public class rotateMatrix {
    public static void print(int[][] arr, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
    public static void reverse(int[][] mat, int[][] trans, int i, int n){
        int lo=0, hi=n-1;
        while(lo < hi){
            int temp = trans[i][lo];
            trans[i][lo] = trans[i][hi];
            trans[i][hi] = temp;
            lo++;hi--;
        }
        for(int j=0; j<n; j++)
            mat[i][j] = trans[i][j];
    }
    public static void rotate(int[][] mat, int n){
        int[][] trans = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                trans[i][j] = mat[j][i];
        }
        for(int i=0; i<n; i++){
            reverse(mat, trans, i, n);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        // print(mat, n);
        rotate(mat, n);
        print(mat, n);
    }
}
