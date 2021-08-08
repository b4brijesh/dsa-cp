package round377;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/17/16.
 */
public class C732 {
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
        long b=Long.parseLong(st.nextToken());
        long d=Long.parseLong(st.nextToken());
        long s=Long.parseLong(st.nextToken());
        long missed=Long.MAX_VALUE;
        for (int ii=0;ii<4;ii++){
            for (int jj=0;jj<4;jj++){
                int i=ii,j=jj;
                if (i==3) i=0;
                if (j==3) j=0;
                if (i==0 && j==0){
                    long max=Math.max(b,Math.max(d,s));
                    missed=Math.min(missed,(max-b)+(max-d)+(max-s));
                }
                if (i==0 && j==1){
                    long max=Math.max(b-1,Math.max(d,s));
                    missed=Math.min(missed,(max-(b-1))+(max-d)+(max-s));
                }
                if (i==0 && j==2){
                    long max=Math.max(b-1,Math.max(d-1,s));
                    missed=Math.min(missed,(max-(b-1))+(max-(d-1))+(max-s));
                }
                /*if (i==0 && j==3){
                    long max=Math.max(b-1,Math.max(d-1,s-1));
                    missed=Math.min(missed,(max-(b-1))+(max-(d-1))+(max-(s-1)));
                }*/

                if (i==1 && j==0){
                    long max=Math.max(b+1,Math.max(d,s));
                    missed=Math.min(missed,(max-(b+1))+(max-d)+(max-s));
                }
                if (i==1 && j==1){
                    long max=Math.max(b,Math.max(d,s));
                    missed=Math.min(missed,(max-(b))+(max-d)+(max-s));
                }
                if (i==1 && j==2){
                    long max=Math.max(b,Math.max(d-1,s));
                    missed=Math.min(missed,(max-(b))+(max-(d-1))+(max-s));
                }
                /*if (i==1 && j==3){
                    long max=Math.max(b,Math.max(d-1,s-1));
                    missed=Math.min(missed,(max-(b))+(max-(d-1))+(max-(s-1)));
                }*/

                if (i==2 && j==0){
                    long max=Math.max(b,Math.max(d,s-1));
                    missed=Math.min(missed,(max-b)+(max-d)+(max-(s-1)));
                }
                if (i==2 && j==1){
                    long max=Math.max(b-1,Math.max(d,s-1));
                    missed=Math.min(missed,(max-(b-1))+(max-d)+(max-(s-1)));
                }
                if (i==2 && j==2){
                    long max=Math.max(b,Math.max(d,s));
                    missed=Math.min(missed,(max-(b))+(max-(d))+(max-s));
                }
                /*if (i==2 && j==3){
                    long max=Math.max(b-1,Math.max(d-1,s-1));
                    missed=Math.min(missed,(max-(b-1))+(max-(d-1))+(max-(s-1)));
                }*/

            }
        }
        System.out.println(missed);

        System.exit(0);
    }
}
