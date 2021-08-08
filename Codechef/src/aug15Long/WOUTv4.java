package aug15Long;

import java.io.*;
import java.util.*;
public class WOUTv4 {
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
            int row1=0,col;
            int row2=hi[0],k=row2;
            for(col=0;col<n;col++){
                for(j=row1;j<lo[col];j++)
                    blocks[j]=blocks[j]+(n-col);
                row1=j;
                if(col==n-1){
                    for (k = row2+1;k<n; k++)
                        blocks[k] = blocks[k] + col + 1;
                }
                else if(hi[col]<hi[col+1]) {
                    for (k = row2+1;k<=hi[col+1]; k++)
                        blocks[k] = blocks[k] + col + 1;
                    k--;
                }
                row2=k;
            }
            int r=(hi[n-1]+h<n-h)?hi[n-1]+h:n-h;
            for(j=(lo[0]-h<0)?0:lo[0]-h;j<=r;j++) {
                long count = 0;
                for (row1 = j;row1<j+h; row1++)
                    count=count+blocks[row1];
                min=Math.min(count,min);
            }
            System.out.println(min);
        }
    }
}
