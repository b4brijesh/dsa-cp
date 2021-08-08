package worksAp;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/15/16.
 */
public class charRecog {
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
        if(K==2) System.out.println(1);
        else if (K==3) System.out.println(2);
        else if (K==4){
            boolean found_in_2=pix2();
            if (!found_in_2) System.out.println(3);
        }
        else if (K==5){
            boolean found_in_3=pix3();
            if (!found_in_3) System.out.println(4);
        }
        else if (K==6){
            boolean found_in_3=pix3();
            if (!found_in_3){
                boolean found_in_4=pix4();
                if (!found_in_4) System.out.println(5);
            }
        }
        long endTime   = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        //System.exit(0);
    }

    private static boolean pix4() {
        boolean found=false;
        outer:for (int i=0;i<grid_size;i++){
            for (int j=i+1;j<grid_size;j++){
                for (int k=j+1;k<grid_size;k++){
                    for (int l=k+1;l<grid_size;l++){
                        int[] count_bins=new int[16];
                        for (int m=0;m<K;m++) {
                            String s=char_grid[m][i]+""+char_grid[m][j]+""
                                    +char_grid[m][k]+""+char_grid[m][l];
                            count_bins[Integer.parseInt(s,2)]++;
                        }
                        int diffed=0;
                        for (int m=0;m<count_bins.length;m++){
                            if (count_bins[m]==1)
                                diffed++;
                        }
                        if (diffed==K){
                            found=true;
                            System.out.println(4);
                            break outer;
                        }
                    }
                }
            }
        }
        return found;
    }

    private static boolean pix3(){
        boolean found=false;
        outer:for (int i=0;i<grid_size;i++){
            for (int j=i+1;j<grid_size;j++){
                for (int k=j+1;k<grid_size;k++){
                    int[] count_bins=new int[8];
                    for (int m=0;m<K;m++) {
                        String s=char_grid[m][i]+""+char_grid[m][j]+""
                                +char_grid[m][k];
                        count_bins[Integer.parseInt(s,2)]++;
                    }
                    int diffed=0;
                    for (int m=0;m<count_bins.length;m++){
                        if (count_bins[m]==1)
                            diffed++;
                    }
                    if (diffed==K){
                        found=true;
                        System.out.println(3);
                        break outer;
                    }
                }
            }
        }
        return found;
    }
    private static boolean pix2(){
        boolean found=false;
        outer:for (int i=0;i<grid_size;i++){
            for (int j=i+1;j<grid_size;j++){
                int[] count_bins=new int[4];
                for (int m=0;m<K;m++) {
                    String s=char_grid[m][i]+""+char_grid[m][j];
                    count_bins[Integer.parseInt(s,2)]++;
                }
                int diffed=0;
                for (int m=0;m<count_bins.length;m++){
                    if (count_bins[m]==1)
                        diffed++;
                }
                if (diffed==K){
                    found=true;
                    System.out.println(2);
                    break outer;
                }
            }
        }
        return found;
    }
    private static int[][] char_grid;
    private static int grid_size,N,M,K;
}
