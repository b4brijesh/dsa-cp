package sept16Long;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 9/15/16.
 */
public class CHEFSPAG {
    static long e109=1000000009;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            long a=Integer.parseInt(st.nextToken());
            long b=Integer.parseInt(st.nextToken());
            long c=Integer.parseInt(st.nextToken());
            long d=Integer.parseInt(st.nextToken());
            long[] F=new long[1000000];
            F[0]=Integer.parseInt(st.nextToken());
            F[1]=Integer.parseInt(st.nextToken());
            F[2]=Integer.parseInt(st.nextToken());
            F[3]=Integer.parseInt(st.nextToken());
            for(int j=4;j<100000;j++)
                F[j]=(((a*F[j-1])%e109)+((b*F[j-2])%e109)
                        +((c*F[j-3])%e109)+((d*F[j-4])%e109))%e109;
            Point[] corners=new Point[n];
            for(int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                corners[j]=new Point(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
            }
            Line[] edges=new Line[n];
            for (int j=0;j<n-1;j++)
                edges[j]=new Line(corners[j],corners[j+1]);
            edges[n-1]=new Line(corners[n-1],corners[0]);
            double lowest_y=Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
                if(corners[j].y<lowest_y)
                    lowest_y=corners[j].y;
            lowest_y--;
            double lowest_x=Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
                if(corners[j].x<lowest_x)
                    lowest_x=corners[j].x;
            lowest_x--;
            double highest_y=Integer.MIN_VALUE;
            for(int j=0;j<n;j++)
                if(corners[j].y>highest_y)
                     highest_y=corners[j].y;
            highest_y++;
            double highest_x=Integer.MIN_VALUE;
            for(int j=0;j<n;j++)
                if(corners[j].x>highest_x)
                    highest_x=corners[j].x;
            highest_x++;
            long sum=0;
            for(double j=lowest_x;j<=highest_x;j++){
                for (double k=lowest_y;k<highest_y;k++){
                    Point p=new Point(j,k);
                    if(point_inside(p,edges)){
                        //System.out.println(j+" "+k);
                        sum=(sum+F[(int)j+(int)k])%e109;
                    }
                }
            }
            System.out.println(sum%e109);
        }
    }
    private static class Point{
        double x,y;
        Point(double x,double y){this.x=x;this.y=y;}
        public String toString(){
            return "x="+this.x+" y="+this.y;
        }
    }
    private static class Line{
        Point p1,p2;
        Line(Point p1,Point p2){this.p1=p1;this.p2=p2;}
        public String toString(){
            return "p1(x="+this.p1.x+" y="+this.p1.y+
                    ") p2(x="+this.p2.x+"y="+this.p2.y+")";
        }
    }
    static double e07=0.0000001;
    private static boolean point_inside(Point p,Line[] polygon){
        int count=0;
        for(int j=0;j<polygon.length;j++){
            if(Math.abs(p.x-polygon[j].p1.x)<e07 && Math.abs(p.y-polygon[j].p1.y)<e07)
                return true;
            if(Math.abs(p.x-polygon[j].p2.x)<e07 && Math.abs(p.y-polygon[j].p2.y)<e07)
                return true;
            if((p.x>=polygon[j].p1.x && p.x<=polygon[j].p2.x)
                    || (p.x>=polygon[j].p2.x && p.x<=polygon[j].p1.x)){
                if(Math.abs(polygon[j].p1.x-polygon[j].p2.x)>e07){
                    double t=(p.x-polygon[j].p2.x)/(polygon[j].p1.x-polygon[j].p2.x);
                    double yn=t*polygon[j].p1.y+(1-t)*polygon[j].p2.y;
                    if(Math.abs(p.y-yn)<e07)
                        return true;
                    if(p.y-yn>-e07)
                        count++;
                }
            }
        }
        //System.out.println(p.toString()+" "+count);
        if(count%2!=0) return true;
        return false;
    }
}
