package HackerEarth.JanCircuits17;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 26-01-2017.
 */
public class GoodString {
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
        String s=br.readLine();
        char[] str=s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int cnt = 0;
        for (int i=0; i<str.length; i++) {
            if (set.contains(str[i]))
                cnt++;
            else set.add(str[i]);
        }
        System.out.println(cnt);

        System.exit(0);
    }
}
