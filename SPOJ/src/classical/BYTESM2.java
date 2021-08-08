package classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 29-02-2016.
 */
public class BYTESM2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int h=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            int[][] arr=new int[h][w];
            for (int j=0;j<h;j++){
                st=new StringTokenizer(br.readLine());
                for (int k=0;k<w;k++)
                    arr[j][k]=Integer.parseInt(st.nextToken());
            }
            int[][] dp=new int[h][w];
            for(int j=0;j<w;j++)
                dp[0][j]=arr[0][j];
            for(int j=1;j<h;j++){
                for(int k=0;k<w;k++){
                    if(k==0)
                        dp[j][k]=Math.max(dp[j-1][k],dp[j-1][k+1])+arr[j][k];
                    else if(k==w-1)
                        dp[j][k]=Math.max(dp[j-1][k],dp[j-1][k-1])+arr[j][k];
                    else dp[j][k]=Math.max(Math.max(dp[j-1][k-1],dp[j-1][k]),dp[j-1][k+1])+arr[j][k];
                }
            }
            int max=0;
            for (int j=0;j<w;j++)
                max=Math.max(max,dp[h-1][j]);
            System.out.println(max);
        }
    }
}
