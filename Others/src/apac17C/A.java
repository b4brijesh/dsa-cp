package apac17C;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 9/18/16.
 */
public class A {
    static char[][] arr;
    static int[][] visited;
    static boolean[][] gathered;
    static double P,Q;
    static int R,C,S;
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-large-practice.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            R=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            int Rs=Integer.parseInt(st.nextToken());
            int Cs=Integer.parseInt(st.nextToken());
            S=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            P=Double.parseDouble(st.nextToken());
            Q=Double.parseDouble(st.nextToken());
            arr=new char[R][C];
            visited=new int[R][C];
            gathered=new boolean[R][C];
            for(int j=0;j<R;j++){
                st=new StringTokenizer(br.readLine());
                for (int k=0;k<C;k++)
                    arr[j][k]=st.nextToken().charAt(0);
            }
            for(int j=0;j<R;j++){
                Arrays.fill(visited[j],0);
                Arrays.fill(gathered[j],false);
            }
            double prob=0;
            if(Cs-1>=0)
                prob=Math.max(prob,recursion(Rs,Cs-1,S-1));
            if(Rs-1>=0)
                prob=Math.max(prob,recursion(Rs-1,Cs,S-1));
            if(Cs+1<C)
                prob=Math.max(prob,recursion(Rs,Cs+1,S-1));
            if(Rs+1<R)
                prob=Math.max(prob,recursion(Rs+1,Cs,S-1));
            System.out.println("Case #"+(i+1)+": "+prob);
        }
    }
    private static double recursion(int row,int col,int steps){
        //System.out.println(row+" "+col+" "+steps);
        if(steps==-1)
            return 0;
        visited[row][col]++;
        double pr;
        gathered[row][col]=true;
        double m2=0;
        if(arr[row][col]=='A')
            pr=Math.pow((1-P),visited[row][col]-1)*P;
        else pr=Math.pow((1-Q),visited[row][col]-1)*Q;
        if(col-1>=0){
            m2=Math.max(m2,pr+recursion(row,col-1,steps-1));
        }
        if(row-1>=0){
            m2=Math.max(m2,pr+recursion(row-1,col,steps-1));
        }
        if(col+1<C){
            m2=Math.max(m2,pr+recursion(row,col+1,steps-1));
        }
        if(row+1<R){
            m2=Math.max(m2,pr+recursion(row+1,col,steps-1));
        }
        gathered[row][col]=false;
        visited[row][col]--;
        //System.out.println(m+" "+m2);
        return Math.max(0,m2);
    }
}
