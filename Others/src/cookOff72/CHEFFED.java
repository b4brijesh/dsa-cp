package cookOff72;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 9/22/16.
 */
public class CHEFFED {
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
        int begin=n-200;
        int end=n;
        int c=0;
        for(int i=begin;i<=end;i++){
            if(i<0) continue;
            int num=i;
            int sod=sumOfDigs(num);
            int s_sod=sumOfDigs(sod);
            if((num+sod+s_sod)==n)
                c++;
        }
        System.out.println(c);
    }
    private static int sumOfDigs(int n){
        int sum=0;
        while(n>0){
            int dig=n%10;
            sum+=dig;
            n=n/10;
        }
        return sum;
    }
}
