package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 08-06-2017.
 */
public class B433 {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static long INF=1000000000000000L;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main(String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        long[] V = new long[n];
        st=new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++)
            V[i] = Long.parseLong(st.nextToken());
        long[] sum1 = new long[n];
        sum1[0] = V[0];
        for (int i=1; i<n; i++)
            sum1[i] = sum1[i-1] + V[i];
        Arrays.sort(V);
        long[] sum2 = new long[n];
        sum2[0] = V[0];
        for (int i=1; i<n; i++)
            sum2[i] = sum2[i-1] + V[i];
        int m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (type == 1) {
                System.out.println(sum1[r-1] - ((l>1) ?sum1[l-2] :0));
            } else {
                System.out.println(sum2[r-1] - ((l>1) ?sum2[l-2] :0));
            }
        }

        System.exit(0);
    }

}
