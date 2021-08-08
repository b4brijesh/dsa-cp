package classical;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 03-02-2016.
 */
public class INVCNT {
    static long count=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        int i;
        for(i=1;i<=t;i++){
            br.readLine();
            int n=Integer.parseInt(br.readLine());
            int[] arr=new int[n];
            for(int j=0;j<n;j++)
                arr[j]=Integer.parseInt(br.readLine());
            count=0;
            arr=sort(arr,n);
            System.out.println(count);
        }
    }
    static int[] sort(int[] z,int len){
        if(len<=1){
            return z;
        }
        int arr1[]=new int[(len+1)/2];
        int arr2[]=new int[len/2];
        int k,l=0,m=(len+1)/2;
        for(k=0;k<(len+1)/2;k++){
            arr1[k]=z[l++];
        }
        for(k=0;k<len/2;k++){
            arr2[k]=z[m++];
        }
        arr1=sort(arr1,(len+1)/2);
        arr2=sort(arr2,len/2);
        l=0;
        m=0;
        for(k=0;k<len;k++){
            if((m==(len/2))||((l<((len+1)/2))&&(arr1[l]<=arr2[m]))){
                z[k]=arr1[l++];
            }
            else{
                z[k]=arr2[m++];
                count=count+arr1.length-l;
            }
        }
        return z;
    }
}
