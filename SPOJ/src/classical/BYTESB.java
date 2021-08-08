package classical;

import java.io.*;
import java.util.*;
public class BYTESB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i,r,j;
        double a,b,vmax,f;
        for(i=1;i<=cases;i++){
            st=new StringTokenizer(br.readLine());
            a=Double.parseDouble(st.nextToken());
            b=Double.parseDouble(st.nextToken());
            vmax=Double.parseDouble(st.nextToken());
            f=Double.parseDouble(st.nextToken());
            r=Integer.parseInt(br.readLine());
            for(j=1;j<=r;j++){
                st=new StringTokenizer(br.readLine());
                //incomplete
            }
        }
    }
}
