package cookOff64;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/11/16.
 */
public class SEAARASU {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-practice.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            int n=Integer.parseInt(br.readLine());
            if(n==1){
                int a=Integer.parseInt(br.readLine());
                System.out.println(a);
                continue;
            }
            int[] arr=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                arr[j]=Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int gcd=arr[0];
            for (int j=1;j<n;j++){
                gcd=find_gcd(arr[j],gcd);
            }
            long sum=(long)(gcd)*(long)(n);
            System.out.println(sum);
        }

        System.exit(0);
    }
    private static int find_gcd(int dividend,int divisor){
        int rem=dividend%divisor;
        if(rem==0) return divisor;
        else return find_gcd(divisor,rem);
    }
}
