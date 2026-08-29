import java.io.*;
import java.util.*;
public class countUniquePath {
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
    public static int find(int[][] arr, int i, int j, int n, int m){
        if(i==n-1 && j==m-1) return 1;
        if(i>=n || j>=m) return 0;
        else{
            return find(arr, i+1, j, n, m) + find(arr, i, j+1, n, m);
        }
    }
    public static int findOP(int[][] arr, int i, int j, int n, int m, int[][] dp){

        if(i==n-1 && j==m-1) return 1;
        if(i>=n || j>=m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        else{
            return dp[i][j] = find(arr, i+1, j, n, m) + find(arr, i, j+1, n, m);
        }
    }
    public static void main(String[] args) throws IOException{
        FastScanner fc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fc.nextInt();
        int m = fc.nextInt();

        int[][] mat = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = fc.nextInt();
            }
        }

        // logic
        
        // recursive
        // int cnt = find(mat, 0, 0, n, m);
        // out.println(cnt);

        // memoization
        int[][] dp = new int[n][m];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);

        int cnt1 = findOP(mat, 0, 0, n, m,  dp);
        out.println(cnt1);

        // for(int[] row: mat){
        //     for(int ele : row) out.print(ele+" ");
        //     out.println();
        // }

        out.flush();
        out.close();
    }
}
