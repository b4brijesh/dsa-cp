package cookOff71;

import java.io.*;
import java.sql.Array;
import java.util.*;

/**
 * Created by brijesh on 9/25/16.
 */
public class CHEFLAND {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    static int[] next_vert;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adj_list;
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        adj_list=new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj_list.add(new ArrayList<>());
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            adj_list.get(x).add(y);
            adj_list.get(y).add(x);
        }
        int start_node=1;
        next_vert=new int[n+1];
        visited=new boolean[n+1];
        Arrays.fill(next_vert,0);
        Arrays.fill(visited,false);
        dfs(1);
    }
    static void dfs(int vertex){
        visited[vertex]=true;
        for(int vert:adj_list.get(vertex)){
            if(!visited[vert]){
                dfs(vert);
            }
        }
    }
}
