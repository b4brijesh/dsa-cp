package apac16D;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 9/21/16.
 */
public class B {
    static double e_07=0.0000001;
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-small-practice.in"));
        BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-large-practice.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int q_lim=Integer.parseInt(st.nextToken());
            int[] velo=new int[m];
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<velo.length;j++)
                velo[j]=Integer.parseInt(st.nextToken());
            int[] P=new int[n];
            int[] init_h=new int[n];
            for(int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                P[j]=Integer.parseInt(st.nextToken());
                init_h[j]=Integer.parseInt(st.nextToken());
            }
            int[][] times=new int[n][m];
            for(int j=0;j<n;j++){
                double x_pos=P[j];
                for(int k=0;k<m;k++){
                    double time=-x_pos/(double) velo[k];
                    if(time<-e_07) times[j][k]=Integer.MAX_VALUE;
                    else times[j][k]=(int)Math.ceil(time);
                }
            }
            int[] range_min_time=new int[n];
            for(int j=0;j<n;j++)
                range_min_time[j]=times[j][init_h[j]];
            int[] Q=new int[n];
            Arrays.fill(Q,0);
            int[] min_times=new int[n];
            int max_idx=-1,max_val=-1;
            for(int j=0;j<n;j++){
                min_times[j]=range_min_time[j];
                if(min_times[j]>max_val){
                    max_val=min_times[j];
                    max_idx=j;
                }
            }
            for(int j=1;j<=q_lim;j++){
                Q[max_idx]++;
                int val1=Integer.MAX_VALUE,val2=Integer.MAX_VALUE;
                if(init_h[max_idx]-Q[max_idx]>=0)
                    val1=times[max_idx][init_h[max_idx]-Q[max_idx]];
                if(init_h[max_idx]+Q[max_idx]<m)
                    val2=times[max_idx][init_h[max_idx]+Q[max_idx]];
                int new_time=Math.min(max_val,Math.min(val1,val2));//for max_idx
                min_times[max_idx]=new_time;
                max_idx=-1;max_val=-1;
                for(int k=0;k<n;k++){
                    if(min_times[k]>max_val){
                        max_val=min_times[k];
                        max_idx=k;
                    }
                }
            }
            int max_time=Integer.MIN_VALUE;
            for(int j=0;j<n;j++)
                max_time=Math.max(max_time,min_times[j]);
            if(max_time==Integer.MAX_VALUE)
                System.out.println("Case #"+i+": "+"IMPOSSIBLE");
            else System.out.println("Case #"+i+": "+max_time);
        }
    }
}
