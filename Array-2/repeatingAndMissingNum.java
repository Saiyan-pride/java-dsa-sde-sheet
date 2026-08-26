import java.util.*;

public class repeatingAndMissingNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int missing = -1, repeating  = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : arr) map.put(ele, map.getOrDefault(ele, 0)+1);

        for(int i=1; i<=n; i++){
            int ele = i;
            if(!map.containsKey(ele)) missing = ele;
            if(map.containsKey(ele) && map.get(ele)>1) repeating = ele;
        }

        int[] res = new int[]{repeating, missing};

        for(int i=0; i<2;i++) System.out.print(res[i]+" ");
        sc.close();
    }
}
