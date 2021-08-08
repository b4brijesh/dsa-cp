package feb16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 06-02-2016.
 */
public class STROPR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            long m=Long.parseLong(st.nextToken());
            st=new StringTokenizer(br.readLine());
            long[] arr=new long[n+1];
            for(int j=1;j<=n;j++)
                arr[j]=Long.parseLong(st.nextToken());
            long[] ar2=new long[x+1];
            long y=m,z=1;
            ar2[1]=1;
            for (int j=2;j<=x;j++)
                /*ar2[j]=(BigInteger.valueOf(ar2[j-1]).multiply(BigInteger.valueOf(y++))
                        .divide(BigInteger.valueOf(z++)).mod(BigInteger.valueOf(1000000007L))).longValue();*/
                ar2[j]=(((ar2[j-1]*(y++%1000000007))%1000000007)*pow(z++,1000000005))%1000000007;
            int w=x;
            long sum=0;
            for (int j=1;j<=x;j++)
                /*sum=sum+(BigInteger.valueOf(ar2[j]).multiply(BigInteger.valueOf(arr[w--]))
                        .mod(BigInteger.valueOf(1000000007L))).longValue();*/
                sum=sum+((ar2[j]*(arr[w--]%1000000007))%1000000007);
            System.out.println(sum%1000000007);
        }
    }
    static long pow(long x,long n){
        long out=1;
        while(n>0){
            if(n%2!=0)
                out=(out*x)%1000000007;
            n=n/2;
            x=(x*x)%1000000007;
        }
        return out;
    }
}
