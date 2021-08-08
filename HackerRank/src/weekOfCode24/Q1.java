package weekOfCode24;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/12/16.
 */
public class Q1 {
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
        int s=Integer.parseInt(st.nextToken());
        int t=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int m=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int[] apples=new int[m];
        int[] oranges=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<m;i++)
            apples[i]=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++)
            oranges[i]=Integer.parseInt(st.nextToken());
        int ac=0,oc=0;
        for (int i=0;i<m;i++)
            if(apples[i]+a>=s && apples[i]+a<=t)
                ac++;
        for (int i=0;i<n;i++)
            if (b+oranges[i]>=s && b+oranges[i]<=t)
                oc++;
        System.out.println(ac);
        System.out.println(oc);

        System.exit(0);
    }
}
