package round308;

import java.io.*;
import java.util.*;
public class A552 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int i,j,k;
        int arr1[]=new int[n],arr2[]=new int[n],arr3[]=new int[n],arr4[]=new int[n];
        for(i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            arr1[i]=Integer.parseInt(st.nextToken())-1;
            arr2[i]=Integer.parseInt(st.nextToken())-1;
            arr3[i]=Integer.parseInt(st.nextToken())-1;
            arr4[i]=Integer.parseInt(st.nextToken())-1;
        }
        int arr[][]=new int[100][100];
        for(i=0;i<100;i++){
            for(j=0;j<100;j++){
                for(k=0;k<n;k++){
                    if(j>=arr1[k]&&i>=arr2[k] && j<=arr3[k]&&i<=arr4[k])
                        arr[i][j]++;
                }
            }
        }
        int sum=0;
        for(i=0;i<100;i++){
            for(j=0;j<100;j++){
                sum=sum+arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
