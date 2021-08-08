package classical;

/**
 * Created by Brijesh on 28-Oct-2015.
 */
import java.io.*;
import java.util.*;
public class CHN15A {
    //for ICPC Chennai only
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int i,j,t,n,k,count,l;
        t = Integer.parseInt(br.readLine());
        for (i = 1; i <= t; i++) {
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            count=0;
            for(j=1;j<=n;j++){
                l=Integer.parseInt(st.nextToken());
                if((l+k)%7==0)
                    count++;
            }
            System.out.println(count);
        }
    }
}
