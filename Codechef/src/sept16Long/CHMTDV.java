package sept16Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 12-09-2016.
 */
public class CHMTDV {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        int p=Integer.parseInt(st.nextToken());
        int[][] A=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                A[i][j]=Integer.parseInt(st.nextToken());
        }
        long[] row_sum=new long[n];
        for(int i=0;i<n;i++){
            row_sum[i]=0;
            for (int j=0;j<n;j++)
                row_sum[i]+=A[i][j];
        }
        long[] col_sum=new long[n];
        for(int i=0;i<n;i++){
            col_sum[i]=0;
            for(int j=0;j<n;j++)
                col_sum[i]+=A[j][i];
        }
        ArrayList<Integer> row_border=partition(row_sum,p);
        ArrayList<Integer> col_border=partition(col_sum,p);
        for(int i=0;i<row_border.size();i++)
            System.out.print(row_border.get(i)+" ");
        System.out.println();
        for(int i=0;i<col_border.size();i++)
            System.out.print(col_border.get(i)+" ");
        System.out.println();
    }
    static ArrayList<Integer> partition(long[] arr,int parts){
        long[] cum_arr=new long[n+1];
        cum_arr[0]=0;
        for(int i=1;i<=n;i++)
            cum_arr[i]=arr[i-1]+cum_arr[i-1];
        long[][] dp=new long[n][parts+1];
        int[][] dpi=new int[n][parts+1];
        for(int i=0;i<n;i++){
            dp[i][0]=0;
            dp[i][1]=cum_arr[i+1];
            Arrays.fill(dpi[i],-1);
        }
        for(int i=1;i<n;i++){
            //find dp[i][j] for j from 1 to parts
            for(int j=2;j<=parts;j++){
                if(j>i+1)
                    break;
                long min=Long.MAX_VALUE;
                for(int k=i-1;k>=0;k--){
                    if(Math.max(dp[k][j-1],cum_arr[i+1]-cum_arr[k+1])<min){
                        min=Math.max(dp[k][j-1],cum_arr[i+1]-cum_arr[k+1]);
                        dpi[i][j]=k;
                    }
                }
                dp[i][j]=min;
            }
        }
        /*for(int i=0;i<n;i++){
            for (int j=0;j<=parts;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for (int j=0;j<=parts;j++)
                System.out.print(dpi[i][j]+" ");
            System.out.println();
        }*/
        ArrayList<Integer> border=new ArrayList<>();
        int next=dpi[n-1][parts];
        while(next>=0){
            //System.out.println(next+1);
            border.add(0,next+1);
            next=dpi[next][--parts];
        }
        return border;
    }
}
