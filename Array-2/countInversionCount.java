import java.util.ArrayList;
import java.util.Scanner;

public class countInversionCount {
    public static int mergeSort(int[] arr, int low, int high){
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low+high)/2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += merge(arr, low, mid, high);

        return cnt;
    }
    public static int merge(int[] arr, int low, int mid, int high){
        int cnt = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        int left=low, right=mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                cnt += mid - left +1;
                right++;
            }
        }
        while(left <= mid) temp.add(arr[left++]);
        while(right <= high) temp.add(arr[right++]);
        for(int i=low; i<=high; i++) arr[i] = temp.get(i-low);
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        int cnt = 0;
        // brute force
        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++)
        //         if(arr[i]>arr[j]) cnt++;
        // }


        cnt = mergeSort(arr, 0, n-1);

        System.out.println(cnt);
        sc.close();
    }
}
