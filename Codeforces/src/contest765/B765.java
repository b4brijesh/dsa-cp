package contest765;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 14-02-2017.
 */
public class B765 {
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
        if (s.charAt(0)!='a') {
            System.out.println("NO");
            return;
        }
        char hi_char='a';
        boolean ptd=false;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i)<=hi_char) ;
            else if (s.charAt(i)==hi_char+1) hi_char++;
            else {
                System.out.println("NO");
                ptd=true;
                break;
            }
        }
        if (!ptd) System.out.println("YES");

        System.exit(0);
    }
}
