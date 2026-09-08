import java.io.*;
public class longestPalindromicSubstring {
    public static String OPfind(String s){
        String res = "";
        int len= 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            // odd length 
            int lo=i, hi=i;
            while(lo>=0 && hi<n && s.charAt(lo)==s.charAt(hi)){
                if(hi-lo+1 > len){
                    len = hi-lo+1;
                    res = s.substring(lo, hi+1);
                }
                lo-=1; hi+=1;
            }
            // even length
            lo=i; hi=i+1;
            while(lo>=0 && hi<n && s.charAt(lo)==s.charAt(hi)){
                if(hi-lo+1 > len){
                    len = hi-lo+1;
                    res = s.substring(lo, hi+1);
                }
                lo-=1; hi+=1;
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();


        // String res1 = BruteForce(s);
        String res2 = OPfind(s);
        System.out.println(res2);
    }
    public static String BruteForce(String s){
        StringBuilder sb = new StringBuilder(s);
        int len = 0;
        int start = 0, end =0;
        int n = s.length();
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
            if(isPali(i, j, sb)){
                if(j-i+1 > len){
                len = j-i+1;
                start = i;
                end = j;
                }
            }
            }
        }
        return sb.substring(start, end+1).toString();
    }
    public static boolean isPali(int i, int j, StringBuilder sb){
        while(i<=j){
        if(sb.charAt(i)!=sb.charAt(j)) return false;
        i++;j--;
        }
        return true;
    }
    
}
