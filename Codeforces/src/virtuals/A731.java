package virtuals;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/17/16.
 */
public class A731 {
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
        String s=br.readLine().trim();
        int prev_idx=0;
        int rots=0;
        for (int i=0;i<s.length();i++){
            int curr_idx=s.charAt(i)-97;
            int diff=Math.abs(curr_idx-prev_idx);
            if (diff>13) rots+=(26-diff);
            else rots+=diff;
            prev_idx=curr_idx;
        }
        System.out.println(rots);

        System.exit(0);
    }
}
