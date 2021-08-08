package worksAp;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/15/16.
 */
public class cG2 {
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
        long startTime = System.currentTimeMillis();
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        char_grid=new int[K][N*M];
        grid_size=N*M;
        for (int i=0;i<K;i++){
            br.readLine();
            int l=0;
            for (int j=0;j<N;j++){
                String s=br.readLine();
                for (int k=0;k<M;k++)
                    char_grid[i][l++]=Integer.parseInt(s.charAt(k)+"");
            }
        }
        s=new String[K];
        if(K==2) System.out.println(1);
        else if (K==3) System.out.println(2);
        else if (K==4){
            Arrays.fill(s,"");
            int max_diffed=pix4(2,0,0);
            if (max_diffed==K) System.out.println(2);
            else System.out.println(3);
        }
        else if (K==5){
            Arrays.fill(s,"");
            int max_diffed=pix4(3,0,0);
            if (max_diffed==K) System.out.println(3);
            else System.out.println(4);
        }
        else if (K==6){
            Arrays.fill(s,"");
            int max_diffed=pix4(3,0,0);
            if (max_diffed==K) System.out.println(3);
            else {
                Arrays.fill(s,"");
                max_diffed=pix4(4,0,0);
                if (max_diffed==K) System.out.println(4);
                else System.out.println(5);
            }
        }
        long endTime   = System.currentTimeMillis();
        //System.out.println(endTime-startTime);
        //System.exit(0);
    }

    private static int pix4(int len,int idx,int diffed) {
        if(s[0].length()==len){
            int[] count_bins=new int[16];
            for (int m=0;m<K;m++) {
                count_bins[Integer.parseInt(s[m],2)]++;
            }
            int differed=0;
            for (int m=0;m<count_bins.length;m++){
                if (count_bins[m]==1)
                    differed++;
            }
            diffed=Math.max(diffed,differed);
        } else {
            for (int i=idx+1;i<grid_size;i++){
                for (int j=0;j<K;j++){
                    s[j]=s[j]+char_grid[j][i];
                }
                diffed=Math.max(diffed,pix4(len,i,diffed));
                for (int j=0;j<K;j++){
                    s[j]=s[j].substring(0,s[j].length()-1);
                }
            }
        }
        return diffed;
    }
    private static String[] s;
    private static int[][] char_grid;
    private static int grid_size,N,M,K;
}
