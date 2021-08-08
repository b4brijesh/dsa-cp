package classical;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 05-01-2017.
 */
public class OFFSIDE {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int a,d;
        while ((a=Integer.parseInt(st.nextToken()))!=0
                && (d=Integer.parseInt(st.nextToken()))!=0){
            int[] at=new int[a];
            int[] de=new int[d];
            st=new StringTokenizer(br.readLine());
            for (int i=0;i<a;i++)
                at[i]=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            for (int i=0;i<d;i++)
                de[i]=Integer.parseInt(st.nextToken());
            Arrays.sort(at);
            Arrays.sort(de);
            if(at[0]<de[1]) System.out.println("Y");
            else System.out.println("N");
            st=new StringTokenizer(br.readLine());
        }

        System.exit(0);
    }
}
