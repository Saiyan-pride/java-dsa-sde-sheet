import java.io.*;
public class stringToNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int res = find(s);

        System.out.println(res);
        br.close();
    }
    public static int find(String s){
        int i=0, n=s.length(), sign=1;
        long res = 0;
        while(i<n && s.charAt(i)==' ') i++;
        if(i==n) return 0;
        else if(s.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        else if(s.charAt(i)=='+') i++;
        while(i<n && Character.isDigit(s.charAt(i))){
            res = res*10 + s.charAt(i)-'0';
            if(res*sign > Integer.MAX_VALUE ) return Integer.MAX_VALUE;
            if(res*sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++; 
        }
        return (int)(res*sign);
    }
}
