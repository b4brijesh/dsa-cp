package classical;

import java.io.*;
import java.math.*;

public class JULKA {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i;
        BigInteger s,d,a,b;
        for(i=1;i<=10;i++){
            s= new BigInteger(br.readLine());
            d= new BigInteger(br.readLine());
            a=s.add(d);
            b=s.subtract(d);
            a=a.divide(BigInteger.valueOf(2));
            b=b.divide(BigInteger.valueOf(2));
            System.out.println(a);
            System.out.println(b);
        }
    }
}
