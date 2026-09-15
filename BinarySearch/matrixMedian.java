// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class matrixMedian {
    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int m = Integer.parseInt(br.readLine());

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                mat[i][j] = sc.nextInt();
        }
        int res = median(mat);

        System.out.println(res);

        sc.close();
    }
    
    public static  int median(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] res = new int[n*m];
        int k=0, len = res.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                res[k++] = mat[i][j];
        }
        
        Arrays.sort(res);
        
        return (len %2!=0) ? res[len/2] : (res[len/2]+res[len/2 -1])/2;
    }
}
