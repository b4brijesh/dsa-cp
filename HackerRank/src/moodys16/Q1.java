package moodys16;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 9/30/16.
 */
public class Q1 {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        long max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            String[] nums=br.readLine().split(" ");
            int a=Integer.parseInt(nums[0]),b=Integer.parseInt(nums[1]),c=Integer.parseInt(nums[2]);
            long sum=0;
            if(a>b){
                if(a>c){
                    if(b>c) sum+=a+b;
                    else sum+=a+c;
                } else sum+=c+a;
            } else {
                if(b>c){
                    if(a>c) sum+=b+a;
                    else sum+=b+c;
                } else sum+=c+b;
            }
            max=Math.max(sum,max);
        }
        System.out.println(max);
    }
}
