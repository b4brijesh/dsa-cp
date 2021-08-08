package june15Long;

import java.io.*;
import java.util.*;

public class STDYTAB {
    static long arr1[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i,j,k,n,m;
        long sum;
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine().trim());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            arr1=new long[m+1];
            long arr2[]=new long[m+1];
            long arr3[]=new long[m+1];
            sum=0;
            for(j=0;j<=m;j++){
                arr1[j]=choose(j+m-1,j)%(long)Math.pow(10,9);
                sum=(sum+arr1[j])%(long)Math.pow(10,9);
                arr2[j]=sum;
            }
            for(k=2;k<=n;k++){
                sum=0;
                for(j=0;j<=m;j++){
                    arr3[j]=(arr1[j]*arr2[j])%(long)Math.pow(10,9);
                    sum=(sum+arr3[j])%(long)Math.pow(10,9);
                    arr2[j]=sum;
                }
            }
            System.out.println((int)arr2[m]);
        }
    }
    static long choose(int a,int b){
        if(b==0)
            return 1;
        return ((arr1[b-1]*a)/b)%(long)Math.pow(10,9);
    }
}
