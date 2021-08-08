package contest765;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 14-02-2017.
 */
public class C765 {
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
        int k=Integer.parseInt(st.nextToken());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int f=a/k;
        int fr=a%k;
        int s=b/k;
        int sr=b%k;
        if (fr!=0 && s==0) {
            System.out.println(-1);
            return;
        }
        if (sr!=0 && f==0) {
            System.out.println(-1);
            return;
        }
        System.out.println((long)(f) + (long)(s));

        System.exit(0);
    }
}
