package classical;

import java.io.*;
import java.math.BigInteger;

public class WILLITST {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n=BigInteger.valueOf(Long.parseLong(br.readLine()));
        long count=0;
        boolean flag=false;
        while(n.compareTo(BigInteger.ONE)==1){
            count++;
            if(count==Long.SIZE){
                System.out.println("NIE");
                flag=true;
                break;
            }
            if(n.mod(BigInteger.valueOf(2))==BigInteger.ZERO)
                n=n.divide(BigInteger.valueOf(2));
            else
                n=n.multiply(BigInteger.valueOf(3)).add(BigInteger.valueOf(3));
        }
        if(!flag)
            System.out.println("TAK");
    }
}
