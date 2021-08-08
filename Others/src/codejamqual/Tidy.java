package codejamqual;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 08-04-2017.
 */
public class Tidy {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static long INF=1000000000000000L;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new FileReader(d_loc2+"B-large.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++) {
            String s=br.readLine();
            int[] a=new int[s.length()];
            for (int j=0;j<s.length();j++)
                a[j]=Integer.parseInt(""+s.charAt(j));
            for (int j=1;j<s.length();j++) {
                if (a[j]<a[j-1]) {
                    int m=j;
                    do {
                        m--;
                        a[m]--;
                    } while ((m-1>=0 && a[m]<a[m-1]));
                    for (int k=m+1;k<s.length();k++)
                        a[k]=9;
                    break;
                }
            }
            String s2="";
            for (int j=0;j<s.length();j++)
                s2+=a[j];
            System.out.print("Case #"+i+": ");
            System.out.println(Long.parseLong(s2));
        }

        System.exit(0);
    }
}
