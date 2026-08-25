import java.util.*;

public class mergeIntervals {
    public static void print(int[][] arr, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
    public static ArrayList<int[]> mergeInterval(int[][] arr, int n){
        Arrays.sort(arr, (a,b)-> a[0] - b[0]);
        int start1 = arr[0][0];
        int end1 = arr[0][1];
        ArrayList<int[]> res = new ArrayList<>();
        for(int i=1; i<n; i++){
            int start2 = arr[i][0];
            int end2 = arr[i][1];
            if(end1 >= start2){
                end1 = Math.max(end2, end1);
                continue;
            }
            res.add(new int[]{start1, end1});  
            start1 = start2;
            end1 = end2;
        }
        res.add(new int[]{start1, end1});
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];

        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++)
                intervals[i][j] = sc.nextInt();
        }

        // print(intervals, n);

       ArrayList<int[]> res =  mergeInterval(intervals, n);
       
       for(int[] ele : res)
            System.out.print("["+ele[0]+" "+ele[1]+"]");
        System.out.println();

    }
}
