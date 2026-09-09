import java.io.*;
public class compareVersions {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String version1 = br.readLine();
        String version2 = br.readLine();

        int res = compareVersion(version1, version2);

        System.out.println(res);

    }
    public static int compareVersion(String version1, String version2){
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int maxLen = Math.max(s1.length, s2.length);

        for(int i=0; i<maxLen; i++){
            int v1 = i<s1.length ? Integer.parseInt(s1[i]) : 0;
            int v2 = i<s2.length ? Integer.parseInt(s2[i]) : 0;

            if(v1>v2) return 1;
            else if(v1<v2) return -1;
        }
        return 0;
    }
}
