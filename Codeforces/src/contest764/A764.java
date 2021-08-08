package contest764;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 2/2/17.
 */
public class A764 {
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
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int z=Integer.parseInt(st.nextToken());
        int hcf;
        if (n<m) hcf=findHcf(m,n);
        else hcf=findHcf(n,m);
        int lcm=(n*m)/hcf;
        /*if (z%lcm==0) */System.out.println(z/lcm);

        System.exit(0);
    }
    static int findHcf(int dividend,int divisor) {
        if (divisor==1) return divisor;
        else {
            //int q=dividend/divisor;
            int r=dividend%divisor;
            if (r==0) return divisor;
            else return findHcf(divisor,r);
        }
    }
}
