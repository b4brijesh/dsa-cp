package Hack40;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 23-08-2016.
 */
public class SherlockAndDroppingBall {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        Line[] arr=new Line[n];
        for(int i=0;i<n;i++){
            arr[i]=new Line();
            st=new StringTokenizer(br.readLine());
            int p1x=Integer.parseInt(st.nextToken());
            int p1y=Integer.parseInt(st.nextToken());
            Point p1=new Point(p1x,p1y);
            int p2x=Integer.parseInt(st.nextToken());
            int p2y=Integer.parseInt(st.nextToken());
            Point p2=new Point(p2x,p2y);
            Point hipo,lopo;
            if(p1.y>p2.y) {
                hipo=p1;lopo=p2;
            }else{
                hipo=p2;lopo=p1;
            }
            arr[i].hipo=hipo;arr[i].lopo=lopo;
            if(hipo.x<lopo.x)arr[i].slope=1;
            else arr[i].slope=-1;
        }
        Arrays.sort(arr, new Comparator<Line>() {
            @Override
            public int compare(Line l1, Line l2) {
                return l1.hipo.y-l2.hipo.y;
            }
        });
        Point[] ar2=new Point[n];
        for(int i=0;i<n;i++){
            ar2[i]=arr[i].lopo;
        }
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            Point qp=new Point(x,y);
            int index=n-1;
            index=Arrays.binarySearch(ar2, qp, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return o1.y-o2.y;
                }
            });
            if(index<0) index=-index-1;
            if(index>=n) index--;
            else if(arr[index].lopo.y!=qp.y)
                index--;
            /*for(int j=0;j<arr.length;j++){
                if(qp.y<arr[j].lopo.y){
                    index=j-1;
                    break;
                }
            }*/
            //System.out.println("index="+index);
            int j=index,finalx=qp.x,currenty=qp.y;
            while(j>=0){
                if(arr[j].lopo.y<currenty){
                    if(arr[j].slope>0){
                        if(arr[j].hipo.x<=finalx && arr[j].lopo.x>=finalx){
                            finalx=arr[j].lopo.x;
                            currenty=arr[j].lopo.y;
                        }
                    }else{
                        if(arr[j].hipo.x>=finalx && arr[j].lopo.x<=finalx){
                            finalx=arr[j].lopo.x;
                            currenty=arr[j].lopo.y;
                        }
                    }
                }
                j--;
            }
            System.out.println(finalx);
        }
    }
    static class Line{
        Point hipo,lopo;
        int slope;
    }
    static class Point{
        int x,y;
        Point(int x,int y){this.x=x;this.y=y;}
    }
}
