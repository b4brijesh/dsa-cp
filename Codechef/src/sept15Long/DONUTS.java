package sept15Long;

import java.io.*;
import java.util.*;
public class DONUTS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i,j;
        for(i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            int[] arr=new int[m];
            for(j=0;j<m;j++)
                arr[j]=Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int nchains=m,cuts=0;
            j=0;
            while(nchains>1){
                /*if(arr[j]==nchains-2){
                    cuts+=arr[j];
                    nchains-=arr[j]+1;
                }*/
                if(arr[j]<=nchains-2){
                    cuts+=arr[j];
                    nchains-=arr[j]+1;
                }
                else {
                    cuts+=nchains-1;
                    nchains=1;
                }
                j++;
            }
            System.out.println(cuts);
        }
    }
}
