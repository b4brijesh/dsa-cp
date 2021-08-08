package march17Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 11-03-2017.
 */
public class BANDMATR {
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
            int[][] mat=new int[n][n];
            int c=0;
            for (int i=0;i<n;i++) {
                st=new StringTokenizer(br.readLine());
                for (int j=0;j<n;j++) {
                    mat[i][j]=Integer.parseInt(st.nextToken());
                    if (mat[i][j]==1) c++;
                }
            }
            if (c==0) System.out.println(0);
            else if (c<=n) System.out.println(0);
            else {
                int p=0;
                c-=n;
                int m=n-1;
                while (c>0) {
                    if (c>2*m) {
                        p++;
                        c-=(2*m);
                        m--;
                    } else {
                        p++;
                        c=0;
                    }
                }
                System.out.println(p);
            }
        }

        System.exit(0);
    }

}
