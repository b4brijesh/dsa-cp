package directI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 10/1/16.
 */
public class NUMSTR {
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
            String a=br.readLine().trim();
            String b=br.readLine().trim();
            char[] arr=a.toCharArray(),brr=b.toCharArray();
            int len_a=arr.length,len_b=brr.length;
            int[][] min_cost=new int[len_b+1][len_a+1];
            for(int j=0;j<len_a+1;j++){
                if(j==0) min_cost[0][j]=0;
                else min_cost[0][j]=min_cost[0][j-1]+(arr[j-1]-48);
            }
            for(int j=0;j<len_b+1;j++){
                if(j==0) min_cost[j][0]=0;
                else min_cost[j][0]=min_cost[j-1][0]+(brr[j-1]-48);
            }
            for(int j=1;j<len_b+1;j++){
                for(int k=1;k<len_a+1;k++){
                    if(arr[k-1]==brr[j-1])
                        min_cost[j][k]=min_cost[j-1][k-1];
                    else {
                        int v1=min_cost[j-1][k]+(brr[j-1]-48);
                        int v2=min_cost[j][k-1]+(arr[k-1]-48);
                        min_cost[j][k]= Math.min(v1,v2);
                    }
                }
            }
            /*for(int j=0;j<len_b+1;j++){
                for(int k=0;k<len_a+1;k++)
                    System.out.print(min_cost[j][k]+" ");
                System.out.println();
            }*/
            System.out.println(min_cost[len_b][len_a]);
        }
    }
}
