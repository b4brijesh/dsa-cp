package Others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 19-02-2017.
 */
public class SumOfSum {
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
        int q=Integer.parseInt(st.nextToken());
        long[] a=new long[n];
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++)
            a[i]=Long.parseLong(st.nextToken());
        long[] ssd=new long[n];
        Long[] sd2=new Long[n];
        for (int i=0;i<n;i++) {
            long num=a[i];
            while (num>9L) {
                long bkp=num;
                long sd=0L;
                while (bkp>0L) {
                    long dig=bkp%10L;
                    sd+=dig;
                    bkp/=10L;
                }
                num=sd;
            }
            ssd[i]=num;
            sd2[i]=num;
        }
        Arrays.sort(ssd);
        Arrays.sort(sd2, Collections.reverseOrder());
        //Arrays.sort(new long[][]{sd2}, Collections.reverseOrder());
        long[] ar1=new long[n];
        long[] ar2=new long[n];
        ar1[0]=ssd[0];
        ar2[0]=sd2[0];
        for (int i=1;i<n;i++) {
            ar1[i]=ar1[i-1]+ssd[i];
            ar2[i]=ar2[i-1]+sd2[i];
        }
        /*ArrayList<Long> inc=new ArrayList<>();
        ArrayList<Long> dec=new ArrayList<>();
        for (int i=0;i<n;i++) {
            inc.add(ssd[i]);
            dec.add(ssd[i]);
        }
        Collections.sort(inc);
        Collections.sort(dec,Collections.reverseOrder());
        long[] ar1=new long[n];
        long[] ar2=new long[n];
        ar1[0]=inc.get(0);
        ar2[0]=dec.get(0);
        for (int i=1;i<n;i++) {
            ar1[i]=ar1[i-1]+inc.get(i);
            ar2[i]=ar2[i-1]+dec.get(i);
        }*/
        for (int i=0;i<q;i++) {
            st=new StringTokenizer(br.readLine());
            int type=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            if (type==1) {
                System.out.println(ar2[k-1]);
            } else {
                System.out.println(ar1[k-1]);
            }
        }

        System.exit(0);
    }
}
