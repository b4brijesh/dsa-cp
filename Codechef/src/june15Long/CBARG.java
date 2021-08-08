package june15Long;

import java.io.*;
import java.util.*;

public class CBARG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int i,j,n;
        long sum;
        StringTokenizer st;
        for(i=1;i<=t;i++){
            n=Integer.parseInt(br.readLine());
            int m[]=new int[n];
            st=new StringTokenizer(br.readLine());
            for(j=0;j<n;j++)
                m[j] = Integer.parseInt(st.nextToken());
            sum=(long)m[0];
            for(j=1;j<n;j++)
                if(m[j]>m[j-1])
                    sum=sum+(long)m[j]-(long)m[j-1];
            System.out.println(sum);
        }
    }
}
