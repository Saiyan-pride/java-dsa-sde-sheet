import java.io.*;
public class longestCommonPrefix {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String s = br.readLine();

        String[] str = s.trim().split("\\s+");

        String lcp = find(str);

        out.println(lcp);
        out.close();
    }
    public static String find(String[] str){
        if(str.length==1) return str[0];

        for(int i=0; i<str[0].length(); i++){
            char c = str[0].charAt(i);
            for(int j=1; j<str.length; j++){
                if(i==str[j].length() || str[j].charAt(i)!=c)
                    return str[0].substring(0, i);
            }
        }
        return str[0];
    }
}
