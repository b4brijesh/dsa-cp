package march16Challenge;
import java.io.*;
import java.util.*;
import java.lang.*;

public class EDIST {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String x=br.readLine();
            StringBuffer sb=new StringBuffer(x);
            String y=sb.reverse().toString();
            if(x == null || x.length() == 0 || y == null || y.length() == 0)
                System.out.println(0);

            char[] a = x.toCharArray();
            char[] b = y.toCharArray();

            int n = a.length;
            int m = b.length;

            int[][] dp = new int[n+1][m+1];
            int i, j;

            dp[0][0] = 0;

            for(i = 1; i <= n; i++) {
                dp[i][0] = dp[i-1][0] + 1;
            }

            for(i = 1; i <= m; i++) {
                dp[0][i] = dp[0][i-1] + 1;
            }

            for(i = 1; i <= n; i++) {
                for(j = 1; j <= m; j++) {
                    if(a[i-1] == b[j-1])  {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = dp[i-1][j-1] + 2;
                    }
                    if(dp[i-1][j] + 1 < dp[i][j]) {
                        dp[i][j] = dp[i-1][j] + 1;
                    }
                    if(dp[i][j-1] + 1 < dp[i][j]) {
                        dp[i][j] = dp[i][j-1] + 1;
                    }
                }
            }
            System.out.println(dp[n][m]/2);
        }
    }
}