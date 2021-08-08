package Others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 19-02-2017.
 */
public class OpGame {
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
        long[] val=new long[35];
        val[0]=1;
        for (int i=1;i<val.length;i++)
            val[i]=2*val[i-1];
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++) {
            int n=Integer.parseInt(br.readLine());
            long[] a=new long[n+40];
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++)
                a[j]=Integer.parseInt(st.nextToken());
            for (int j=0;j<a.length;j++) {
                //if (a[j]==0) continue;
                while (a[j]>1) {
                    int k=0;
                    while (a[j]>=val[k]) {
                        k++;
                    }
                    long quo=a[j]/val[k-1];
                    long rem=a[j]%val[k-1];
                    a[j+k-1]++;
                    a[j]=a[j]-val[k-1];
                }
            }
            long sum=0;
            for (int j=0;j<a.length;j++)
                sum+=a[j];
            System.out.println(sum);
        }

        System.exit(0);
    }
}
