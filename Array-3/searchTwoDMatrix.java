import java.util.Scanner;

public class searchTwoDMatrix {
    public static boolean search(int[][] arr, int n, int m, int k){
        int row = n-1;
        int col = 0;
        while(row>=0 && col<m){
            if(arr[row][col]==k) return true;
            else if(arr[row][col]>k) row--;
            else col++;
        }
        return false;
    }
    public static boolean binSearch(int[][] arr, int n, int m, int k){
        int lo = 0, hi = n*m-1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            int r = mid/m;
            int c = mid%m;
            if(arr[r][c]==k) return true;
            else if(arr[r][c]<k) lo = mid+1;
            else hi = mid-1;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();
        boolean res = false;
        
        // brute force
        
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         if(arr[i][j]==target){
        //             res = true;
        //             System.out.println(res);
        //             sc.close();
        //             return;
        //         }
        //     }
        // }

        //better 
        // res = search(arr, n, m, target);

        //optimal - binary search
        res = binSearch(arr, n, m, target);

        System.out.println(res);
        sc.close();
    }
}
