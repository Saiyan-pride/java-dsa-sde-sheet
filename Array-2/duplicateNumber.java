import java.util.Scanner;

public class duplicateNumber{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] freq = new int[n+1];
        for(int i=0; i<n+1; i++) arr[i] = sc.nextInt();
        for(int i=0; i<n+1; i++){
            freq[arr[i]]++;
        }
        for(int i=0; i<n+1; i++)
            if(freq[i]>1){
                System.out.println(i);
                sc.close();
                return;
            }
        System.out.println("none");
        sc.close();
    }
}