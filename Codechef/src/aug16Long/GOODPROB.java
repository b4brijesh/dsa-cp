package aug16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 15-08-2016.
 */
public class GOODPROB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        int[][] max=new int[n][n];
        for(int i=0;i<n;i++){
            max[i][i]=arr[i];
            for(int j=i+1;j<n;j++)
                max[i][j]=Math.max(max[i][j-1],arr[j]);
        }
        byte[][] F=new byte[n][n];
        long sum=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                F[i][j]=(((arr[i]&arr[j])==arr[i]) || ((arr[i]&arr[j])==arr[j]))?(byte)1:(byte)0;
                if(F[i][j]==(byte)1) sum+=max[i][j];
            }
        }
        System.out.println(sum);
    }
}
