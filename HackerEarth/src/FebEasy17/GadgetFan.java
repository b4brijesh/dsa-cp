package FebEasy17;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 2/1/17.
 */
public class GadgetFan {
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
        for (int i=0;i<t;i++) {
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            long sum=0;
            if (n<k/2) {
                sum=n*(n+1)/2;
            } else {
                int mpv=k/2;

            }
            System.out.println(sum);
        }

        System.exit(0);
    }
}
