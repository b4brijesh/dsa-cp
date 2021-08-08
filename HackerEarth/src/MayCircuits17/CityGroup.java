package MayCircuits17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 20-05-2017.
 */
public class CityGroup {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] grs=new int[n+1];
        for(int i=1;i<=k;i++) {
            st=new StringTokenizer(br.readLine());
            int cs=Integer.parseInt(st.nextToken());
            for(int j=0;j<cs;j++) {
                int ct=Integer.parseInt(st.nextToken());
                grs[ct]=i;
            }
        }
        int q=Integer.parseInt(br.readLine());
        for(int i=1;i<=q;i++) {
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int g1=grs[x],g2=grs[y];
            int d1=Math.abs(g1-g2);
            int d2=Math.abs(k-d1);
            System.out.println(Math.min(d1,d2));
        }
    }
}
