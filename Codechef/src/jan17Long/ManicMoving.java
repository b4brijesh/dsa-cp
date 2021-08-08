package jan17Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 15-01-2017.
 */
public class ManicMoving {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static long INF=1000000000000000L;
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new FileReader(d_loc2+"manic_moving.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int n,m,k;
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());
            long[][] dis=new long[n+1][n+1];
            for(int j=0;j<=n;j++)
                for(int l=0;l<=n;l++)
                    dis[j][l]=INF;
            for(int j=0;j<m;j++) {
                st=new StringTokenizer(br.readLine());
                int a,b,g;
                a=Integer.parseInt(st.nextToken());
                b=Integer.parseInt(st.nextToken());
                g=Integer.parseInt(st.nextToken());
                dis[a][b]=g;
                dis[b][a]=g;
            }
            /*for(int j=1;j<=n;j++)
            {
                for(int l=1;l<=n;l++)
                    System.out.print(dis[j][l]+" ");
                System.out.println();
            }
            System.out.println();*/
            for(int j=1;j<=n;j++){
                for(int l=1;l<=n;l++){
                    if (j==l) dis[j][l]=0;
                    else {
                        for(int o=1;o<=n;o++)
                            if(dis[j][l]>dis[j][o]+dis[o][l])
                                dis[j][l]=dis[j][o]+dis[o][l];
                    }
                }
            }
            /*for(int j=1;j<=n;j++)
            {
                for(int l=1;l<=n;l++)
                    System.out.print(dis[j][l]+" ");
                System.out.println();
            }*/
            int[] s=new int[k+1];
            int[] d=new int[k+1];
            for (int j=1;j<=k;j++){
                st=new StringTokenizer(br.readLine());
                s[j]=Integer.parseInt(st.nextToken());
                d[j]=Integer.parseInt(st.nextToken());
            }
            long[][] dp=new long[k+1][2];//dest
            long[][] dp2=new long[k+1][2];//src
            //src1
            if (k==1){
                System.out.print("Case #"+i+": ");
                if (dis[1][s[1]]+dis[s[1]][d[1]]>=INF)
                    System.out.println(-1);
                else System.out.println(dis[1][s[1]]+dis[s[1]][d[1]]);
                continue;
            }
            dp2[1][0]=dp2[1][1]=0;
            //dest1
            dp[1][0]=dis[s[1]][d[1]];
            dp[1][1]=dis[s[1]][s[2]]+dis[s[2]][d[1]];
            //src2
            for (int j=2;j<=k;j++){
                dp2[j][0]=dp[j-1][0]+dis[d[j-1]][s[j]];
                dp2[j][1]=dp2[j-1][0]+dis[s[j-1]][s[j]];
                dp[j][0]=Math.min(dp[j-1][1]+dis[d[j-1]][d[j]],
                                    dp2[j][0]+dis[s[j]][d[j]]);
                if (j+1>k) dp[j][1]=INF;
                else
                    dp[j][1]=dp2[j][0]+dis[s[j]][s[j+1]]+dis[s[j+1]][d[j]];
            }
            System.out.print("Case #"+i+": ");
            if ((dp[k][0]+dis[1][s[1]])>=INF)
                System.out.println(-1);
            else System.out.println(dp[k][0]+dis[1][s[1]]);
        }
        System.exit(0);
    }
}
