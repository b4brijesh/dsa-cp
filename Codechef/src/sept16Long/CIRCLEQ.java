package sept16Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 13-09-2016.
 */
public class CIRCLEQ {
    static double e07=0.0000001;
    static double e04=0.0001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        Circle[] circle=new Circle[n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            Point center=new Point(x,y);
            int r=Integer.parseInt(st.nextToken());
            circle[i]=new Circle(center,r);
        }
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            Point lol=new Point(x1,y1);
            Point upl=new Point(x1,y2);
            Point upr=new Point(x2,y2);
            Point lor=new Point(x2,y1);
            Rect rect=new Rect(lol,upl,upr,lor);
            double area=0d;
            for(int j=0;j<n;j++){
                Point center=circle[j].cen;
                double radius=circle[j].rad;
                int count=0;
                if(pp_dist(rect.lol,center)<=radius+e07) count++;
                if(pp_dist(rect.upl,center)<=radius+e07) count++;
                if(pp_dist(rect.upr,center)<=radius+e07) count++;
                if(pp_dist(rect.lor,center)<=radius+e07) count++;
                int points_inside=count;
                //System.out.println("inside="+points_inside);
                double ar=0d;
                switch (points_inside){
                    case 4: //find area of rectangle
                        ar=area_rect(rect);
                        area+=ar;
                        break;
                    case 0:
                        ar=segment(circle[j],rect);
                        area+=ar;
                        break;
                    case 1:
                        ar=segment_tri(circle[j],rect);
                        area+=ar;
                        break;
                    case 2:
                        ar=segment_2tri(circle[j],rect);
                        area+=ar;
                        break;
                    case 3:
                        ar=segment_3tri(circle[j],rect);
                        area+=ar;
                        break;
                    default:// I fucked up
                        //System.out.println("in default");
                        area+=0;
                        //System.out.println("I fucked up");
                        break;
                }
            }
            System.out.println(area);
            //sb.append(area+"\n");
        }
        //System.out.print(sb);
    }

    private static boolean tangent(Line l, Circle circle) {
        //System.out.println(shortest_dist(circle.cen,l));
        return Math.abs(shortest_dist(circle.cen,l)-circle.rad)<e07;
    }
    private static class Point{
        double x,y;
        Point(double x,double y){this.x=x;this.y=y;}
        public String toString(){
            return "x="+this.x+" y="+this.y;
        }
    }
    static double pp_dist(Point p1, Point p2){
        return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
    }
    private static class Line{
        Point p1,p2;
        Line(Point p1,Point p2){this.p1=p1;this.p2=p2;}
        public String toString(){
            return "p1(x="+this.p1.x+" y="+this.p1.y+") p2(x="+this.p2.x+"y="+this.p2.y+")";
        }
    }
    static double shortest_dist(Point p,Line l){
        double x0=p.x,y0=p.y;
        double x1=l.p1.x,x2=l.p2.x;
        double y1=l.p1.y,y2=l.p2.y;
        double num=Math.abs( ((y2-y1)*x0) - ((x2-x1)*y0) + ((x2*y1)-(y2*x1)) );
        double den=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        //System.out.println("sd="+num/den);
        return num/den;
    }
    private static class Circle{
        Point cen;double rad;
        Circle(Point c,int r){this.cen=c;this.rad=r;}
    }
    static double area_circle(Circle c){return Math.PI*c.rad*c.rad;}
    static double seg_area(Line l,Circle c){
        double r=c.rad;
        double h=r-shortest_dist(c.cen,l);
        if(h==0d) return 0;
        //System.out.println("r&h="+r+" "+h);
        double seg_area=(r*r*Math.acos((r-h)/r))-
                ((r-h)*Math.sqrt((2*r*h)-Math.pow(h,2)));
        return seg_area;
    }
    private static class Rect{
        Point lol,upl,upr,lor;
        Line lev,riv,loh,uph;
        Rect(Point lol,Point upl,Point upr,Point lor){
            this.lol=lol;this.upl=upl;this.upr=upr;this.lor=lor;
            lev=new Line(lol,upl);riv=new Line(lor,upr);
            loh=new Line(lol,lor);uph=new Line(upl,upr);
        }
    }
    private static double area_rect(Rect rect){
        double l1= pp_dist(rect.lol,rect.lor);
        double l2= pp_dist(rect.lol,rect.upl);
        return l1*l2;
    }
    static boolean point_in_rect(Point p1,Rect rect){
        if(p1.x>rect.lol.x+e07 && p1.x<rect.lor.x-e07)
            if(p1.y>rect.lol.y+e07 && p1.y<rect.upl.y-e07)
                return true;
        return false;
    }
    static ArrayList<Point> points_in_circle(Circle circle,Rect rect){
        Point center=circle.cen;
        double radius=circle.rad;
        ArrayList<Point> points=new ArrayList<>();
        if(pp_dist(rect.lol,center)<=radius+e07) points.add(rect.lol);
        if(pp_dist(rect.upl,center)<=radius+e07) points.add(rect.upl);
        if(pp_dist(rect.upr,center)<=radius+e07) points.add(rect.upr);
        if(pp_dist(rect.lor,center)<=radius+e07) points.add(rect.lor);
        return points;
    }
    static ArrayList<Point> points_out_circle(Circle circle,Rect rect){
        Point center=circle.cen;
        double radius=circle.rad;
        ArrayList<Point> points=new ArrayList<>();
        if(pp_dist(rect.lol,center)>radius+e07) points.add(rect.lol);
        if(pp_dist(rect.upl,center)>radius+e07) points.add(rect.upl);
        if(pp_dist(rect.upr,center)>radius+e07) points.add(rect.upr);
        if(pp_dist(rect.lor,center)>radius+e07) points.add(rect.lor);
        return points;
    }
    static ArrayList<Line> lines_with_point(Point p,Rect rect){
        ArrayList<Line> lines=new ArrayList<>();
        double xdiff=Math.abs(p.x-rect.lol.x),ydiff=Math.abs(p.y-rect.lol.y);
        if(xdiff<e07 && ydiff<e07) {lines.add(rect.lev);lines.add(rect.loh);}
        xdiff=Math.abs(p.x-rect.upl.x);ydiff=Math.abs(p.y-rect.upl.y);
        if(xdiff<e07 && ydiff<e07) {lines.add(rect.lev);lines.add(rect.uph);}
        xdiff=Math.abs(p.x-rect.upr.x);ydiff=Math.abs(p.y-rect.upr.y);
        if(xdiff<e07 && ydiff<e07) {lines.add(rect.riv);lines.add(rect.uph);}
        xdiff=Math.abs(p.x-rect.lor.x);ydiff=Math.abs(p.y-rect.lor.y);
        if(xdiff<e07 && ydiff<e07) {lines.add(rect.riv);lines.add(rect.loh);}
        return lines;
    }
    private static double area_triangle(Point p1, Point p2, Point p3) {
        double a= pp_dist(p1,p2);
        double b= pp_dist(p1,p3);
        double c= pp_dist(p2,p3);
        double s=(a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    static double segment(Circle circle,Rect rect){
        int line_cuts=0;
        ArrayList<Line> lines=new ArrayList<>();
        if(line_cuts_circle(circle,rect.lev)) {line_cuts++;lines.add(rect.lev);}
        if(line_cuts_circle(circle,rect.riv)) {line_cuts++;lines.add(rect.riv);}
        if(line_cuts_circle(circle,rect.loh)) {line_cuts++;lines.add(rect.loh);}
        if(line_cuts_circle(circle,rect.uph)) {line_cuts++;lines.add(rect.uph);}
        double circle_area=area_circle(circle);
        boolean centre_in_rect=point_in_rect(circle.cen,rect);
        if(line_cuts==0){
            if(centre_in_rect)
                return circle_area;
            else return 0d;
        }
        else if(line_cuts==1){
            double seg_area;
            if(pp_dist(lines.get(0).p1,lines.get(0).p2)<=e07)
                seg_area=0;
            else seg_area=seg_area(lines.get(0),circle);
            if(centre_in_rect) return circle_area-seg_area;
            else return seg_area;
        }
        else if(line_cuts==2){
            double seg_area1,seg_area2;
            if(pp_dist(lines.get(0).p1,lines.get(0).p2)<=e07)
                seg_area1=0;
            else seg_area1=seg_area(lines.get(0),circle);
            if(pp_dist(lines.get(1).p1,lines.get(1).p2)<=e07)
                seg_area2=0;
            else seg_area2=seg_area(lines.get(1),circle);
            if(centre_in_rect)
                return circle_area-(seg_area1+seg_area2);
            else return Math.max(seg_area1,seg_area2)-Math.min(seg_area1,seg_area2);
        }
        else if(line_cuts==3){
            double seg_area1,seg_area2,seg_area3;
            if(pp_dist(lines.get(0).p1,lines.get(0).p2)<=e07)
                seg_area1=0;
            else seg_area1=seg_area(lines.get(0),circle);
            if(pp_dist(lines.get(1).p1,lines.get(1).p2)<=e07)
                seg_area2=0;
            else seg_area2=seg_area(lines.get(1),circle);
            if(pp_dist(lines.get(2).p1,lines.get(2).p2)<=e07)
                seg_area3=0;
            else seg_area3=seg_area(lines.get(2),circle);
            return circle_area-(seg_area1+seg_area2+seg_area3);
        }
        else {//line_cuts==4
            double seg_area1,seg_area2,seg_area3,seg_area4;
            if(pp_dist(lines.get(0).p1,lines.get(0).p2)<=e07)
                seg_area1=0;
            else seg_area1=seg_area(lines.get(0),circle);
            if(pp_dist(lines.get(1).p1,lines.get(1).p2)<=e07)
                seg_area2=0;
            else seg_area2=seg_area(lines.get(1),circle);
            if(pp_dist(lines.get(2).p1,lines.get(2).p2)<=e07)
                seg_area3=0;
            else seg_area3=seg_area(lines.get(2),circle);
            if(pp_dist(lines.get(3).p1,lines.get(3).p2)<=e07)
                seg_area4=0;
            else seg_area4=seg_area(lines.get(3),circle);
            return circle_area-(seg_area1+seg_area2+seg_area3+seg_area4);
        }
    }
    /*static boolean line_cuts_circle(Circle cir,Line l){
        double r=cir.rad;
        double x0=cir.cen.x,y0=cir.cen.y;
        double x1=l.p1.x;double x2=l.p2.x;
        double y1=l.p1.y;double y2=l.p2.y;
        double a=Math.pow(x1-x2,2)+ Math.pow(y1-y2,2);
        double b=2*(((x1-x2)*(x2-x0))+((y1-y2)*(y2-y0)));
        double c=Math.pow(x2-x0,2)+Math.pow(y2-y0,2)-(Math.pow(r,2));
        if((b*b)<(4*a*c)) return false;
        else {
            double d=Math.sqrt((b*b)-(4*a*c));
            double t1=(-b+d)/(2*a),t2=(-b-d)/(2*a);
            System.out.println("t1 & t2="+t1+" "+t2);
            if((t1>=0+e07 && t1<=1-e07) || (t2>=0+e07 && t2<=1-e07))
                return true;
            return false;
        }
    }*/
    static boolean line_cuts_circle(Circle cir,Line l){
        if(pp_dist(l.p1,cir.cen)<=cir.rad+e07 && pp_dist(l.p2,cir.cen)>cir.rad+e07)
            return true;
        if(pp_dist(l.p2,cir.cen)<=cir.rad+e07 && pp_dist(l.p1,cir.cen)>cir.rad+e07)
            return true;
        if(pp_dist(l.p2,cir.cen)>cir.rad+e07 && pp_dist(l.p1,cir.cen)>cir.rad+e07){
            double r=cir.rad;
            double x0=cir.cen.x,y0=cir.cen.y;
            double x1=l.p1.x;double x2=l.p2.x;
            double y1=l.p1.y;double y2=l.p2.y;
            double a=Math.pow(x1-x2,2)+ Math.pow(y1-y2,2);
            double b=2*(((x1-x2)*(x2-x0))+((y1-y2)*(y2-y0)));
            double c=Math.pow(x2-x0,2)+Math.pow(y2-y0,2)-(Math.pow(r,2));
            if((b*b)<(4*a*c)) return false;
            else {
                double d=Math.sqrt((b*b)-(4*a*c));
                double t1=(-b+d)/(2*a),t2=(-b-d)/(2*a);
                //System.out.println("t1 & t2="+t1+" "+t2);
                if((t1>=0+e07 && t1<=1-e07) || (t2>=0+e07 && t2<=1-e07))
                    return true;
                return false;
            }
        }
        return false;
    }
    static Point line_circle_point(Line l,Circle cir){
        double x0=cir.cen.x,y0=cir.cen.y;
        double r=cir.rad;
        double x1=l.p1.x;double x2=l.p2.x;
        double y1=l.p1.y;double y2=l.p2.y;
        double a=Math.pow(x1-x2,2)+ Math.pow(y1-y2,2);
        double b=2*(((x1-x2)*(x2-x0))+((y1-y2)*(y2-y0)));
        double c=Math.pow(x2-x0,2)+Math.pow(y2-y0,2)-(Math.pow(r,2));
        double d=Math.sqrt((b*b)-(4*a*c));
        double t1=(-b+d)/(2*a),t2=(-b-d)/(2*a);
        //System.out.println("t1t2="+t1+" "+t2);
        if(t1>=0+e07 && t1<=1-e07 && t2>=0+e07 && t2<=1-e07){
            double cln1=Math.abs(t1-0.5),cln2=Math.abs(t2-0.5);
            if(cln1>cln2){
                double x3=(t1*x1)+((1-t1)*x2);
                double y3=(t1*y1)+((1-t1)*y2);
                return new Point(x3,y3);
            }else {
                double x3=(t2*x1)+((1-t2)*x2);
                double y3=(t2*y1)+((1-t2)*y2);
                return new Point(x3,y3);
            }
        }
        if(t1>=0+e07 && t1<=1-e07){
            double x3=(t1*x1)+((1-t1)*x2);
            double y3=(t1*y1)+((1-t1)*y2);
            return new Point(x3,y3);
        }
        else if(t2>=0+e07 && t2<=1-e07){
            double x3=(t2*x1)+((1-t2)*x2);
            double y3=(t2*y1)+((1-t2)*y2);
            return new Point(x3,y3);
        }
        if(t1>=0-e07 && t1<=1+e07){
            double x3=(t1*x1)+((1-t1)*x2);
            double y3=(t1*y1)+((1-t1)*y2);
            return new Point(x3,y3);
        }
        else if(t2>=0-e07 && t2<=1+e07){
            double x3=(t2*x1)+((1-t2)*x2);
            double y3=(t2*y1)+((1-t2)*y2);
            return new Point(x3,y3);
        }
        return null;
    }
    static double segment_tri(Circle circle,Rect rect){
        //find lengths of triangle
        ArrayList<Point> in_points=points_in_circle(circle,rect);
        ArrayList<Line> lines=lines_with_point(in_points.get(0),rect);
        Point tri_p1=in_points.get(0),tri_p2,tri_p3;
        double tri_area;
        Line l;
        if(!line_cuts_circle(circle,lines.get(0)) || !line_cuts_circle(circle,lines.get(1))){
            tri_area=0;
            if(line_cuts_circle(circle,lines.get(0)))
                l=new Line(tri_p1,line_circle_point(lines.get(0),circle));
            else l=new Line(tri_p1,line_circle_point(lines.get(1),circle));
        }
        else{
            tri_p2=line_circle_point(lines.get(0),circle);
            tri_p3=line_circle_point(lines.get(1),circle);
            tri_area=area_triangle(tri_p1,tri_p2,tri_p3);
            l=new Line(tri_p2,tri_p3);
        }
        double seg_area;
        if(pp_dist(l.p1,l.p2)<=e07)
            seg_area=0;
        else seg_area=seg_area(l,circle);
        //System.out.println(tri_area+" "+seg_area);
        return tri_area+seg_area;
    }
    private static double segment_2tri(Circle circle, Rect rect) {
        ArrayList<Point> in_points=points_in_circle(circle,rect);
        ArrayList<Line> lines=lines_with_point(in_points.get(0),rect);
        //System.out.println(lines.get(0).toString());System.out.println(lines.get(1).toString());
        Point tri_p1=in_points.get(0),tri_p2,tri_p3;
        tri_p2=in_points.get(1);
        if(line_cuts_circle(circle,lines.get(0))){
            //System.out.println("here");
            tri_p3=line_circle_point(lines.get(0),circle);
        }
        else tri_p3=line_circle_point(lines.get(1),circle);
        double tri_area1=area_triangle(tri_p1,tri_p2,tri_p3);
        ArrayList<Line> lines2=lines_with_point(tri_p2,rect);
        Point tri_p4;
        if(line_cuts_circle(circle,lines2.get(0))){
            //System.out.println("h2");
            tri_p4=line_circle_point(lines2.get(0),circle);
        }
        else tri_p4=line_circle_point(lines2.get(1),circle);
        double tri_area2=area_triangle(tri_p2,tri_p3,tri_p4);
        //System.out.println(tri_p1.toString());System.out.println(tri_p2.toString());
        //System.out.println(tri_p3.toString());System.out.println(tri_p4.toString());
        Line l=new Line(tri_p3,tri_p4);
        double seg_area;
        if(pp_dist(l.p1,l.p2)==0)
            seg_area=0;
        else seg_area=seg_area(l,circle);
        //System.out.println("seg="+seg_area);
        ArrayList<Point> out_points=points_out_circle(circle,rect);
        //System.out.println(out_points.toString());
        Line li=new Line(out_points.get(0),out_points.get(1));
        if(line_cuts_circle(circle,li)){
            double seg2;
            if(pp_dist(li.p1,li.p2)==0)
                seg2=0;
            else seg2=seg_area(li,circle);
            seg_area-=seg2;
        }
        //System.out.println("se2="+seg_area);
        return tri_area1+tri_area2+seg_area;
    }
    private static double segment_3tri(Circle circle, Rect rect) {
        double rect_area=area_rect(rect);
        ArrayList<Point> out_points=points_out_circle(circle,rect);
        ArrayList<Line> lines=lines_with_point(out_points.get(0),rect);
        Point tri_p1=out_points.get(0),tri_p2,tri_p3;
        tri_p2=line_circle_point(lines.get(0),circle);
        tri_p3=line_circle_point(lines.get(1),circle);
        double tri_area=area_triangle(tri_p1,tri_p2,tri_p3);
        Line l=new Line(tri_p2,tri_p3);
        double seg_area;
        if(pp_dist(l.p1,l.p2)==0)
            seg_area=0;
        else seg_area=seg_area(l,circle);
        return rect_area+seg_area-tri_area;
    }
}
