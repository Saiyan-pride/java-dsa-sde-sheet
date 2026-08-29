import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class majorityElementTwo {
    public static ArrayList<Integer> find(int[] arr, int n){
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : arr) map.put(ele, map.getOrDefault(ele, 0)+1);
        for(int ele: arr){
            if(map.get(ele)>n/3 && !res.contains(ele))
                res.add(ele);
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] input = br.readLine().trim().split("\\s+");

        int n = input.length;

        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(input[i]);

        ArrayList<Integer> res = find(arr, n);

        for(int i=0; i<res.size(); i++)
            out.print(res.get(i)+" ");

        out.println();

        out.flush();
        out.close();
        br.close();
    }
}
