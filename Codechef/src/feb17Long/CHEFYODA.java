package feb17Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 2/12/17.
 */
public class CHEFYODA {
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
        for (int i=1;i<=t;i++) {
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            // RS1 : Yoda wins only if both odd
            // RS2 : Chef wins only if both even
            if (n%2!=0 && m%2!=0) {
                // both odd
                if (p==0) System.out.println(1);
                else System.out.println(0);
            } else if (n%2==0 && m%2==0) {
                // both even
                System.out.println(1);
            } else {
                // 1 - (sigma_0_to_p-1(kcj)/pow(2,k))
                if (p==0) {
                    System.out.println(1);
                    continue;
                }
                double sigma=1d;// kc0
                double pr=1d; //kc0
                int cnt2=0;
                for (int j=1;j<p;j++) {
                    pr*=(k-j+1);
                    pr/=j;
                    while (pr>e09$7) {
                        pr/=2;
                        sigma/=2;
                        cnt2++;
                    }
                    sigma+=pr;
                    //System.out.println(pr+" pr "+j);
                }
                //System.out.println(sigma+ " "+cnt2);
                if (cnt2<k)
                    sigma/=pow(2,k-cnt2);
                System.out.println(1-sigma);
            }
        }

        System.exit(0);
    }

    private static long pow(long base, long exp) {
        if (exp==0) return 1;
        long res=1;
        while (exp>1){
            if (exp%2!=0) res*=base;
            base*=base;
            exp/=2;
        }
        return res*base;
    }
}
