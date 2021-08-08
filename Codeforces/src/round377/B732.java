package round377;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/17/16.
 */
public class B732 {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-practice.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] a=new int[n];
        int[] b=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
            b[i]=a[i];
        }
        for (int j=1;j<=n/2;j++){
            if (a[j]+a[j-1]<k)
                a[j]=k-a[j-1];
            if (a[n-j-1]+a[n-j]<k)
                a[n-j-1]=k-a[n-j];
        }
        int diff=0;
        for (int i=0;i<n;i++){
            diff+=a[i]-b[i];
        }
        System.out.println(diff);
        for (int i=0;i<n;i++)
            System.out.print(a[i]+" ");
        System.out.println();

        System.exit(0);
    }
}
