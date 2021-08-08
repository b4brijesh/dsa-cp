package contest733;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 01-11-2016.
 */
public class C733 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] a=new int[n];
        int[] cum=new int[n+1];
        cum[0]=0;
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
            cum[i+1]=cum[i]+a[i];
        }
        int k=Integer.parseInt(br.readLine());
        int[] b=new int[k];
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<k;i++){
            b[i]=Integer.parseInt(st.nextToken());
        }
        int init=0,j=0;
        boolean flag=true;
        for (int i=0;i<n;i++){
            if (a[i]>b[j]){
                flag=false;
                break;
            }
            if (a[i]==b[j]){
                j++;
                continue;
            }
            if (a[i]!=a[i+1]){
                int sum=a[i]+a[i+1];
                a[i]=0;a[i+1]=sum;
            }
            else {
                int m=i;
                while (m+1<n && a[m]==a[m+1]){
                    m++;
                }
                if (m+1==n) {
                    flag=false;
                    break;
                }
            }
        }
    }
}
