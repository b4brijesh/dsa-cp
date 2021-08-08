package codeJam8Apr16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 10-Apr-2016.
 */
public class FindPrimes {
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Downloads/B-large.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr=new int[1000001];
        boolean[] arr2=new boolean[1000001];
        for(int i=2;i<=100000;i++){
            arr[i]=i;
            arr2[i]=true;
        }
        for(int i=2;i<=1000000;i++){
            if(arr2[i]==true){
                int j=arr[i],k=2;
                while(j*k<=1000000){
                    arr2[(j*k)]=false;
                    k++;
                }
            }
        }
        for(int i=2;i<=1000000;i++){
            if(arr2[i]==true)
                System.out.print(arr[i]+",");
        }
    }
}
