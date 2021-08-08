package practice;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/13/16.
 */
public class maxsubarray {
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
            int[] arr=new int[n];
            st=new StringTokenizer(br.readLine().trim());
            for (int j=0;j<n;j++)
                arr[j]=Integer.parseInt(st.nextToken());
            int dp[]=new int[n];
            dp[0]=arr[0];
            int max_sum=dp[0],min_neg=dp[0],max=(arr[0]>0)?arr[0]:0;
            for (int j=1;j<n;j++){
                if (dp[j-1]+arr[j]>arr[j])
                    dp[j]=dp[j-1]+arr[j];
                else dp[j]=arr[j];
                max_sum=Math.max(max_sum,dp[j]);
                if (arr[j]>0) max+=arr[j];
                min_neg=Math.max(min_neg,arr[j]);
            }
            System.out.print(max_sum+" ");
            if (max==0) System.out.println(min_neg);
            else System.out.println(max);
        }

        System.exit(0);
    }
}
