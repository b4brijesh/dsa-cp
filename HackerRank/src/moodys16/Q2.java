package moodys16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 10/2/16.
 */
public class Q2 {
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
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        double[] p=new double[n];
        double[] x=new double[n];
        double[] y=new double[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            p[i]=Double.parseDouble(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            x[i]=Double.parseDouble(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            y[i]=Double.parseDouble(st.nextToken());
        double[] exp=new double[n];
        for(int i=0;i<n;i++)
            exp[i]=(p[i]*x[i])-((1-p[i])*y[i]);
        Arrays.sort(exp);
        double sum=0;
        for(int i=n-1,j=1;j<=k;j++,i--){
            if(exp[i]<0) break;
            sum+=exp[i];
        }
        System.out.printf("%.2f",sum);
    }
}
