import java.util.Arrays;
import java.util.Scanner;

public class MaxLengthConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = s.length;
        int[] a = new int[n];

        for(int i=0; i<n; i++) a[i] = Integer.parseInt(s[i]);


        int longest = 0;

        // longest = bruteForce(a);
        longest  = better(a);

        System.out.println(longest);
        sc.close();
    }
    public static int bruteForce(int[] arr){
        int longest = 1;
        for(int i=0; i<arr.length; i++){
            int x = arr[i];
            int cnt = 1;
            while(ls(arr, x+1)){
                x = x+1;
                cnt = cnt+1;
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
    public static boolean ls(int[] arr, int k){
        for(int ele : arr){
            if(ele==k) return true;
        }
        return false;
    }
    public static int better(int[] a){
        int longest = 1, cnt = 0, lastSmallest = Integer.MIN_VALUE;
        int[] temp = Arrays.copyOf(a, a.length);
        Arrays.sort(temp);

        for(int i=0; i<a.length; i++){
            if(temp[i]-1==lastSmallest){
                cnt += 1;
                lastSmallest = temp[i];
            }
            else if(temp[i]!=lastSmallest){
                cnt = 1;
                lastSmallest= temp[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}
