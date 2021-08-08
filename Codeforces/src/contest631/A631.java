package contest631;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 03-03-2016.
 */
public class A631 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] a=new int[n];
        int[] b=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            b[i]=Integer.parseInt(st.nextToken());
        int sum=0,max=0;
        for(int l=0;l<n;l++){
            int or1=a[l];
            int or2=b[l];
            for(int r=l+1;r<n;r++){
                for(int i=l+1;i<=r;i++)
                    or1=or1 | a[i];
                for(int i=l+1;i<=r;i++)
                    or2=or2 | b[i];
            }
            sum=or1+or2;
            if(sum>max)
                max=sum;
        }
        System.out.println(max);
    }
}
