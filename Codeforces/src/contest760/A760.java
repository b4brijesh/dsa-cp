package contest760;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 22-01-2017.
 */
public class A760 {
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
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12 ) {
            if (d>5) System.out.println(6);
            else System.out.println(5);
        } else if (m==2) {
            if (d==1) System.out.println(4);
            else System.out.println(5);
        } else {
            if (d>6) System.out.println(6);
            else System.out.println(5);
        }

        System.exit(0);
    }
}
