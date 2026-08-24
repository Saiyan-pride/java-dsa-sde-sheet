import java.util.Scanner;

public class buyAndSellStock {
    public static void main(String[] args) {
             Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        if(n==1){
            System.out.println(arr[0]);
            return;
        }

        int profit = 0;
        int i=0, j=i+1;
        while(j<n){
            if(arr[i]<arr[j]){
                int curr = arr[j] - arr[i];
                profit = Math.max(profit, curr);
                j++;
            }else{
                i++;
                j = i+1;
            }
        }


        for(int ele : arr) System.out.print(ele+" ");
        System.out.println();

        System.out.println(profit);
    }
}
