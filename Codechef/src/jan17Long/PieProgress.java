package jan17Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 15-01-2017.
 */
public class PieProgress {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cases=Integer.parseInt(br.readLine().trim());
        for (int i=1;i<=cases;i++){
            st=new StringTokenizer(br.readLine().trim());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int[] extra=new int[m];
            extra[0]=1;
            for (int j=2;j<=m;j++)
                extra[j-1]=(int)Math.pow(j,2)-(int)Math.pow(j-1,2);
            long[][] cost=new long[n][m];
            for (int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine().trim());
                for (int k=0;k<m;k++)
                    cost[j][k]=Integer.parseInt(st.nextToken());
                Arrays.sort(cost[j]);
                for (int k=0;k<m;k++)
                    cost[j][k]=cost[j][k]+extra[k];
            }
            long sum=0;
            int[] ctr=new int[n];
            for (int j=0;j<n;j++){
                long min=Integer.MAX_VALUE;
                int mini=-1;
                for (int k=0;k<=j;k++){
                    if (ctr[k]==m) continue;
                    if (cost[k][ctr[k]]<min){
                        min=cost[k][ctr[k]];
                        mini=k;
                    }
                }
                sum+=min;
                ctr[mini]++;
            }
            System.out.println("Case #"+i+": "+sum);
        }

        System.exit(0);
    }
}
