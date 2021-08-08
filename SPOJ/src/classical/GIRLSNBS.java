package classical;

import java.io.*;
import java.util.*;
public class GIRLSNBS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int m,n,max,min,d2;
        double d;
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        while(m!=-1){
            max=Math.max(m, n);
            min=Math.min(m,n);
            d=(double)max/(double)(min+1);
            d2=max/(min+1);
            if(d==(double)d2)
                System.out.println(d2);
            else
                System.out.println(d2+1);
            st=new StringTokenizer(br.readLine());
            m=Integer.parseInt(st.nextToken());
            n=Integer.parseInt(st.nextToken());
        }
    }
}
