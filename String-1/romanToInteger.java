import java.io.*;
import java.util.HashMap;
public class romanToInteger {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();


        int res = romToInt(s);

        System.out.println((res==-1)?"invalid string": res);
    }
    public static int romToInt(String s){
        int n  = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10);
        map.put('L', 50); map.put('C', 100); map.put('D', 500);
        map.put('M', 1000);

        for(int i=0; i<n; i++){
            char c  = s.charAt(i);
            if(!map.containsKey(c))
                return -1;
        }
        int res = 0;
        for(int i=0; i<n-1; i++){
            char c = s.charAt(i);
            char nx = s.charAt(i+1);
            if(map.get(c)<map.get(nx)) res -= map.get(c);
            else res += map.get(c);
        }
        res += map.get(s.charAt(n-1));
        return res;
    }
}
