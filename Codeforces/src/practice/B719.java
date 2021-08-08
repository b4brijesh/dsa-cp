package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 9/24/16.
 */
public class B719 {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        String str_i=br.readLine().trim();
        char[] str=str_i.toCharArray();
        int r_count=0,b_count=0;
        for(int i=0;i<n;i++){
            if(str[i]=='r'){
                r_count++;
            }
            else b_count++;
        }
        int rc=r_count,bc=b_count;
        int r_w=0,b_w=0;
        //rbrbrbrb
        for(int i=0;i<n;i++){
            if(i%2==0 && str[i]=='b') r_w++;
            if(i%2!=0 && str[i]=='r') b_w++;
        }
        int turns=Math.min(r_w,b_w)+(Math.abs(r_w-b_w));
        //brbrbr
        r_w=0;b_w=0;
        for(int i=0;i<n;i++){
            if(i%2==0 && str[i]=='r') b_w++;
            if(i%2!=0 && str[i]=='b') r_w++;
        }
        int t2=Math.min(r_w,b_w)+(Math.abs(r_w-b_w));
        System.out.println(Math.min(turns,t2));
    }
}
