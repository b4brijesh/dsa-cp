package feb17Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Brijesh on 11-02-2017.
 */
public class MFREQ {
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
        int[] a=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(st.nextToken());
        int[] beg=new int[n];
        beg[0]=0;
        for (int i=1;i<n;i++) {
            if (a[i]==a[i-1])
                beg[i]=beg[i-1];
            else beg[i]=i;
        }
        int[] end=new int[n];
        end[n-1]=n-1;
        for (int i=n-2;i>=0;i--) {
            if (a[i]==a[i+1])
                end[i]=end[i+1];
            else end[i]=i;
        }
        for (int i=0;i<m;i++) {
            st=new StringTokenizer(br.readLine());
            int l=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            int mid=((l+r+1)/2)-1;
            int b,e;
            if (beg[mid]<l-1) b=l-1; else b=beg[mid];
            if (end[mid]>r-1) e=r-1; else e=end[mid];
            int val=e-b+1;
            if (val>=k) System.out.println(a[mid]);
            else System.out.println(-1);
        }
        System.exit(0);
    }
}
