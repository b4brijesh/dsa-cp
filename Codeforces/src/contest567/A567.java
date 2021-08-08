package contest567;

import java.io.*;
import java.util.*;
public class A567 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        long max,min;
        long[] city=new long[n];
        st=new StringTokenizer(br.readLine());
        int i;
        for(i=0;i<n;i++)
            city[i]=Long.parseLong(st.nextToken());
        long min1=0,min2=0,max1=0,max2=0;
        for(i=0;i<n;i++){
            if(i==0)
                min=city[i+1]-city[i];
            else if(i==n-1)
                min=city[i]-city[i-1];
            else {
                min1=city[i+1]-city[i];
                min2=city[i]-city[i-1];
                min=Math.min(min1,min2);
            }
            max1=city[n-1]-city[i];
            max2=city[i]-city[0];
            max=Math.max(max1,max2);
            System.out.println(min+" "+max);
        }
    }
}
