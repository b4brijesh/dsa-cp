package FebEasy17;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 2/1/17.
 */
public class Dorsplen {
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
        int r,g,b;
        r=Integer.parseInt(st.nextToken());
        g=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        int count=0;
        count=Math.min(r,Math.min(g,b));
        int dr=r-count,db=g-count,dg=b-count;
        int d1,d2;
        if (dr==0) {
            d1=dg;
            d2=db;
        } else if (dg==0) {
            d1=dr;
            d2=db;
        } else {
            d1=dr;
            d2=dg;
        }
        if (d1%2!=0 && d2%2!=0) {
            count+=Math.min(d1,d2);
            if (d1<d2) {
                count+=(d2-d1)/2;
            } else count+=(d1-d2)/2;
        } else {
            count+=(d1+1)/2;
            count+=(d2+1)/2;
        }
        System.out.println(count);

        System.exit(0);
    }
}
