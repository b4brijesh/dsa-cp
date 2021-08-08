package jan16Long;

import java.io.*;
import java.util.*;

public class DEVPERF {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        int i,j,k;
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int minr=10000,maxr=-1,minc=10000,maxc=-1,flag=0;
            for(j=0;j<n;j++){
                String s=br.readLine().trim();
                for(k=0;k<m;k++){
                    char c=s.charAt(k);
                    if(c=='*'){
                        minr=Math.min(minr,j);
                        maxr=Math.max(maxr,j);
                        minc=Math.min(minc,k);
                        maxc=Math.max(maxc,k);
                        flag=1;
                    }
                }
            }
            int dist;
            if(flag==1)
                dist=Math.max((maxr-minr+1)/2,(maxc-minc+1)/2);
            else
            dist=-1;
            System.out.println(dist+1);
        }
    }
}
