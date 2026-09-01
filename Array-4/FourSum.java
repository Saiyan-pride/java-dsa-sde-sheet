import java.util.*;

public class FourSum {

   public static List<List<Integer>> find(int[] nums, int target){
     List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<n; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int lo = j+1, hi = n-1;
                while(lo < hi){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[lo] + (long)nums[hi];
                    if(sum<(long)target) lo++;
                    else if(sum>(long)target) hi--;
                    else{
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while(lo<hi && nums[lo]== nums[lo+1]) lo++;
                        while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    }
                }
            }
        }
        return res;
   }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = s.length;
        int[] a = new int[n];

        for(int i=0; i<n; i++) a[i] = Integer.parseInt(s[i]);

        int target = sc.nextInt();

        List<List<Integer>> res = find(a, target);
        
        System.out.println(res);

        sc.close();
    }
}
