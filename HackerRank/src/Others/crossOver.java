package Others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 30-03-2017.
 */
public class crossOver {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static long INF=1000000000000000L;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        int n=Integer.parseInt(br.readLine());
        int[] p=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++)
            p[i]=Integer.parseInt(st.nextToken());
        double[] stma=new double[n];
        double[] ltma=new double[n];
        double fs=0d;
        for (int i=0;i<59;i++)
            fs+=p[i];
        for (int i=59;i<n;i++) {
            fs+=p[i];
            stma[i]=Double.parseDouble(df.format(fs/60d));
            fs-=p[i-59];
        }
        fs=0;
        for (int i=0;i<299;i++)
            fs+=p[i];
        for (int i=299;i<n;i++) {
            fs+=p[i];
            ltma[i]=Double.parseDouble(df.format(fs/300d));
            fs-=p[i-299];
        }
        for (int i=300;i<n;i++) {
            if ((stma[i-1]>ltma[i-1] && stma[i]<=ltma[i]) ||
                    (stma[i-1]<ltma[i-1] && stma[i]>=ltma[i]) ||
                    (stma[i-1]==ltma[i-1] && stma[i]!=ltma[i]))
                System.out.println((i+1)+" "+stma[i]+" "+ltma[i]);
        }

        System.exit(0);
    }
}
