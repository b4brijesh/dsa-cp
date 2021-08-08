package practice;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/10/16.
 */
public class A446 {
    static double e_07=0.0000001;
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
        int n=Integer.parseInt(br.readLine());
        int[] a=new int[n];
        st=new StringTokenizer(br.readLine());
        boolean full_inc=true;
        for (int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
            if(i!=0 && a[i]<=a[i-1]) full_inc=false;
        }
        if(full_inc) System.out.println(n);
        else {
            int i=1,max_len=1;
            for (;i<n;){
                int len=1;
                while (i<n && a[i]>a[i-1]){
                    i++;
                    len++;
                }
                if(i>=n-1) {
                    max_len=Math.max(max_len,len+1);
                    break;
                }
                if(i<2){
                    max_len=Math.max(max_len,len+1);
                    i++;
                    continue;
                }
                int j=i;
                if (a[i+1]-a[i-1]>1 || a[i]-a[i-2]>1){
                    i++;
                    while (i<n && a[i]>a[i-1]){
                        i++;
                        len++;
                    }
                }
                max_len=Math.max(max_len,len+1);
                i=j+1;
            }
            System.out.println(max_len);
        }
        System.exit(0);
    }
}
