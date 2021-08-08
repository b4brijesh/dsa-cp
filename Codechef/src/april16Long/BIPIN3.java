package april16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 02-04-2016.
 */
public class BIPIN3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            //long n2=(long)n;
            //long k2=(long)k;
            BigInteger n2=BigInteger.valueOf((long)n);
            BigInteger k2=BigInteger.valueOf((long)k);
            BigInteger mod=BigInteger.valueOf(1000000007L);
            if(n==1)
                System.out.println(k);
            else{
                /*long m=pow(k2-1,n2-1);
                long q=(m*k2)%1000000007;
                System.out.println(q);*/
                BigInteger m=pow(k2.subtract(BigInteger.ONE),n2.subtract(BigInteger.ONE));
                BigInteger q=m.multiply(k2).mod(mod);
                System.out.println(q.intValue());
            }
        }
    }
    /*static long pow(long base,long exp){
        if(exp==1)
            return base;
        else if((exp%2)!=0)
            return (base*(pow(base*base,(exp-1)/2)))%1000000007;
        else return (pow(base*base,exp/2))%1000000007;
    }*/
    static BigInteger pow(BigInteger base,BigInteger exp){
        BigInteger mod=BigInteger.valueOf(1000000007L);
        if(exp.equals(BigInteger.ONE))
            return base;
        else if(exp.mod(BigInteger.valueOf(2L)).equals(BigInteger.ZERO))
            return pow(base.multiply(base).mod(mod),exp.divide(BigInteger.valueOf(2L))).mod(mod);
        else return base.multiply(pow(base.multiply(base).mod(mod),(exp.subtract(BigInteger.ONE))
                    .divide(BigInteger.valueOf(2L))).mod(mod)).mod(mod);
    }
}
