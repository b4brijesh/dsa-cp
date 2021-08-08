package classical;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 05-01-2017.
 */
public class OLOLO {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        int xor=0;
        for (int i=0;i<n;i++){
            int k=Integer.parseInt(br.readLine());
            xor=xor^k;
        }
        System.out.println(xor);

        System.exit(0);
    }
}
