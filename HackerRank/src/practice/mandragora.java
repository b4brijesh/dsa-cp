package practice;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/13/16.
 */
public class mandragora {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-practice.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine().trim());
        for (int i=1;i<=t;i++){
            int n=Integer.parseInt(br.readLine().trim());
            int[] h=new int[n];
            st=new StringTokenizer(br.readLine().trim());
            long sum=0;
            for (int j=0;j<n;j++){
                h[j]=Integer.parseInt(st.nextToken());
                sum+=h[j];
            }
            Arrays.sort(h);
            long s=1,max_p=Integer.MIN_VALUE,cum_sum=0;
            for (int j=0;j<=n;j++){
                long arr_sum=sum-cum_sum;
                max_p=Math.max(max_p,arr_sum*s);
                if (j!=n)
                    cum_sum+=h[j];
                s++;
            }
            System.out.println(max_p);
        }

        System.exit(0);
    }
}
