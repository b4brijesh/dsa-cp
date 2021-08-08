package contest635;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 29-02-2016.
 */
//not solved
public class B635 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int ak=-1,bk=-1;
        int[] arr=new int[n];
        int[] b1=new int[n];
        int[] b2=new int[n];
        int[] b3=new int[n];
        int[] b4=new int[n];
        int[] b5=new int[n];
        int[] b6=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            b1[i]=arr[i];
            b2[i]=arr[i];
            b3[i]=arr[i];
            b4[i]=arr[i];
            b5[i]=arr[i];
            b6[i]=arr[i];
            if(arr[i]==0)
                ak=i;
        }
        int[] brr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            brr[i]=Integer.parseInt(st.nextToken());
            if(brr[i]==0)
                bk=i;
        }
        int flag=0;
        if(bk==ak){
            for(int i=0;i<n;i++)
                if(arr[i]!=brr[i]){
                    break;
                }
            for(int i=0;i<n;i++){
                b5[(i+ak)%n]=b5[(i+ak+1)%n];
                b5[(i+ak+1)%n]=0;
            }
            for(int i=0;i<n;i++)
                if(b5[i]!=brr[i]){
                    break;
                }
            for(int i=n;i>0;i--){
                b6[(i-ak)%n]=b5[(i-ak-1)%n];
                b6[(i-ak-1)%n]=0;
            }
            for(int i=0;i<n;i++)
                if(b6[i]!=brr[i]){
                    break;
                }
        }
        if(bk>ak){
            for(int i=ak;i<bk;i++){
                b1[i]=b1[i+1];
                b1[i+1]=0;
            }
            for(int i=0;i<n;i++)
                if(b1[i]!=brr[i]){
                    break;
                }
            for(int i=ak;i!=bk;i--){
                if(i==0){
                    b2[0]=b2[n-1];
                    b2[n-1]=0;
                    i=n-1;
                    continue;
                }
                b2[i]=b2[i-1];
                b2[i-1]=0;
            }
            for(int i=0;i<n;i++)
                if(b2[i]!=brr[i]){
                    flag=1;
                    break;
                }
        }
        if(bk<ak){
            for(int i=ak;i!=bk;i++){
                if(i==n-1){
                    b3[n-1]=b3[0];
                    b3[0]=0;
                    i=0;
                    continue;
                }
                b3[i]=b3[i+1];
                b3[i+1]=0;
            }
            for(int i=0;i<n;i++)
                if(b3[i]!=brr[i]){
                    break;
                }
            for(int i=ak;i>bk;i--){
                b4[i]=b4[i-1];
                b4[i-1]=0;
            }
            for(int i=0;i<n;i++)
                if(b4[i]!=brr[i]){
                    flag=1;
                    break;
                }
        }
        if(flag==1)
            System.out.println("NO");
        else System.out.println("YES");
    }
}
