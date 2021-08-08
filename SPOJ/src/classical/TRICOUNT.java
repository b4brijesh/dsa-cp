package classical;

import java.io.*;
import java.math.BigInteger;

public class TRICOUNT {
    //solved in C++
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int i;
        BigInteger b,w,e,l;
        for(i=1;i<=t;i++){
            int n=Integer.parseInt(br.readLine());
            b=BigInteger.valueOf(n);
            w=BigInteger.valueOf(2);
            e=BigInteger.valueOf(8);
            if(n%2==0)
                l=b.multiply(b.add(w)).multiply(b.multiply(w).add(BigInteger.ONE)).divide(e);
                //l=n*(n+2)*(2*n+1)/8;
            else
                l=b.multiply(b.add(w)).multiply(b.multiply(w).add(BigInteger.ONE)).divide(e);
            //l=(n*(n+2)*(2*n+1)-1)/8;
            System.out.println(l);
        }
    }
}
