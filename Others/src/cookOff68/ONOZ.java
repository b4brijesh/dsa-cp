package cookOff68;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 10/4/16.
 */
public class ONOZ {
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
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int h=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int[] m_arr=new int[10];
            for(int j=0;j<10;j++){
                if(j<m) m_arr[j]++;
                if(j==0) continue;
                if(((10*j)+j)<m) m_arr[j]++;
            }
            int[] h_arr=new int[10];
            for(int j=0;j<10;j++){
                if(j<h) h_arr[j]++;
                if(j==0) continue;
                if(((10*j)+j)<h) h_arr[j]++;
            }
            int sum=0;
            for(int j=0;j<10;j++)
                sum+=(h_arr[j]*m_arr[j]);
            System.out.println(sum);
        }
        System.exit(0);
    }
}
