package classical;

import java.io.*;
import java.math.*;

public class CANDY3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int n,i,j;
        BigInteger s;
        BigInteger[] arr;
        for(i=1;i<=t;i++){
            if(br.readLine().compareTo("")!=0)
                break;
            n=Integer.parseInt(br.readLine());
            arr=new BigInteger[n];
            s=BigInteger.ZERO;
            for(j=0;j<n;j++) {
                arr[j] = new BigInteger(br.readLine());
                s=s.add(arr[j]);
            }
            if(s.mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
