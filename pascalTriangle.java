import java.util.ArrayList;
import java.util.Scanner;

public class pascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[n][n];

        // logic

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                arr[i][j] = 1;
                if(i>=2){
                    if(j!=0 && j!=i) arr[i][j]= arr[i-1][j]+arr[i-1][j-1];
                }
            }
        }

        for(int[] row: arr){
            for(int val : row)
                System.out.print(val+" ");
            System.out.println();
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                if(arr[i][j]!=0) tmp.add(arr[i][j]);
            }
            res.add(new ArrayList<>(tmp));
            tmp.clear();
        }

        System.out.println(arr[r-1][c-1]);

        System.out.println(res);

        sc.close();
    }
}
