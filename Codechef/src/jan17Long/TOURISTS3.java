package jan17Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 10-01-2017.
 */
public class TOURISTS3 {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());
        int[] arr=new int[n+1];
        //+1=start dot; -1=end arrow
        edges=new int[e][2];
        //int[][] backup=new int[e][2];
        for (int i=0;i<e;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            edges[i][0]=a;
            edges[i][1]=b;
        }
        checked=new boolean[e+1];
        Arrays.fill(checked,false);
        adj_out=new ArrayList<>();
        adj_in=new ArrayList<>();
        for (int i=0;i<=n;i++){
            adj_out.add(new ArrayList<>());
            adj_in.add(new ArrayList<>());
        }
        for (int i=0;i<e;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            adj_out.get(a).add(new AbstractMap.SimpleEntry<Integer, Integer>(b,i));
            adj_in.get(b).add(new AbstractMap.SimpleEntry<Integer, Integer>(a,i));
        }
        for (int i=1;i<=n;i++){
            int eds=adj_in.get(i).size()+adj_out.get(i).size();
            if (eds%2!=0){
                System.out.println("NO");
                return;
            }
        }
        visited=new boolean[n+1];
        Arrays.fill(visited,false);
        counter=new int[n+1];
        Arrays.fill(counter,0);
        c2=new int[n+1];
        Arrays.fill(c2,0);
        dfs(1);
        for (int i=1;i<=n;i++)
            if (!visited[i]){
                System.out.println("NO");
                return;
            }

        System.out.println("YES");
        for (int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            System.out.println(a+" "+b);
        }

        System.exit(0);
    }
    static ArrayList<ArrayList<Map.Entry<Integer,Integer>>> adj_out,adj_in;
    static int[][] edges;
    static boolean[] visited,checked;
    static int[] counter,c2;
    static void dfs(int node){
        //if (visited[node]) return;
        if (!visited[node])
            visited[node]=true;
        ArrayList<Map.Entry<Integer,Integer>> outs=adj_out.get(node);
        for (int i=counter[node];i<outs.size();i++){
            Map.Entry<Integer,Integer> e=outs.get(i);
            int next_node=e.getKey();
            int idx=e.getValue();
            if (checked[idx]) continue;
            checked[idx]=true;
            counter[node]=i+1;
            dfs(next_node);
        }
        ArrayList<Map.Entry<Integer,Integer>> ins=adj_in.get(node);
        for (int i=c2[node];i<ins.size();i++){
            Map.Entry<Integer,Integer> e=ins.get(i);
            int next_node=e.getKey();
            int idx=e.getValue();
            if (checked[idx]) continue;
            checked[idx]=true;
            c2[node]=i+1;
            edges[idx][0]=node;
            edges[idx][1]=next_node;
            dfs(next_node);
        }
    }
}
