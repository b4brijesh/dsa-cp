package a_and_d_of_algos;

import java.util.*;
import java.io.*;
public class TwoSum {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("E://Downloads/algo1-programming_prob-2sum.txt"));
        StringTokenizer st;
        int i,j,count=0;
        long n,s;
        long[] arr=new long[1000000];
        for(i=1;i<=1000000;i++){
            n=Long.parseLong(br.readLine());
            arr[i-1]=n;
        }
        boolean[] sum=new boolean[20001];
        Arrays.fill(sum,false);
        for(i=0;i<1000000;i++){
            if(i%10000==0)
                System.out.println(i);
            for(j=i+1;j<1000000;j++){
                s=arr[i]+arr[j];
                if(s+10000<20000 && s+10000>=0 && !sum[(int)s+10000])
                    sum[(int)s+10000]=true;
            }
        }
        for(i=0;i<20001;i++)
            if(sum[i])
                count++;
        System.out.println(count);
    }
}
