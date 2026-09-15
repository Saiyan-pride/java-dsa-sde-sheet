import java.io.*;

public class prob1 {

    
    public static int nthRoot(int n, int m) {
      
      int lo = 0, hi = m;
      while(lo <= hi){
          int mid = lo+(hi-lo)/2;
          int res = (int)Math.pow(mid, n);
          if(res==m) return mid;
          else if(res < m) lo = mid+1;
          else hi = mid-1;
      }
      return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int res = nthRoot(n, m);

        System.out.println( res);
    }
}