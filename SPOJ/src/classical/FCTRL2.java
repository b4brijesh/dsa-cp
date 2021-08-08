package classical;

import java.io.*;
import java.math.BigInteger;

public class FCTRL2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cases=Integer.parseInt(br.readLine());
        int i,j,k,l;
        BigInteger p=BigInteger.ONE;
        BigInteger arr[]=new BigInteger[101];
        for(i=0;i<101;i++)
            arr[i]=BigInteger.ZERO;
        arr[1]=BigInteger.ONE;
        for(i=1;i<=cases;i++){
            j=Integer.parseInt(br.readLine());
            k=j;
            while(k>=2 && arr[k]==BigInteger.ZERO)
                k--;
            for(l=k+1;l<=j;l++){
                arr[l]=arr[l-1].multiply(BigInteger.valueOf(l));
            }
            System.out.println(arr[j].toString());
        }
    }
}
