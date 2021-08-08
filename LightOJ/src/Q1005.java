import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 10/4/16.
 */
public class Q1005 {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        BigInteger[][] nCr=new BigInteger[31][31];
        for(int i=0;i<31;i++){
            nCr[i][0]=BigInteger.ONE;
            nCr[i][1]=BigInteger.valueOf(i);
            nCr[i][i]=BigInteger.ONE;
        }
        for(int i=3;i<31;i++){
            for(int j=2;j<i;j++){
                nCr[i][j]=nCr[i-1][j].add(nCr[i-1][j-1]);
            }
        }
        BigInteger[] fac=new BigInteger[31];
        fac[0]=BigInteger.ONE;
        for(int i=1;i<31;i++)
            fac[i]=fac[i-1].multiply(BigInteger.valueOf(i));
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            if(k>n) System.out.println("Case "+i+": "+0);
            else {
                //System.out.println("Case "+i+": "+(nCr[n][k]*nCr[n][k]*fac[k]));
                /*BigInteger a=BigInteger.valueOf(nCr[n][k]);
                BigInteger b=BigInteger.valueOf(fac[k]);
                System.out.println("Case "+i+": "+(
                        a.multiply(a).multiply(b)
                ));*/
                System.out.println("Case "+i+": "+
                        (nCr[n][k].multiply(nCr[n][k]).multiply(fac[k])).toString());
            }
        }
    }
}
