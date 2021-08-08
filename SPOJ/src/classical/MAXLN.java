package classical;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 05-01-2017.
 */
public class MAXLN {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++){
            long r=Long.parseLong(br.readLine());
            double dr=r;
            System.out.println("Case "+(i+1)+": "+(4*dr*dr+0.25));
        }

        System.exit(0);
    }
}
