package classical;

import java.io.*;
import java.math.*;
import java.util.*;
public class AP2 {
    //solved in c++
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        int i,j;
        BigInteger x,y,z,m,n,a,d;
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            x=new BigInteger(st.nextToken());
            y=new BigInteger(st.nextToken());
            z=new BigInteger(st.nextToken());
            m=x.add(y);
            n=z.multiply(BigInteger.valueOf(2)).divide(m);
            System.out.println(n);
            d=m.subtract(x.multiply(BigInteger.valueOf(2))).divide(n.subtract(BigInteger.valueOf(5)));
            a=m.subtract(d.multiply(n.subtract(BigInteger.valueOf(1)))).divide(BigInteger.valueOf(2));
            for(j=0;j<Integer.parseInt(n.toString())-1;j++){
                System.out.print(a.toString()+" ");
                a=a.add(d);
            }
            System.out.println(a);
        }
    }
}
