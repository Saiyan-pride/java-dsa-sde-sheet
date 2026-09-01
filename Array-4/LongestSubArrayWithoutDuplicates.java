import java.io.*;
import java.util.*;

public class LongestSubArrayWithoutDuplicates {

    public static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException{
            while(st==null || !st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }

    public static int find(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0, left = 0, n=s.length();

        for(int right=0; right<n; right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);
            int k = right-left+1;
            while(map.size()<k){
                char c1 = s.charAt(left);
                map.put(c1, map.get(c1)-1);
                if(map.get(c1)==0) map.remove(c1);
                left++;
                k = right-left+1;
            }
            int len = right-left+1;
            res = Math.max(res, len);
        }
        return res;
    }
    
    public static void main(String[] args) throws IOException{
        FastScanner fc = new FastScanner();
        String s = fc.next();

        int res = find(s);

        System.out.println(res);
    }
}
