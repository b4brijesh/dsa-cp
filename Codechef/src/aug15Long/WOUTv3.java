package aug15Long;

import java.io.*;
import java.util.*;
public class WOUTv3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i, j, n, h;
        for (i = 1; i <= t; i++) {
            long min=Long.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int[] lo = new int[n];
            int[] hi = new int[n];
            int[] blocks=new int[n];
            Arrays.fill(blocks, 0);
            for (j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                lo[j] = Integer.parseInt(st.nextToken());
                hi[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(lo);
            Arrays.sort(hi);
            int row=0,col;
            for(col=0;col<n;col++){
                for(j=row;j<lo[col];j++){
                    blocks[j]=blocks[j]+(n-col);
                }
                row=j;
            }
            row=n-1;
            for(col=n-1;col>=0;col--){
                for(j=row;j>hi[col];j--){
                    blocks[j]= blocks[j]+col+1;
                }
                row=j;
            }
            /*for(j=0;j<=n-h;j++) {
                long count=0;
                for (row=j;row<j+h;row++)
                    count=count+blocks[row];
                min=Math.min(count,min);
            }*/
            long[] sums=new long[n+1];
            sums[0]=0;
            for(j=1;j<=n;j++)
                sums[j]=sums[j-1]+blocks[j-1];
            j=h;
            long count;
            while(j<=n){
                count=sums[j]-sums[j-h];
                min=Math.min(min,count);
                j++;
            }
            System.out.println(min);
        }
    }
}
