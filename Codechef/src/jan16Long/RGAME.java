package jan16Long;

import java.io.*;
import java.util.*;

public class RGAME {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        int i,j,n;
        int[] arr={};
        long[] powers=new long[100001];
        powers[0]=1L;
        for(i=1;i<=100000;i++)
            powers[i]=(2*powers[i-1])%1000000007;
        for(i=1;i<=t;i++){
            n=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            arr=new int[n+1];
            for(j=0;j<=n;j++){
                arr[j]=Integer.parseInt(st.nextToken());
                //System.out.println(arr[j]);
            }
            long[] multis=new long[n+1];
            multis[0]=0;//wrong
            for(j=1;j<=n;j++)
                multis[j]=(powers[j]*arr[j])%1000000007;
            long[] cumuls=new long[n+1];
            cumuls[0]=(2L*arr[0])%1000000007;//2A0
            for(j=1;j<=n;j++)
                cumuls[j]=(cumuls[j-1]+multis[j])%1000000007;
            long sum=(arr[1]*cumuls[0])%1000000007;
            for(j=2;j<=n;j++){
                sum=((2*sum)+(arr[j]*cumuls[j-1]))%1000000007;
            }
            //System.out.println(false);
            System.out.println(sum);
        }
    }
}
