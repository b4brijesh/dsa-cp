package contest724;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/9/16.
 */
public class C724 {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[][] sensor_xy=new int[k][2];
        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            sensor_xy[i][0]=Integer.parseInt(st.nextToken());
            sensor_xy[i][1]=Integer.parseInt(st.nextToken());
        }
        long[] left_wall_points=new long[n+1];Arrays.fill(left_wall_points,Integer.MAX_VALUE);
        long[] right_wall_points=new long[n+1];Arrays.fill(right_wall_points,Integer.MAX_VALUE);
        long[] top_wall_points=new long[m+1];Arrays.fill(top_wall_points,Integer.MAX_VALUE);
        long[] bot_wall_points=new long[m+1];Arrays.fill(bot_wall_points,Integer.MAX_VALUE);
        String[] left_app_dir=new String[n+1];
        String[] right_app_dir=new String[n+1];
        String[] top_app_dir=new String[m+1];
        String[] bot_app_dir=new String[m+1];
        String[] left_lea_dir=new String[n+1];
        String[] right_lea_dir=new String[n+1];
        String[] top_lea_dir=new String[m+1];
        String[] bot_lea_dir=new String[m+1];
        int curr_x=0,curr_y=0,next_x=-1,next_y=-1;
        String curr_lea_dir="ur",next_lea_dir="";
        long curr_time=0,next_time=-1;
        boolean corner_point=false;
        left_wall_points[0]=bot_wall_points[0]=0;
        left_lea_dir[0]=bot_lea_dir[0]="ur";
        do{
            if(curr_lea_dir.equals("ur")){
                if(n-curr_x<m-curr_y){
                    next_x=n;
                    next_y=curr_y+(n-curr_x);
                    next_time=curr_time+(n-curr_x);
                    right_wall_points[next_y]=curr_time+(n-curr_x);
                    right_app_dir[next_y]="ur";
                    right_lea_dir[next_y]="ul";
                    next_lea_dir="ul";
                } else if(m-curr_y<n-curr_x){
                    next_x=curr_x+(m-curr_y);
                    next_y=m;
                    next_time=curr_time+(m-curr_y);
                    top_wall_points[next_x]=curr_time+(m-curr_y);
                    top_app_dir[next_x]="ur";
                    top_lea_dir[next_x]="dr";
                    next_lea_dir="dr";
                } else {
                    //corner
                    corner_point=true;
                    next_x=n;
                    next_y=m;
                    right_wall_points[next_y]=curr_time+(n-curr_x);
                    right_app_dir[next_y]="ur";
                    top_wall_points[next_x]=curr_time+(m-curr_y);
                    top_app_dir[next_x]="ur";
                }
            }
            if(curr_lea_dir.equals("dr")){
                if(n-curr_x<curr_y){
                    next_x=n;
                    next_y=curr_y-(n-curr_x);
                    next_time=curr_time+(n-curr_x);
                    right_wall_points[next_y]=curr_time+(n-curr_x);
                    right_app_dir[next_y]="dr";
                    right_lea_dir[next_y]="dl";
                    next_lea_dir="dl";
                } else if(curr_y<n-curr_x){
                    next_x=curr_x+(curr_y);
                    next_y=0;
                    next_time=curr_time+(curr_y);
                    bot_wall_points[next_x]=curr_time+(curr_y);
                    bot_app_dir[next_y]="dr";
                    bot_lea_dir[next_y]="ur";
                    next_lea_dir="ur";
                } else {
                    //corner
                    corner_point=true;
                    next_x=n;
                    next_y=0;
                    right_wall_points[next_y]=curr_time+(n-curr_x);
                    right_app_dir[next_y]="dr";
                    bot_wall_points[next_x]=curr_time+(curr_y);
                    bot_app_dir[next_y]="dr";
                }
            }
            if(curr_lea_dir.equals("dl")){
                if(curr_x<curr_y){
                    next_x=0;
                    next_y=curr_y-(curr_x);
                    next_time=curr_time+(curr_x);
                    left_wall_points[next_y]=curr_time+(curr_x);
                    left_app_dir[next_y]="dl";
                    left_lea_dir[next_y]="dr";
                    next_lea_dir="dr";
                } else if(curr_y<curr_x){
                    next_x=curr_x-(curr_y);
                    next_y=0;
                    next_time=curr_time+(curr_x);
                    bot_wall_points[next_x]=curr_time+(curr_y);
                    bot_app_dir[next_y]="dl";
                    bot_lea_dir[next_y]="ul";
                    next_lea_dir="ul";
                } else {
                    //corner
                    corner_point=true;
                    next_x=0;
                    next_y=0;
                    left_wall_points[next_y]=curr_time+(curr_x);
                    left_app_dir[next_y]="dl";
                    bot_wall_points[next_x]=curr_time+(curr_y);
                    bot_app_dir[next_y]="dl";
                }
            }
            if(curr_lea_dir.equals("ul")){
                if(curr_x<m-curr_y){
                    next_x=0;
                    next_y=curr_y+(curr_x);
                    next_time=curr_time+(curr_x);
                    left_wall_points[next_y]=curr_time+(curr_x);
                    left_app_dir[next_y]="ul";
                    left_lea_dir[next_y]="ur";
                    next_lea_dir="ur";
                } else if(m-curr_y<curr_x){
                    next_x=curr_x-(m-curr_y);
                    next_y=m;
                    next_time=curr_time+(m-curr_y);
                    top_wall_points[next_x]=curr_time+(m-curr_y);
                    top_app_dir[next_y]="ul";
                    top_lea_dir[next_y]="dl";
                    next_lea_dir="dl";
                } else {
                    //corner
                    corner_point=true;
                    next_x=0;
                    next_y=m;
                    left_wall_points[next_y]=curr_time+(curr_x);
                    left_app_dir[next_y]="ul";
                    top_wall_points[next_x]=curr_time+(m-curr_y);
                    top_app_dir[next_y]="ul";
                }
            }
            curr_x=next_x;
            curr_y=next_y;
            curr_time=next_time;
            curr_lea_dir=next_lea_dir;
        } while (!corner_point);
        for(int i=0;i<k;i++){
            int sx=sensor_xy[i][0],sy=sensor_xy[i][1];
            long time=Integer.MAX_VALUE;
            if(sx<=sy){
                time=Math.min(time,left_wall_points[sy-sx]);
            } else {
                time=Math.min(time,bot_wall_points[sx-sy]);
            }
            if(sx<=m-sy){
                time=Math.min(time,left_wall_points[sy+sx]);
            } else {
                time=Math.min(time,top_wall_points[sx-(m-sy)]);
            }
            if(n-sx<=sy){
                time=Math.min(time,right_wall_points[sy-(n-sx)]);
            } else {
                time=Math.min(time,bot_wall_points[sx+sy]);
            }
            if(n-sx<=m-sy){
                time=Math.min(time,right_wall_points[sy+(n-sx)]);
            } else {
                time=Math.min(time,top_wall_points[sx+(m-sy)]);
            }
            System.out.println(time);
        }
        System.exit(0);
    }

}
