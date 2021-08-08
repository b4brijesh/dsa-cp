package cookOff69;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 9/27/16.
 */
public class ODDDIV {
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
        int t=Integer.parseInt(br.readLine());
        long[] arr=new long[100001];
        Arrays.fill(arr,1);
        arr[0]=0;
        for(int i=3;i<=100000;i+=2){
            for(int j=1;(j*i)<=100000;j++){
                arr[j*i]+=i;
            }
        }
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int l=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());
            long sum=0;
            for(int j=l;j<=r;j++){
                sum+=arr[j];
            }
            System.out.println(sum);
        }
    }
}
