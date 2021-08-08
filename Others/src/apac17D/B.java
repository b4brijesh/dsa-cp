package apac17D;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/16/16.
 */
public class B {
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
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++){
            System.out.println("Case #"+i+": ");
            st=new StringTokenizer(br.readLine());
            int R=Integer.parseInt(st.nextToken());
            int C=Integer.parseInt(st.nextToken());
            int[][][] dp=new int[R+1][C+1][5];
            int max_occ=0;

            System.out.println(max_occ);
        }

        System.exit(0);
    }
    static int fm(int[] arr){
        int max=0;
        for (int i=0;i<arr.length;i++)
            max=Math.max(max,arr[i]);
        return max;
    }
}
