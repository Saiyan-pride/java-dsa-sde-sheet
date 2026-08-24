import java.util.Scanner;

public class nextPermutation {
    public static void print(int[] arr, int n){
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        // logic

        int gola_idx = -1;

        for(int i=n-1; i>0; i--){
            if(arr[i]>arr[i-1]){
                gola_idx = i-1;
                break;
            }
        }

        if(gola_idx != -1){
            int swap_idx = gola_idx;
            for(int i=n-1; i>=gola_idx+1; i--){
                if(arr[i] > arr[gola_idx]){
                    swap_idx = i;
                    break;
                }
            }
            swap(arr, gola_idx, swap_idx);
        }

        reverse(arr, gola_idx+1, n-1);        

        print(arr, n);

        sc.close();
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverse(int[] arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
