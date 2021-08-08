package AmritaICPCPrep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 14-08-2016.
 */
public class MBRECT {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        double root3=Math.sqrt(3);
        while(t-->0){
            st=new StringTokenizer(br.readLine());
            int s1=Integer.parseInt(st.nextToken());
            int s2=Integer.parseInt(st.nextToken());
            double larg,smal;
            if(s1>s2){larg=s1;smal=s2;}
            else{larg=s2;smal=s1;}
            Point p1=new Point(0,0);
            Point p2=new Point(larg,0);
            Point p3=new Point(larg/2,(root3*larg)/2);
            Point p4=new Point((larg/2)+smal,(root3*larg)/2);
            double len1=len(p1,p2);
            double dis1=dist(p1,p2,p3);
            double dis2=dist(p1,p2,p4);
            double ht=Math.max(dis1,dis2);
            double area=len1*ht;

            len1=len(p2,p4);
            dis1=dist(p2,p4,p1);
            dis2=dist(p2,p4,p3);
            ht=Math.max(dis1,dis2);
            area=Math.min(len1*ht,area);

            len1=len(p3,p4);
            dis1=dist(p3,p4,p1);
            dis2=dist(p3,p4,p2);
            ht=Math.max(dis1,dis2);
            area=Math.min(len1*ht,area);

            len1=len(p1,p3);
            dis1=dist(p1,p3,p2);
            dis2=dist(p1,p3,p2);
            ht=Math.max(dis1,dis2);
            area=Math.min(len1*ht,area);
            System.out.println(area);
        }
    }
    static double len(Point p1,Point p2){
        return Math.sqrt(((p1.x-p2.x)*(p1.x-p2.x))+((p1.y-p2.y)*(p1.y-p2.y)));
    }
    static double dist(Point p1,Point p2,Point p0){
        double num=Math.abs((p2.y-p1.y)*p0.x-(p2.x-p1.x)*p0.y+p2.x*p1.y-p2.y*p1.x);
        double den=len(p1,p2);
        return num/den;
    }
}
class Point{
    double x,y;
    Point(double x,double y){this.x=x;this.y=y;}
}
