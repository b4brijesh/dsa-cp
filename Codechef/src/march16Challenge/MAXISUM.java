package march16Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 07-03-2016.
 */
public class MAXISUM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            int[] a=new int[n];
            int[] b=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                a[j]=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                b[j]=Integer.parseInt(st.nextToken());
            int maxb=-1,maxi=-1;
            for(int j=0;j<n;j++){
                int modb=Math.abs(b[j]);
                if(modb>maxb){
                    maxb=modb;
                    maxi=j;
                }
            }
            if(b[maxi]>0)
                a[maxi]+=k;
            else a[maxi]-=k;
            long sum=0L;
            for(int j=0;j<n;j++)
                sum+=(long)a[j]*(long)b[j];
            System.out.println(sum);
        }
    }
}
