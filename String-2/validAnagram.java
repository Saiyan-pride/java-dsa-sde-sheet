import java.io.*;
// import java.util.Arrays;
// import java.util.HashMap;
public class validAnagram {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        boolean res = isAnagram(s, t);

        System.out.println(res);
    }
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
       
        int[] freq = new int[26];

        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }

        for(int f: freq){
            if(f!=0) return false ;
        }

        return true;

        // or

        // if(s.length() != t.length()) return false;
        // HashMap<Character,Integer> map = new HashMap<>();

        // for(int i=0; i<s.length(); i++){
        //     char c1 = s.charAt(i);
        //     map.put(c1, map.getOrDefault(c1, 0)+1);
        // }
        // for(int i=0; i<t.length(); i++){
        //     char c2 = t.charAt(i);
        //     if(map.containsKey(c2)) map.put(c2, map.get(c2)-1);
        // }

        // for(char key : map.keySet()){
        //     if(map.get(key)!=0) return false;
        // }
        // return true;

        // or

        // char[] c1 = s.toCharArray();
        // char[] c2 = t.toCharArray();

        // if(c1.length!=c2.length) return false;

        // Arrays.sort(c1);
        // Arrays.sort(c2);

        // for(int i=0; i<c1.length; i++){
        //     if(c1[i]!=c2[i]) return false;
        // }
        // return true;
    }
}
