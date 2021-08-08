package acmAmritapuri14;

import java.io.*;
import java.util.*;
public class AMR14I {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int i,j,n,m,s,p,q,vir,roh,cir;
        StringTokenizer st;
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            s=Integer.parseInt(st.nextToken());
            p=Integer.parseInt(st.nextToken());
            q=Integer.parseInt(st.nextToken());
            vir=roh=1-m;
            cir=n-m+1;
            int count=0;
            for(j=1;j<=s;j++){
                vir=vir+p;
                roh=roh+q;
                if(vir<0||roh<0)
                    continue;
                vir=vir%cir;
                roh=roh%cir;
                if(vir==roh)
                    count++;
            }
            System.out.println(count);
        }
    }
}
