package aug16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 14-08-2016.
 */
public class CHAHG2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] inith;
            int[] rate;
            if(n%2==0) {
                inith=new int[n+1];
                rate=new int[n+1];
            }else {
                inith=new int[n];
                rate=new int[n];
            }
            for(int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                inith[j]=Integer.parseInt(st.nextToken());
                rate[j]=Integer.parseInt(st.nextToken());
            }
            if(n==1){
                System.out.println(2);
                System.out.println(0+" Inf");
                System.out.println(0+" Inf");
                continue;
            }
            long[] lo=new long[n/2];
            long[] hi=new long[n/2];
            boolean poss=true;
            if(n%2==0){
                inith[n]=0;
                rate[n]=0;
            }
            for(int j=1;j<n;j+=2){
                int k=j/2;
                if(inith[j]<=inith[j-1] && rate[j]<=rate[j-1]){poss=false;break;}
                if(inith[j]<=inith[j+1] && rate[j]<=rate[j+1]){poss=false;break;}
                if(inith[j]>inith[j-1]){
                    if(rate[j]>=rate[j-1]){
                        if(inith[j]>inith[j+1]){
                            lo[k]=0;
                            if(rate[j]>=rate[j+1]) hi[k]=Long.MAX_VALUE;
                            else{
                                double time2=((double)(inith[j]-inith[j+1]))/((double)(rate[j+1]-rate[j]));
                                if(time2 == Math.floor(time2)) time2--;
                                long ltime2=(long)Math.ceil(time2);
                                hi[k]=ltime2;
                            }
                        }else{
                            if(rate[j]>rate[j+1]){
                                double time2=((double)(inith[j+1]-inith[j]))/((double)(rate[j]-rate[j+1]));
                                if(time2 == Math.floor(time2)) time2++;
                                long ltime2=(long)Math.ceil(time2);
                                lo[k]=ltime2;
                                hi[k]=Long.MAX_VALUE;
                            }
                        }
                    }else{
                        double time=((double)(inith[j]-inith[j-1]))/((double)(rate[j-1]-rate[j]));
                        if(time == Math.floor(time)) time--;
                        long ltime=(long)Math.ceil(time);
                        if(inith[j]>inith[j+1]){
                            lo[k]=0;
                            if(rate[j]>=rate[j+1]) hi[k]=ltime;
                            else{
                                double time2=((double)(inith[j]-inith[j+1]))/((double)(rate[j+1]-rate[j]));
                                if(time2 == Math.floor(time2)) time2--;
                                long ltime2=(long)Math.ceil(time2);
                                hi[k]=Math.min(ltime,ltime2);
                            }
                        }else{
                            if(rate[j]>rate[j+1]){
                                double time2=((double)(inith[j+1]-inith[j]))/((double)(rate[j]-rate[j+1]));
                                if(time2 == Math.floor(time2)) time2++;
                                long ltime2=(long)Math.ceil(time2);
                                lo[k]=ltime2;
                                hi[k]=ltime;
                            }
                        }
                    }
                }
                else if(inith[j]<=inith[j-1] && rate[j]>rate[j-1]){
                    double time=((double)(inith[j-1]-inith[j]))/((double)(rate[j]-rate[j-1]));
                    if(time == Math.floor(time)) time++;
                    long ltime=(long)Math.ceil(time);
                    lo[k]=ltime;
                    if(inith[j]>inith[j+1]){
                        if(rate[j]>=rate[j+1]){
                            hi[k]=Long.MAX_VALUE;
                        }else {
                            double time2=((double)(inith[j]-inith[j+1]))/((double)(rate[j+1]-rate[j]));
                            if(time2 == Math.floor(time2)) time2--;
                            long ltime2=(long)Math.ceil(time2);
                            hi[k]=ltime2;
                        }
                    }else{
                        if(rate[j]>rate[j+1]){
                            double time2=((double)(inith[j+1]-inith[j]))/((double)(rate[j]-rate[j+1]));
                            if(time2 == Math.floor(time2)) time2++;
                            long ltime2=(long)Math.ceil(time2);
                            lo[k]=Math.max(ltime,ltime2);
                            hi[k]=Long.MAX_VALUE;
                        }
                    }
                }
            }
            long max_lo=lo[0],min_hi=hi[0];
            if(poss){
                //System.out.println("1st");
                for(int j=0;j<(n/2);j++){
                    //System.out.println("maxlo:"+max_lo+" minhi"+min_hi);
                    if(lo[j]>max_lo) max_lo=lo[j];
                    if(hi[j]<min_hi) min_hi=hi[j];
                }
                if(max_lo>min_hi) poss=false;
            }

            int[] i2h;
            int[] r2e;
            if(n%2==0) {
                i2h=new int[n+1];
                r2e=new int[n+1];
            }else {
                i2h=new int[n+2];
                r2e=new int[n+2];
            }
            i2h[0]=0;r2e[0]=0;
            for(int j=1;j<n+1;j++){
                i2h[j]=inith[j-1];
                r2e[j]=rate[j-1];
            }
            if(n%2!=0){
                i2h[n+1]=0;
                r2e[n+1]=0;
            }
            if(n%2==0) {
                inith=new int[n+1];
                rate=new int[n+1];
                inith=Arrays.copyOf(i2h,inith.length);
                rate=Arrays.copyOf(r2e,rate.length);
            }else {
                inith=new int[n+2];
                rate=new int[n+2];
                inith=Arrays.copyOf(i2h,inith.length);
                rate=Arrays.copyOf(r2e,rate.length);
            }
            lo=new long[(n+2)/2];
            hi=new long[(n+2)/2];
            boolean poss2=true;
            for(int j=1;j<n+1;j+=2){
                int k=j/2;
                if(inith[j]<=inith[j-1] && rate[j]<=rate[j-1]){poss2=false;break;}
                if(inith[j]<=inith[j+1] && rate[j]<=rate[j+1]){poss2=false;break;}
                if(inith[j]>inith[j-1]){
                    if(rate[j]>=rate[j-1]){
                        if(inith[j]>inith[j+1]){
                            lo[k]=0;
                            if(rate[j]>=rate[j+1]) hi[k]=Long.MAX_VALUE;
                            else{
                                double time2=((double)(inith[j]-inith[j+1]))/((double)(rate[j+1]-rate[j]));
                                if(time2 == Math.floor(time2)) time2--;
                                long ltime2=(long)Math.ceil(time2);
                                hi[k]=ltime2;
                            }
                        }else{
                            if(rate[j]>rate[j+1]){
                                double time2=((double)(inith[j+1]-inith[j]))/((double)(rate[j]-rate[j+1]));
                                if(time2 == Math.floor(time2)) time2++;
                                long ltime2=(long)Math.ceil(time2);
                                lo[k]=ltime2;
                                hi[k]=Long.MAX_VALUE;
                            }
                        }
                    }else{
                        double time=((double)(inith[j]-inith[j-1]))/((double)(rate[j-1]-rate[j]));
                        if(time == Math.floor(time)) time--;
                        long ltime=(long)Math.ceil(time);
                        if(inith[j]>inith[j+1]){
                            lo[k]=0;
                            if(rate[j]>=rate[j+1]) hi[k]=ltime;
                            else{
                                double time2=((double)(inith[j]-inith[j+1]))/((double)(rate[j+1]-rate[j]));
                                if(time2 == Math.floor(time2)) time2--;
                                long ltime2=(long)Math.ceil(time2);
                                hi[k]=Math.min(ltime,ltime2);
                            }
                        }else{
                            if(rate[j]>rate[j+1]){
                                double time2=((double)(inith[j+1]-inith[j]))/((double)(rate[j]-rate[j+1]));
                                if(time2 == Math.floor(time2)) time2++;
                                long ltime2=(long)Math.ceil(time2);
                                lo[k]=ltime2;
                                hi[k]=ltime;
                            }
                        }
                    }
                }
                else if(inith[j]<=inith[j-1] && rate[j]>rate[j-1]){
                    double time=((double)(inith[j-1]-inith[j]))/((double)(rate[j]-rate[j-1]));
                    if(time == Math.floor(time)) time++;
                    long ltime=(long)Math.ceil(time);
                    lo[k]=ltime;
                    if(inith[j]>inith[j+1]){
                        if(rate[j]>=rate[j+1]){
                            hi[k]=Long.MAX_VALUE;
                        }else {
                            double time2=((double)(inith[j]-inith[j+1]))/((double)(rate[j+1]-rate[j]));
                            if(time2 == Math.floor(time2)) time2--;
                            long ltime2=(long)Math.ceil(time2);
                            hi[k]=ltime2;
                        }
                    }else{
                        if(rate[j]>rate[j+1]){
                            double time2=((double)(inith[j+1]-inith[j]))/((double)(rate[j]-rate[j+1]));
                            if(time2 == Math.floor(time2)) time2++;
                            long ltime2=(long)Math.ceil(time2);
                            lo[k]=Math.max(ltime,ltime2);
                            hi[k]=Long.MAX_VALUE;
                        }
                    }
                }
            }
            long max_lo2=lo[0],min_hi2=hi[0];
            if(poss2){
                //System.out.println("2nd");
                for(int j=0;j<(n+2)/2;j++){
                    //System.out.println("maxlo:"+max_lo2+" minhi"+min_hi2);
                    if(lo[j]>max_lo2) max_lo2=lo[j];
                    if(hi[j]<min_hi2) min_hi2=hi[j];
                }
                if(max_lo2>min_hi2) poss2=false;
            }
            if(poss && poss2){
                System.out.println(2);
                System.out.println(max_lo+" "+((min_hi==Long.MAX_VALUE)?"Inf":min_hi));
                System.out.println(max_lo2+" "+((min_hi2==Long.MAX_VALUE)?"Inf":min_hi2));
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
