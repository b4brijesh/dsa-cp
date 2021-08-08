package aug16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 13-08-2016.
 */
public class CHAHG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] inith=new int[n];
            int[] rate=new int[n];
            for(int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                inith[j]=Integer.parseInt(st.nextToken());
                rate[j]=Integer.parseInt(st.nextToken());
            }
            if(n==1){
                System.out.println(1);
                System.out.println(0+" Inf");
                continue;
            }
            long[] lo=new long[n-1];
            long[] hi=new long[n-1];
            boolean poss=true;
            for(int j=0;j<n-1;j++){
                if(j%2==0){
                    lo[j]=-1;hi[j]=Long.MAX_VALUE;
                    if(inith[j]<inith[j+1]) {
                        lo[j]=0;
                        if(rate[j]>rate[j+1]){
                            double time=((double)inith[j+1]-inith[j])/((double)rate[j]-rate[j+1]);
                            if(time == Math.floor(time)) time--;
                            long ltime=(long)Math.floor(time);
                            hi[j]=ltime;
                        }
                    }
                    else if(rate[j+1]>rate[j]){
                        double time=((double)inith[j]-inith[j+1])/((double)rate[j+1]-rate[j]);
                        if(time == Math.floor(time)) time++;
                        long ltime=(long)Math.ceil(time);
                        lo[j]=ltime;
                    }else hi[j]=-1;
                    if(lo[j]==-1 || hi[j]==-1) {poss=false;break;}
                }else{
                    lo[j]=-1;hi[j]=Long.MAX_VALUE;
                    if(inith[j]>inith[j+1]) {
                        lo[j]=0;
                        if(rate[j]<rate[j+1]){
                            double time=((double)inith[j]-inith[j+1])/((double)rate[j+1]-rate[j]);
                            if(time == Math.floor(time)) time--;
                            long ltime=(long)Math.floor(time);
                            hi[j]=ltime;
                        }
                    }
                    else if(rate[j]>rate[j+1]){
                        double time=((double)inith[j+1]-inith[j])/((double)rate[j]-rate[j+1]);
                        if(time == Math.floor(time)) time++;
                        long ltime=(long)Math.ceil(time);
                        lo[j]=ltime;
                    }else hi[j]=-1;
                    if(lo[j]==-1 || hi[j]==-1) {poss=false;break;}
                }
            }
            long max_lo=lo[0],min_hi=hi[0];
            if(poss){
                for(int j=0;j<n-1;j++){
                    if(lo[j]>max_lo) max_lo=lo[j];
                    if(hi[j]<min_hi) min_hi=hi[j];
                }
                if(max_lo>min_hi) poss=false;
            }
            boolean poss2=true;
            for(int j=0;j<n-1;j++){
                if(j%2!=0){
                    lo[j]=-1;hi[j]=Long.MAX_VALUE;
                    if(inith[j]<inith[j+1]) {
                        lo[j]=0;
                        if(rate[j]>rate[j+1]){
                            double time=((double)inith[j+1]-inith[j])/((double)rate[j]-rate[j+1]);
                            if(time == Math.floor(time)) time--;
                            long ltime=(long)Math.floor(time);
                            hi[j]=ltime;
                        }
                    }
                    else if(rate[j+1]>rate[j]){
                        double time=((double)inith[j]-inith[j+1])/((double)rate[j+1]-rate[j]);
                        if(time == Math.floor(time)) time++;
                        long ltime=(long)Math.ceil(time);
                        lo[j]=ltime;
                    }else hi[j]=-1;
                    if(lo[j]==-1 || hi[j]==-1) {poss2=false;break;}
                }else{
                    lo[j]=-1;hi[j]=Long.MAX_VALUE;
                    if(inith[j]>inith[j+1]) {
                        lo[j]=0;
                        if(rate[j]<rate[j+1]){
                            double time=((double)inith[j]-inith[j+1])/((double)rate[j+1]-rate[j]);
                            if(time == Math.floor(time)) time--;
                            long ltime=(long)Math.floor(time);
                            hi[j]=ltime;
                        }
                    }
                    else if(rate[j]>rate[j+1]){
                        double time=((double)inith[j+1]-inith[j])/((double)rate[j]-rate[j+1]);
                        if(time == Math.floor(time)) time++;
                        long ltime=(long)Math.ceil(time);
                        lo[j]=ltime;
                    }else hi[j]=-1;
                    if(lo[j]==-1 || hi[j]==-1) {poss2=false;break;}
                }
            }
            long max_lo2=lo[0],min_hi2=hi[0];
            if(poss2){
                for(int j=0;j<n-1;j++){
                    if(lo[j]>max_lo2) max_lo2=lo[j];
                    if(hi[j]<min_hi2) min_hi2=hi[j];
                }
                if(max_lo2>min_hi2) poss2=false;
            }
            if(poss && poss2){
                if(max_lo>max_lo2){
                    if(max_lo==min_hi2+1){
                        System.out.println(1);
                        System.out.println(max_lo2+" "+((min_hi==Long.MAX_VALUE)?"Inf":min_hi));
                    }else{
                        System.out.println(2);
                        System.out.println(max_lo2+" "+((min_hi2==Long.MAX_VALUE)?"Inf":min_hi2));
                        System.out.println(max_lo+" "+((min_hi==Long.MAX_VALUE)?"Inf":min_hi));
                    }
                }else {
                    if(max_lo2==min_hi+1){
                        System.out.println(1);
                        System.out.println(max_lo+" "+((min_hi2==Long.MAX_VALUE)?"Inf":min_hi2));
                    }else {
                        System.out.println(2);
                        System.out.println(max_lo+" "+((min_hi==Long.MAX_VALUE)?"Inf":min_hi));
                        System.out.println(max_lo2+" "+((min_hi2==Long.MAX_VALUE)?"Inf":min_hi2));
                    }
                }
            }else if(poss){
                System.out.println(1);
                System.out.println(max_lo+" "+((min_hi==Long.MAX_VALUE)?"Inf":min_hi));
            }else if(poss2){
                System.out.println(1);
                System.out.println(max_lo2+" "+((min_hi2==Long.MAX_VALUE)?"Inf":min_hi2));
            }else System.out.println(0);
        }
    }
}
