package a_and_d_of_algos;

import java.util.*;
import java.io.*;
public class Median {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("E://Downloads/Median.txt"));
        StringTokenizer st;
        int i,j=0;
        int[] arr=new int[10000];
        for(i=0;i<=9999;i++){
            arr[i]=Integer.parseInt(br.readLine().trim());
        }
        Vector<Integer> v=new Vector<>();
        int sum=0;
        for(i=0;i<10000;i++){
            v.add(arr[i]);
            Collections.sort(v);
            if(v.size()%2==0)
                sum+=v.elementAt((v.size()/2)-1);
            else
                sum+=v.elementAt(((v.size()+1)/2)-1);
            sum%=10000;
        }
        System.out.println(sum);
    }
}
