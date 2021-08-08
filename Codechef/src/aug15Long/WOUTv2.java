package aug15Long;

import java.io.*;
import java.util.*;
public class WOUTv2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i,j,k,n,h;
        long count;
        for (i = 1; i <= t; i++) {
            long min = Long.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int[] lo = new int[n];
            int[] hi = new int[n];
            int[] cnt=new int[n];
            for (j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                lo[j] = Integer.parseInt(st.nextToken());
                hi[j] = Integer.parseInt(st.nextToken());
                for(k=0;k<lo[j];k++)
                    cnt[k]++;
                for(k=hi[j]+1;k<n;k++)
                    cnt[k]++;
            }
            for(j=0;j<=n-h;j++){
                count=0;
                for(k=j;k<j+h;k++)
                    count=count+cnt[k];
                min=Math.min(count,min);
            }
            System.out.println(min);
        }
    }
}
