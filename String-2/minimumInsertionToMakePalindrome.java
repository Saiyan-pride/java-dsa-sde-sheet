import java.io.*;
import java.util.*;
public class minimumInsertionToMakePalindrome {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int ans = s.length() - longestPalindromeSubsequence(s);
        System.out.println(ans);
    }
    public static  int longestPalindromeSubsequence(String s) {
        return longestCommonSubsequence(s, rev(s));
    }
    public static  String rev(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public static int longestCommonSubsequence(String a, String b){
        StringBuilder x = new StringBuilder(a);
        StringBuilder y = new StringBuilder(b);
        int n = x.length(), m = y.length();
        int[][] dp = new int[n][m];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return lcs(n-1, m-1, x, y, dp);
    }
    public static int lcs(int i, int j, StringBuilder a, StringBuilder b, int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
            return dp[i][j] = 1+lcs(i-1, j-1, a,b, dp);
        else 
            return dp[i][j] = Math.max(lcs(i, j-1, a,b, dp), lcs(i-1, j, a,b, dp));
    }
}
