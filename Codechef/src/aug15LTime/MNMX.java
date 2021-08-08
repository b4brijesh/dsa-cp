package aug15LTime;

import java.io.*;
import java.util.*;
public class MNMX {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i,j,n;
        for(i=0;i<t;i++){
            n=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            int[] arr=new int[n];
            int min=100001;
            for(j=0;j<n;j++){
                arr[j]=Integer.parseInt(st.nextToken());
                min=Math.min(min,arr[j]);
            }
            long cost=(long)min*(long)(n-1);
            System.out.println(cost);
        }
    }
}
