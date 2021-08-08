package cookOff71;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 9/25/16.
 */
public class STICKS {
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
        for(int i=1;i<=t;i++){
            int n=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            int[] A=new int[n];
            for(int j=0;j<n;j++)
                A[j]=Integer.parseInt(st.nextToken());
            Arrays.sort(A);
            int mini=-1,s1=0,s2=0;
            for(int j=n-1;j>=1;j--){
                if(A[j]==A[j-1]){
                    mini=j-1;
                    s1=A[j];
                    break;
                }
            }
            for(int j=mini-1;j>=1;j--){
                if(A[j]==A[j-1]){
                    s2=A[j];
                    break;
                }
            }
            if(s1==0 || s2==0)
                System.out.println(-1);
            else System.out.println(s1*s2);
        }
    }
}
