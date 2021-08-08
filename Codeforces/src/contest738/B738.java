package contest738;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 11/20/16.
 */
public class B738 {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] grid=new int[n][m];
        for (int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++)
                grid[i][j]=Integer.parseInt(st.nextToken());
        }
        int[] row_sum=new int[n];
        int[] left=new int[n];
        int[] col_sum=new int[m];
        int[] up=new int[m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==1){
                    row_sum[i]++;
                    col_sum[j]++;
                }
            }
        }
        int udpos=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==0){
                    /*if (i-1>=0 && grid[i-1][j]==1){
                        up[j]++;
                    }*/
                    if (up[j]!=0) udpos++;
                    if (col_sum[j]-up[j]!=0) udpos++;
                } else up[j]++;
            }
        }
        int lrpos=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==0){
                    /*if (j-1>=0 && grid[i][j-1]==1){
                        left[i]++;
                    }*/
                    //System.out.println(i+" "+j+" "+left[i]+" "+(row_sum[i]-left[i]));
                    if (left[i]!=0) lrpos++;
                    if (row_sum[i]-left[i]!=0) lrpos++;
                } else left[i]++;
            }
        }
        //System.out.println(lrpos);
        //System.out.println(udpos);
        System.out.println(udpos+lrpos);

        System.exit(0);
    }
}
