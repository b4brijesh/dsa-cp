package practice;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/10/16.
 */
public class A698 {
    static double e_07=0.0000001;
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
        int n=Integer.parseInt(br.readLine());
        int[][] dp=new int[3][n+1];
        int[] a=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++)
            a[i]=Integer.parseInt(st.nextToken());
        dp[0][0]=dp[1][0]=dp[2][0]=0;
        for (int i=1;i<=n;i++){
            int min_01=Math.min(dp[0][i-1],dp[1][i-1]);
            int min_02=Math.min(dp[0][i-1],dp[2][i-1]);
            int min=Math.min(min_01,min_02);
            if(a[i-1]==0) dp[0][i]=dp[1][i]=dp[2][i]=min+1;
            else if (a[i-1]==1){
                dp[0][i]=dp[2][i]=min+1;
                dp[1][i]=min_02;
            } else if (a[i-1]==2){
                dp[0][i]=dp[1][i]=min+1;
                dp[2][i]=min_01;
            } else {
                dp[0][i]=min+1;
                dp[1][i]=min_02;
                dp[2][i]=min_01;
            }
        }
        System.out.println(Math.min(dp[0][n],Math.min(dp[1][n],dp[2][n])));

        System.exit(0);
    }
}
