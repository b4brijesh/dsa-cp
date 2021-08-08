package contest760;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 23-01-2017.
 */
public class B760 {
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
        int k=Integer.parseInt(st.nextToken());
        if (m==n) System.out.println(1);
        else {
            m-=n;
            int c=1;
            int x=2;
            m-=1;
            while (m>0) {
                //System.out.println(x+" "+m);
                if (x-k+1<=1 && x-n+k<=1) {
                    c+=2;
                } else if (x-k+1<=1 || x-n+k<=1) {
                    c++;
                } else {
                    x+=(m/c);
                    System.out.println(x);
                    System.exit(0);
                }
                if (m-c>=0)
                    x++;
                m-=c;
            }
            System.out.println(x);
        }

        System.exit(0);
    }
}
