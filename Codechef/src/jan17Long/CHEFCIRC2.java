package jan17Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 14-01-2017.
 */
public class CHEFCIRC2 {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static class Point{double x,y;Point(double x,double y){this.x=x;this.y=y;}}
    static Point[] points;
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
        points=new Point[n];
        for (int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            double x=Double.parseDouble(st.nextToken());
            double y=Double.parseDouble(st.nextToken());
            points[i]=new Point(x,y);
        }

        System.exit(0);
    }
}
