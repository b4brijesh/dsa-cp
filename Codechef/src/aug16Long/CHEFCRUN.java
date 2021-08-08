package aug16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 11-08-2016.
 */
public class CHEFCRUN {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] arr=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                arr[j]=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int stop=Integer.parseInt(st.nextToken());

            //System.out.println("st:"+start+" "+stop);
            start--;stop--;
            int diff=stop-start;
            //System.out.println("init:"+start+" "+stop+" "+diff);
            long cum=0;
            long[] cumul=new long[diff];
            cum=arr[start];
            if(arr[start]<0)
                cumul[0]=cum;
            else cumul[0]=0;
            for(int j=start+1;j<stop;j++){
                cum=cum+arr[j];
                if(cum<cumul[j-start-1])
                    cumul[j-start]=cum;
                else cumul[j-start]=cumul[j-start-1];
                //System.out.print(cumul[j-start]+" ");
            }
            //System.out.println();
            long[] cumul3=new long[diff];
            cum=arr[stop-1];
            if(arr[stop-1]<0)
                cumul3[0]=cum;
            else cumul3[0]=0;
            for(int j=stop-2,k=1;j>=start;j--,k++){
                cum=cum+arr[j];
                if(cum<cumul3[k-1])
                    cumul3[k]=cum;
                else cumul3[k]=cumul3[k-1];
                //System.out.print(cumul3[k]+" ");
            }
            //System.out.println();
            long min=cumul3[diff-1];
            for(int j=0,k=diff-2;j<diff;j++,k--){
                long mix;
                if(k<0) mix=cumul[j];
                else mix=cumul[j]+cumul3[k];
                //System.out.println(mix+" "+min);
                if(mix<min) min=mix;
            }
            //System.out.println("min:"+min);

            long sum=0;
            for(int j=start-1;j<start || j>=stop;j--){
                if(j<0) j=j+n;
                sum=sum+arr[j];
            }
            //System.out.println("sum:"+sum);

            int diff2=start+n-stop;
            long[] cumul2=new long[diff2];
            if(start>0){
                cum=arr[start-1];
            }
            else {
                cum=arr[n-1];
            }
            if(cum<0)
                cumul2[0]=cum;
            else cumul2[0]=0;
            for(int j=start-2,k=1;j<start-1 || j>=stop;j--,k++){
                if(j<0){
                    if(stop==n-1) break;
                    j=j+n;
                }
                cum=cum+arr[j];
                //System.out.println(cum);
                if(cum<cumul2[k-1])
                    cumul2[k]=cum;
                else cumul2[k]=cumul2[k-1];
                //System.out.print(cumul2[k]+" ");
            }
            //System.out.println();
            long[] cumul4=new long[diff2];
            cum=arr[stop];
            if(arr[stop]<0)
                cumul4[0]=cum;
            else cumul4[0]=0;
            for(int j=stop+1,k=1;j>=stop || j<start;j++,k++){
                if(j>=n){
                    if(start==0) break;
                    j=j-n;
                }
                cum=cum+arr[j];
                if(cum<cumul4[k-1])
                    cumul4[k]=cum;
                else cumul4[k]=cumul4[k-1];
                //System.out.print(cumul4[k]+" ");
            }
            //System.out.println();
            long min2=cumul4[diff2-1];
            for(int j=0,k=diff2-2;j<diff2;j++,k--){
                long mix;
                if(k<0) mix=cumul2[j];
                else mix=cumul2[j]+cumul4[k];
                //System.out.println(mix+" "+min);
                if(mix<min2) min2=mix;
            }
            //System.out.println("min2:"+min2);

            long sum2=0;
            for(int j=start;j<stop;j++){
                sum2=sum2+arr[j];
            }
            //System.out.println("sum2:"+sum2);
            System.out.println(Math.min(min+min+sum,min2+min2+sum2));
        }
    }
}
