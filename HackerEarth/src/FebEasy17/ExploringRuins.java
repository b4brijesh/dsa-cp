package FebEasy17;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 2/1/17.
 */
public class ExploringRuins {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static long INF=1000000000000000L;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String s=br.readLine().trim();
        char[] str=s.toCharArray();
        int n=str.length;
        char[] b =new char[n];
        for (int i=0;i<n;i++) b[i]=str[i];
        for (int i=0;i<s.length();i++) {
            if (b[i]=='?') {
                if (i-1>=0) {
                    if (i+1<n) {
                        if (b[i-1]=='a' || b[i+1]=='a') b[i]='b';
                        else b[i]='a';
                    } else {
                        if (b[i-1]=='a') b[i]='b';
                        else b[i]='a';
                    }
                } else {
                    if (i+1<n) {
                        if (b[i+1]=='a') b[i]='b';
                        else b[i]='a';
                    } else {
                        b[i]='a';
                    }
                }
            }
        }
        System.out.println(new String(b));

        System.exit(0);
    }
}
