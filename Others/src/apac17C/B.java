package apac17C;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 9/18/16.
 */
public class B {
    private static int[][] arr;
    private static boolean[][] visited;
    private static int R,C;
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-small-practice.in"));
        BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-large-practice.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            R=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());
            arr=new int[R][C];
            visited=new boolean[R][C];
            for(int j=0;j<R;j++){
                Arrays.fill(arr[j],0);
                Arrays.fill(visited[j],false);
            }
            for(int j=0;j<K;j++){
                st=new StringTokenizer(br.readLine());
                int Ri=Integer.parseInt(st.nextToken());
                int Ci=Integer.parseInt(st.nextToken());
                arr[Ri][Ci]=1;
            }
            long sum=0;
            int[][] squares=new int[R][C];
            for(int j=0;j<C;j++){
                if(arr[0][j]==0) squares[0][j]=1;
                else squares[0][j]=0;
                sum+=squares[0][j];
            }
            for(int j=0;j<R;j++){
                if(arr[j][0]==0) squares[j][0]=1;
                else squares[j][0]=0;
                sum+=squares[j][0];
            }
            for(int j=1;j<R;j++){
                for(int k=1;k<C;k++){
                    if(arr[j][k]==1) squares[j][k]=0;
                    else {
                        squares[j][k]=Math.min(squares[j-1][k-1],
                                Math.min(squares[j-1][k],squares[j][k-1]))+1;
                    }
                    sum+=squares[j][k];
                }
            }
            sum-=squares[0][0];
            System.out.println("Case #"+(i)+": "+sum);
        }
    }

}
