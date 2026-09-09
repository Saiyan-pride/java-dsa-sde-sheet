import java.io.*;
public class countAndSay {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String res = calc(n);

        System.out.println(res);
    }   
    public static String calc(int n){
         if(n==1) return "1";
        String s = calc(n-1)+'#';
        String res = "";
        int i=0, j=0;
        while(j<s.length()){
            if(s.charAt(i)==s.charAt(j)) j++;
            else{
                int  len = j-i;
                res = res + len;
                res = res+s.charAt(i);
                i=j;
            }
        }
        return res;
    } 
}
