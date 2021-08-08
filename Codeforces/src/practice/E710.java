package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 03-09-2016.
 */
public class E710 {
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Documents/SCC.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        long[] costdp=new long[n+1];
        Arrays.fill(costdp,Long.MAX_VALUE);
        costdp[0]=0;costdp[1]=x;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=Math.min(2*i,n);j++){
                long val=costdp[i]+y+(((2*i)-j)*(long)x);
                long val2=costdp[i]+((j-i)*(long)x);
                costdp[j]=Math.min(Math.min(val,costdp[j]),val2);
            }
        }
        System.out.println(costdp[n]);
    }
}
