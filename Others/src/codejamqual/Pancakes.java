package codejamqual;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 08-04-2017.
 */
public class Pancakes {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static long INF=1000000000000000L;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new FileReader(d_loc2+"A-large.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++) {
            st=new StringTokenizer(br.readLine());
            String s=st.nextToken();
            int k=Integer.parseInt(st.nextToken());
            int[] a=new int[s.length()];
            for (int j=0;j<s.length();j++) {
                if (s.charAt(j)=='+')
                    a[j]=1;
                else a[j]=0;
            }
            int count=0;
            for (int j=0;j<s.length();j++) {
                if (a[j]==1) continue;
                if (j+k>s.length()) continue;
                count++;
                for (int l=j;l<j+k;l++) {
                    if (a[l]==1) a[l]=0;
                    else a[l]=1;
                }
                //System.out.println(Arrays.toString(a));
            }
            boolean f=true;
            for (int j=0;j<s.length();j++) {
                if (a[j]==0) {
                    f=false;
                    break;
                }
            }
            System.out.print("Case #"+i+": ");
            if (f) System.out.println(count);
            else System.out.println("IMPOSSIBLE");
        }

        System.exit(0);
    }
}
