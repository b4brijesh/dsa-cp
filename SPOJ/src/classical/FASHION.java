package classical;

import java.io.*;
import java.util.*;
public class FASHION {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i,j,s,n,men[],wom[];
        for(i=1;i<=t;i++){
            n=Integer.parseInt(br.readLine());
            men=new int[n];
            wom=new int[n];
            st=new StringTokenizer(br.readLine());
            for(j=0;j<n;j++)
                men[j]=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            for(j=0;j<n;j++)
                wom[j]=Integer.parseInt(st.nextToken());
            Arrays.sort(men);
            Arrays.sort(wom);
            s=0;
            for(j=0;j<n;j++)
                s=s+men[j]*wom[j];
            System.out.println(s);
        }
    }
}
