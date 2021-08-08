package contest764;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 2/2/17.
 */
public class B764 {
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
        int n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        int[] a=new int[n];
        for (int i=0;i<n;i++)
            a[i]=Integer.parseInt(st.nextToken());
        for (int i=1;i<=n/2;i+=2) {
            int temp=a[i-1];
            a[i-1]=a[n-i];
            a[n-i]=temp;
        }
        for (int i=0;i<n;i++)
            System.out.print(a[i]+" ");
        System.out.println();

        System.exit(0);
    }
}
