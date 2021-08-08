package Others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 19-02-2017.
 */
public class CrossStreet {
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
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] a=new int[n][m];
        for (int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++)
                a[i][j]=Integer.parseInt(st.nextToken());
        }
        int[][] cost=new int[n][m];
        int[][] cum=new int[n][m];
        int min=Integer.MAX_VALUE;
        for (int i=1;i<=100;i++) {
            int ht=i;
            for (int j=0;j<n;j++) {
                for (int k=0;k<m;k++)
                    cost[j][k]=Math.abs(a[j][k]-ht);
            }
            cum[0][0]=cost[0][0];
            for (int j=0;j<n;j++) {
                for (int k=0;k<m;k++) {
                    if (j==0 && k==0) continue;
                    if (k==0) cum[j][k] = cost[j][k] + cum[j-1][k];
                    else if (j==0) cum[j][k] = cost[j][k] + cum[j][k-1];
                    else cum[j][k] = cost[j][k] + Math.min(cum[j][k-1],cum[j-1][k]);
                }
            }
            min=Math.min(min,cum[n-1][m-1]);
        }
        System.out.println(min);

        System.exit(0);
    }
}
