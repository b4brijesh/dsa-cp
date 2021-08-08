package classical;

import java.io.*;
import java.util.*;
public class ROADNET {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int i,j,k,l,n;
        int arr[][];
        boolean flag;
        StringTokenizer st;
        for(i=1;i<=t;i++){
            n=Integer.parseInt(br.readLine());
            arr=new int[n][n];
            for(j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                for(k=0;k<n;k++)
                    arr[j][k]=Integer.parseInt(st.nextToken());
            }
            for(j=0;j<n-1;j++){
                for(k=j+1;k<n;k++){
                    flag=false;
                    for(l=0;l<n;l++){
                        if(l==j|| l==k)
                            continue;
                        if((arr[j][l]+arr[l][k])==arr[j][k])
                            flag=true;
                    }
                    if(!flag)
                        System.out.println((j+1)+" "+(k+1));
                }
            }
            br.readLine();
            System.out.println();
        }
    }
}
