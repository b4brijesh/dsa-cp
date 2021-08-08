package classical;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 03-02-2016.
 */
public class CRDS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long[] arr=new long[1000000];
        arr[0]=3;
        for(int i=1;i<1000000;i++){
            arr[i]=(arr[i-1]+3*(i+1))%1000007;
        }
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            int j=Integer.parseInt(br.readLine());
            System.out.println(arr[j-1]-j);
        }
    }
}
