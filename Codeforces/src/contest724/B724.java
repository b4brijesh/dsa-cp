package contest724;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/9/16.
 */
public class B724 {
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
        int m=Integer.parseInt(st.nextToken());
        int[][] rows=new int[n+1][m+1];
        int[][] count=new int[m+1][m+1];
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                rows[i][j]=Integer.parseInt(st.nextToken());
                count[j][rows[i][j]]++;
            }
        }
        int[] maxes=new int[m+1];
        int[] max_num=new int[m+1];
        for(int i=1;i<=m;i++){
            int max_count=0;
            for(int j=1;j<=m;j++){
                if(count[i][j]>max_count){
                    max_count=count[i][j];
                    max_num[i]=j;
                }
            }
            if(max_count==count[i][i])
                max_count=0;
            maxes[i]=max_count;
        }
        boolean[] visitd=new boolean[m+1];
        int max_count,max_col_idx,swa=0;
        do{
            max_count=0;
            max_col_idx=-1;
            for(int i=1;i<=m;i++){
                if(!visitd[i] && maxes[i]>max_count){
                    max_count=maxes[i];
                    max_col_idx=i;
                }
            }
            if(max_count<=0) break;
            visitd[max_col_idx]=true;
            visitd[max_num[max_col_idx]]=true;
            for(int i=1;i<=n;i++){
                int temp=rows[i][max_col_idx];
                rows[i][max_col_idx]=rows[i][max_num[max_col_idx]];
                rows[i][max_num[max_col_idx]]=temp;
            }
            swa++;
        } while (max_count>1);
        int[] swaps=new int[n+1];
        for(int i=1;i<=n;i++){
            boolean[] visited=new boolean[m+1];
            Arrays.fill(visited,false);
            for(int j=1;j<=m;j++){
                int grp_len=0;
                if(!visited[j]){
                    grp_len++;
                    visited[j]=true;
                    int next_idx=rows[i][j];
                    while(!visited[next_idx]){
                        visited[next_idx]=true;
                        grp_len++;
                        next_idx=rows[i][next_idx];
                    }
                }
                if(grp_len!=0) swaps[i]+=(grp_len-1);
            }
        }
        boolean poss=true;
        int tot_sums=swa;
        for(int i=1;i<=n;i++){
            if (swaps[i]>1) poss=false;
            tot_sums++;
        }
        if(!poss) System.out.println("NO");
        else{
            if(tot_sums<=n+1)
                System.out.println("YES");
            else System.out.println("NO");
        }

        System.exit(0);
    }
}
