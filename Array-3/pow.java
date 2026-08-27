import java.util.Scanner;

public class pow {
    public static double findPow(double x, int n){
        long N = n;
        if(N<0){
            x = 1/x;
            N = -n;
        }
        return power(x, N);
    }
    public static double power(double x, long n){
        if(n==0) return 1.0;
        if(n==1) return x;
        if(n%2==0) return power(x*x, n/2);
        else return x*power(x, n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();

        double res = findPow(x, n);

        System.out.println(res);

        sc.close();
    }
}
