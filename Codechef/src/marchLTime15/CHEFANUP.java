package marchLTime15;

import java.io.*;
import java.util.*;
public class CHEFANUP {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i,j,n;
        long k,num,index;
        long l;
        long arr[];
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            k=Long.parseLong(st.nextToken());
            l=Long.parseLong(st.nextToken());
            arr=new long[n];
            for(j=0;j<n;j++)
                arr[j]=1;
            l=l-1;
            while(l>0){
                index=(long)(Math.log(l)/Math.log(k));
                num=(long)Math.pow(k,index);
                arr[n-1-(int)index]+=(l/num);
                l=l%num;
            }
            for(j=0;j<n;j++)
                System.out.print(arr[j]+" ");
            System.out.println();
        }
    }
}
