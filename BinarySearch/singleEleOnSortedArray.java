import java.io.*;
public class singleEleOnSortedArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = br.readLine().split("\\s+");

        int[] arr = new int[srr.length];
        for(int i=0; i<srr.length; i++)
            arr[i] = Integer.parseInt(srr[i]);

        int res = singleNonDuplicate(arr);

        System.out.println(res);
    }
    public static int singleNonDuplicate(int[] nums) {
        int res = 0;
        for(int ele : nums) res ^= ele;
        return res;
    }
}
