package icpc17online;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/22/16.
 */
public class A {
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
        int t=Integer.parseInt(br.readLine().trim());
        for (int i=0;i<t;i++){
            int d=Integer.parseInt(br.readLine());
            int x=d%9;
            System.out.println(x+1);
        }

        System.exit(0);
    }
}
