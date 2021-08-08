package march17Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 11-03-2017.
 */
public class EXTRAN {
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
        int t=Integer.parseInt(br.readLine());
        while (t-->0) {
            int n=Integer.parseInt(br.readLine());
            int[] a=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            boolean f=false;
            for (int i=1;i<n;i++) {
                if (a[i]==a[i-1]) {
                    f=true;
                    System.out.println(a[i]);
                    break;
                }
            }
            if (!f) {
                if (a[1]-a[0]>1) {
                    f=true;
                    System.out.println(a[0]);
                }
            }
            if (!f) {
                if (a[n-1]-a[n-2]>1) {
                    f=true;
                    System.out.println(a[n-1]);
                }
            }
        }

        System.exit(0);
    }
}
