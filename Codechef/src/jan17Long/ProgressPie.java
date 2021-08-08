package jan17Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 08-01-2017.
 */
public class ProgressPie {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(
               // new FileReader(d_loc2+"progress_pie.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int p=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            if (p==0){
                System.out.println("Case #"+i+": "+"white");
                continue;
            }
            double px=x,py=y;
            double dis=Math.sqrt(((px-50)*(px-50))+((py-50)*(py-50)));
            if ((dis-50)>e_06) System.out.println("Case #"+i+": "+"white");
            else {
                double per=findP(px,py);
                if (per<=p) System.out.println("Case #"+i+": "+"black");
                //else if(findDist(px,py,p)<=e_06) System.out.println("Case #"+i+": "+"black");
                else System.out.println("Case #"+i+": "+"white");
            }
        }

        System.exit(0);
    }
    static double findP(double x,double y){
        double v1x=0,v1y=50;
        double v2x=x-50,v2y=y-50;
        double dot=v1y*v2y;
        double det=-v1y*v2x;
        double val=Math.atan2(det,dot);
        if (val<=0) val=-val;
        else val=2*Math.PI-val;
        double per=(val/(2*Math.PI))*100;
        return per;
    }
    static double findDist(double x,double y, double per){
        double theta=(per/100)*2*Math.PI;
        double a=1,b=0,c=-50;
        double x1=50,y1=100;
        double x2=(x*Math.cos(theta))+(y*Math.sin(theta));
        double y2=(-x*Math.sin(theta))+(y*Math.cos(theta));
        double y0,x0=y0=50;
        double numerator=((y2-y0)*x)-((x2-x0)*y)+(x2*y0)-(y2*x0);
        double denominator=Math.sqrt(((y2-y0)*(y2-y0))+((x2-x0)*(x2-x0)));
        return numerator/denominator;
    }
}
