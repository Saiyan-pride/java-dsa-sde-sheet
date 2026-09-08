import java.io.*;
public class rabin_karp_algorithm {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int res = repeatedStringMatch(a, b);

        System.out.println(res);
        br.close();
    }
    public static  int  repeatedStringMatch(String a, String b){
        StringBuilder sb= new StringBuilder(a);
        int cnt =1;
        while(sb.length() < b.length()){
            sb.append(a);
            cnt++;
        }

        if(rabin_karp(sb.toString(), b)!=-1) return cnt;

        sb.append(a);
        cnt++;

        if(rabin_karp(sb.toString(), b)!=-1) return cnt;
        return -1;
    }
    public static int rabin_karp(String txt, String pat){
        int n = txt.length();
        int m = pat.length();
        if(m>n) return -1;
        int b=256, mod=101, h=1;
        int wh=0, ph=0;

        for(int i=0; i<m-1; i++) h=(h*b)%mod;

        for(int i=0; i<m; i++){
            wh=(wh*b + txt.charAt(i))%mod;
            ph=(ph*b + pat.charAt(i))%mod;
        }

        for(int i=0; i<n-m+1; i++){
            // checking first window hash code
            if(wh==ph){
                boolean match = true;
                for(int j=0; j<m; j++){
                    if(txt.charAt(i+j)!=pat.charAt(j)){
                        match = false;
                        break;
                    }
                }
                if(match) return i;
            }
            // next window slide -> rolling hash code
            if(i<n-m){
                wh = (wh - txt.charAt(i)*h)%mod;
                wh = (wh*b + txt.charAt(i+m))%mod;
                if(wh<0) wh+=mod;
            }
        }
        return -1;
    }
}
