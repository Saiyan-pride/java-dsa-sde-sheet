import java.util.*;

public class majorityElement {
    public static int find(int[] arr, int n){
        int cnt = 0;
        int ele = 0;
        for(int i=0; i<n; i++){
            if(cnt==0){
                cnt = 1;
                ele = arr[i];
            }else if(ele==arr[i]){
                cnt++;
            }else{
                cnt--;
            }
        }
        int cnt1=0;
        for(int itm : arr){
            if(itm==ele) cnt1++;
        }

        return (cnt1>n/2) ? ele : -1;
            
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        int res =-1;
        // brute force

        // Arrays.sort(arr);
        // res = arr[n/2];
        
        // optimal
         res = find(arr, n);

        System.out.println(res);
        sc.close();
    }
}
