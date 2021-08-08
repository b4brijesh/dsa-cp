package july15Cook;

import java.io.*;
import java.util.*;

public class COPS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i;
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int m=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int z=x*y;
            st=new StringTokenizer(br.readLine());
            int j;
            int[] arr=new int[m];
            for(j=0;j<m;j++)
                arr[j]=Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int[] range=new int[2*m];
            for(j=0;j<m;j++){
                range[2*j]=arr[j]-z;
                range[2*j+1]=arr[j]+z;
            }
            int count=0;
            if(range[0]>1)
                count=count+range[0]-1;
            for(j=1;j<m;j++){
                if(range[2*j]>range[2*(j-1)+1])
                    count=count+range[2*j]-range[2*(j-1)+1]-1;
            }
            if(range[2*m-1]<100)
                count=count+100-range[2*m-1];
            System.out.println(count);
        }
    }
}
