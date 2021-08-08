package sept16Long;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 9/8/16.
 */
public class CHFNFRN2 {
    static boolean[][] adj_mat;
    static int[] set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            adj_mat=new boolean[n][n];
            set=new int[n];
            for(int j=0;j<n;j++){
                Arrays.fill(adj_mat[j],false);
                adj_mat[j][j]=true;
                set[j]=0;
            }
            for(int j=0;j<m;j++){
                st=new StringTokenizer(br.readLine());
                int ai=Integer.parseInt(st.nextToken());
                int bi=Integer.parseInt(st.nextToken());
                adj_mat[ai-1][bi-1]=true;
                adj_mat[bi-1][ai-1]=true;
            }
            boolean poss=true;
            int init=0,cur1=1,cur2=2;
            boolean left;
            do{
                Queue<Integer> q=new LinkedList<>();
                q.add(init);
                set[init]=cur1;
                poss=check(q,cur1,cur2);
                if(!poss){
                    System.out.println("NO");
                    break;
                }
                left=false;
                for(int j=0;j<n;j++){
                    if(set[j]==0){
                        init=j;
                        left=true;
                        cur1+=2;cur2+=2;
                    }
                }
            }while(left);
            if(poss) System.out.println("YES");
        }
    }
    static boolean check(Queue<Integer> q, int cur1,int cur2){
        //System.out.println("curs="+cur1+" "+cur2+" "+ q.peek());
        boolean poss=true;
        outer:while(!q.isEmpty()){
            int num=q.remove();
            int cur,n=set.length;
            if(set[num]==cur1) cur=cur2; else cur=cur1;
            for(int j=0;j<n;j++){
                if(!adj_mat[num][j]){
                    if(set[j]<cur1 && set[j]!=0)
                        continue;
                    if(set[j]==cur)
                        continue;
                    if(set[j]==0){
                        q.add(j);
                        set[j]=cur;
                    }
                    else{
                        poss=false;
                        break outer;
                    }
                }
            }
        }
        //System.out.println(poss);
        return poss;
    }
}
