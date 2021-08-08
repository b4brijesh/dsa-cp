package round308;

import java.io.*;
import java.util.*;
public class B552 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int i,m;
        if(n<=9)
            System.out.println(n);
        else{
            m=(int)Math.log10(n);
            int sum=0;
            long sum2=0;
            for(i=0;i<m;i++) {
                sum=sum+(9 * (int) Math.pow(10, i));
                sum2=sum2+((i+1)*9 * (long) Math.pow(10, i));
            }
            n=n-sum;
            sum2=sum2+((i+1)*n);
            System.out.println(sum2);
        }
    }
}
