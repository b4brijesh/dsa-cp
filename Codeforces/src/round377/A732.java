package round377;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/17/16.
 */
public class A732 {
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
        int k=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());
        int ld=k%10,bld=ld;
        int i=1;
        while(r!=ld && ld!=0){
            i++;
            ld=(i*bld)%10;
        }
        System.out.println(i);

        System.exit(0);
    }
}
