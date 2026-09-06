import java.io.*;
public class reverseWord {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String rev = fun(s);
        System.out.println(rev);
    }
    public static String fun(String s){
         String[] arr = s.trim().split("\\s+");

        int i=0, j=arr.length-1;
        while(i<j){
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }

        StringBuilder sb = new StringBuilder();

        for(String str: arr)
            sb.append(str+" ");

        return sb.toString().trim();
    }
}
