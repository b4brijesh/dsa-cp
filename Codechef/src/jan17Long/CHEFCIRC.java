package jan17Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 14-01-2017.
 */
public class CHEFCIRC {
    static int e09$7=1000000007;
    static double e_06=0.000001;
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
        double min_rad=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                Point cen=findCen(i,j);
                double rad=findDist(cen,points[i]);
                int count=2;
                for (int l=0;l<n;l++){
                    if (l==i || l==j) continue;
                    double dist=findDist(cen,points[l]);
                    if (dist<=rad+e_06) count++;
                }
                if (count>=m){
                    if (rad<min_rad) min_rad=rad;
                }
            }
        }
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                for (int k=j+1;k<n;k++){
                    Point cen=findCen(i,j,k);
                    double rad=findDist(cen,points[i]);
                    int count=3;
                    for (int l=0;l<n;l++){
                        if (l==i || l==j || l==k) continue;
                        double dist=findDist(cen,points[l]);
                        if (dist<=rad+e_06) count++;
                    }
                    if (count>=m){
                        if (rad<min_rad) min_rad=rad;
                    }
                }
            }
        }
        System.out.println(min_rad);

        System.exit(0);
    }

    private static Point findCen(int i, int j) {
        double x4,y4;
        x4=(points[i].x+points[j].x)/2;
        y4=(points[i].y+points[j].y)/2;
        return new Point(x4,y4);
    }

    private static double findDist(Point cen, Point point) {
        return Math.sqrt(Math.pow(cen.x-point.x,2)+Math.pow(cen.y-point.y,2));
    }

    private static Point findCen(int i, int j, int k) {
        double x4,y4,x5,y5,x,y;
        x4=(points[i].x+points[j].x)/2;
        y4=(points[i].y+points[j].y)/2;
        x5=(points[k].x+points[j].x)/2;
        y5=(points[k].y+points[j].y)/2;
        double g1,g2;
        if (points[i].y==points[j].y)
            g1=Integer.MAX_VALUE;
        else if (points[i].x==points[j].x)
            g1=0;
        else g1=-1/((points[i].y-points[j].y)/(points[i].x-points[j].x));
        if (points[k].y==points[j].y)
            g2=Integer.MAX_VALUE;
        else if (points[k].x==points[j].x)
            g2=0;
        else g2=-1/((points[k].y-points[j].y)/(points[k].x-points[j].x));
        x=(g1*x4-y4-g2*x5+y5)/(g1-g2);
        y=g2*x-g2*x5+y5;
        return new Point(x,y);
    }
    //static class Vec{double x,y;}
    static class Point{double x,y;Point(double x,double y){this.x=x;this.y=y;}}
    static Point[] points;
}
