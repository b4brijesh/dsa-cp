package feb16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 14-02-2016.
 */
public class RECTLOVE {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            Pair[] arr=new Pair[K];
            for(int j=0;j<K;j++){
                long num=Long.parseLong(st.nextToken());
                long col=((num-1)%(long) M)+1L;
                long row=(num-1)/(long) M+1L;
                arr[j]=new Pair(row,col);
            }
            BigInteger tot=BigInteger.valueOf(N+1).multiply(BigInteger.valueOf(N))
                    .multiply(BigInteger.valueOf(M)).multiply(BigInteger.valueOf(M+1))
                    .divide(BigInteger.valueOf(4));
            /*long tot1=(long)(N+1)*(long)N/(long)2;
            long tot2=(long)(M+1)*(long)M/(long)2;*/
            BigDecimal dt=new BigDecimal(tot);
            BigDecimal sum=BigDecimal.ZERO;
            //double sum=0.0;
            for(int j=0;j<K;j++){
                long x=Pair.getX(arr[j]);
                long y=Pair.getY(arr[j]);
                //System.out.println("x"+x+"y"+y);
                BigInteger h=BigInteger.valueOf(x).multiply(BigInteger.valueOf(y))
                        .multiply(BigInteger.valueOf(N+1-x)).multiply(BigInteger.valueOf(M+1-y));
                BigDecimal d=new BigDecimal(h);
                /*long h=(long)x*(long)y*(long)(N+1-x)*(long)(M+1-y);
                double d=((double) h/(double) tot1)/(double) tot2;*/
                //System.out.println("d"+d.longValue());
                //sum=sum+d;
                d=d.divide(new BigDecimal(tot),100,RoundingMode.HALF_UP);
                sum=sum.add(d);
            }
            System.out.println(sum.doubleValue());
        }
    }
    private static class Pair{
        long a;long b;
        public Pair(long x,long y){a=x;b=y;}
        public static long getX(Pair p){return p.a;}
        public static long getY(Pair p){return p.b;}
    }
}
