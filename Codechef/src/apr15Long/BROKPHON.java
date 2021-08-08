package apr15Long;

import java.io.*;
import java.util.*;

public class BROKPHON {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int i,j,n,count,arr[];
        StringTokenizer st;
        for(i=1;i<=t;i++){
            n=Integer.parseInt(br.readLine());
            arr=new int[n];
            st=new StringTokenizer(br.readLine());
            for(j=0;j<n;j++)
                arr[j]=Integer.parseInt(st.nextToken());
            count=0;
            for(j=1;j<n;j++){
                if(arr[j]!=arr[j-1]){
                    if((j-2)>=0 && arr[j-1]!=arr[j-2])
                        count++;
                    else
                        count+=2;
                }
            }
            System.out.println(count);
        }
    }
}
