package ZeptoLabCodeRush15;

import java.io.*;
import java.util.*;
public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num=(int)Math.pow(2,n+1);
        int arr[]=new int[num];
        arr[0]=arr[1]=0;
        int i,j,k,l,max=0,sum=0,count;
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(i=2;i<num;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        k=(int)Math.pow(2,n+1)-1;
        l=(int)Math.pow(2,n);
        int arr2[]=new int[n];
        for(i=k;i>=l;i--){
            j=i;
            count=0;
            while(j>0){
                count=count+arr[j];
                j=j/2;
            }
            max=Math.max(max,count);
        }
    }
}
