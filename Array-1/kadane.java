import java.util.Scanner;

public class kadane {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        // logic
        int maxSum = arr[0];
        int bestEnding = arr[0];
        int currentStart = 0;
        int bestStart = 0;
        int bestEnd = 0;
        for(int i=1; i<n; i++){
            int v1 = arr[i];
            int v2 = bestEnding+arr[i];

            // bestEnding = Math.max(v1, v2);
            // maxSum = Math.max(bestEnding, maxSum);

            if(v1 > v2){
                bestEnding = v1;
                currentStart = i;
            } else {
                bestEnding = v2;
            }

            if(bestEnding > maxSum){
                maxSum = bestEnding;
                bestStart = currentStart;
                bestEnd = i;
            }
        }


        System.out.println(maxSum);

        System.out.print("Maximum-sum subarray: ");
        for(int i=bestStart; i<=bestEnd; i++)
            System.out.print(arr[i] + " ");
        System.out.println();



        for(int ele : arr) System.out.print(ele + " ");
        System.out.println();
    }
}
