package virtuals;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/19/16.
 */
public class C508 {
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
        int m=Integer.parseInt(st.nextToken());
        int t=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());
        int[] w=new int[m];
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<m;i++){
            w[i]=Integer.parseInt(st.nextToken());
        }
        if (t<=r)
            System.out.println(-1);
        else {
            int[] end_times=new int[r];
            int k=1,count=0;
            for (int j=0;j<r;j++){
                end_times[j]=(w[0]-k)+t;
                k++;
                count++;
            }
            for (int i=1;i<m;i++){
                k=1;
                for (int j=0;j<r;j++){
                    if (end_times[j]<(w[i]+1)){
                        end_times[j]=(w[i]-k)+t;
                        k++;
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

        System.exit(0);
    }

}
