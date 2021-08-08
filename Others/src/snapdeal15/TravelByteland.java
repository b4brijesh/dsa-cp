package snapdeal15;

import java.io.*;
import java.util.*;

public class TravelByteland {
    static int[][] arr;
    static int[][] arr2;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int i,j;
        arr=new int[n][m];
        arr2=new int[n][m];
        for(i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(j=0;j<m;j++)
                arr[i][j]=Integer.parseInt(st.nextToken());
            Arrays.fill(arr2[i],-1);
        }
        arr2[0][0]=arr[0][0];
        int x=dp(n-1,m-1);
        System.out.println(x);
    }
    static int dp(int i,int j){
        int k;
        arr2[i][j]=0;
        for(k=0;k<=i-1;k++){
            if(arr2[k][j]==-1)
                arr2[k][j]=dp(k,j);
            //System.out.print("["+k+"]["+j+"]="+arr2[k][j]+" ");
            arr2[i][j]+=(arr[i][j]*arr2[k][j]);
            //System.out.println("arr2["+i+"]["+j+"]="+arr2[i][j]);
        }
        //System.out.println(1);
        for(k=0;k<=j-1;k++){
            if(arr2[i][k]==-1)
                arr2[i][k]=dp(i,k);
            //System.out.print("["+i+"]["+k+"]="+arr2[i][k]+" ");
            arr2[i][j]+=(arr[i][j]*arr2[i][k]);
            //System.out.println("arr2["+i+"]["+j+"]="+arr2[i][j]);
        }
        //System.out.println(2);
        for(k=1;k<=Math.min(i,j);k++){
            if(arr2[i-k][j-k]==-1)
                arr2[i-k][j-k]=dp(i-k,j-k);
            //System.out.print("["+(i-k)+"]["+(i-j)+"]="+arr2[i-k][i-j]+" ");
            arr2[i][j]+=(arr[i][j]*arr2[i-k][j-k]);
            //System.out.println("arr2["+i+"]["+j+"]="+arr2[i][j]);
        }
        //System.out.println(3);
        return arr2[i][j];
    }
}
