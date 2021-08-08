package feb17Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 2/5/17.
 */
public class CHEFAPAR {
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
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++) {
            int n=Integer.parseInt(br.readLine());
            int[] a=new int[n];
            st=new StringTokenizer(br.readLine());
            int paid = 0;
            for (int j=0;j<n;j++) {
                a[j] = Integer.parseInt(st.nextToken());
                if (a[j]==1) paid+=1000;
            }
            int total=n*1100;
            int toPay=total-paid;
            for (int x : a) {
                if (x==1) toPay-=100;
                else break;
            }
            System.out.println(toPay);
        }

        System.exit(0);
    }
}
