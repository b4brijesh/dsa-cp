package jan17Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Brijesh on 10-01-2017.
 */
public class TOURISTS2 {
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
        n=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        int[] arr=new int[n+1];
        //+1=start dot; -1=end arrow
        edges=new int[e][2];
        edge=new int[e][2];
        for (int i=0;i<e;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            edges[i][0]=a;
            edges[i][1]=b;
            edge[i][0]=a;
            edge[i][1]=b;
        }
        ArrayList<ArrayList<Map.Entry<Integer,Integer>>> adj_out=new ArrayList<>();
        ArrayList<ArrayList<Map.Entry<Integer,Integer>>> adj_in=new ArrayList<>();
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
        int[] balance=new int[n+1];
        Arrays.fill(balance,0);
        boolean[] visited=new boolean[n+1];
        Arrays.fill(visited,false);
        boolean[] completed=new boolean[n+1];
        Arrays.fill(completed,false);
        Queue<Integer> que=new LinkedList<>();
        int k=(int) (Math.random()*(n-1))+1;
        visited[k]=true;
        que.add(k);
        while (!que.isEmpty()){
            int node=que.remove();
            if (completed[node]) continue;
            int eds=adj_in.get(node).size()+adj_out.get(node).size();
            if (eds%2!=0){
                System.out.println("NO");
                return;
            }
            for (int i=0;i<adj_in.get(node).size();i++){
                int nod2=adj_in.get(node).get(i).getKey();
                int idx=adj_in.get(node).get(i).getValue();
                if (completed[nod2]) continue;
                if (visited[nod2]){
                    if (balance[nod2]>0){
                        balance[nod2]-=1;
                        balance[node]+=1;
                        edges[idx][0]=node;
                        edges[idx][1]=nod2;
                    }
                    else {
                        balance[nod2]+=1;
                        balance[node]-=1;
                    }
                }
            }
            for (int i=0;i<adj_out.get(node).size();i++){
                int nod2=adj_out.get(node).get(i).getKey();
                int idx=adj_out.get(node).get(i).getValue();
                if (completed[nod2]) continue;
                if (visited[nod2]){
                    if (balance[nod2]<0){
                        balance[nod2]+=1;
                        balance[node]-=1;
                        edges[idx][0]=nod2;
                        edges[idx][1]=node;
                    }
                    else {
                        balance[nod2]-=1;
                        balance[node]+=1;
                    }
                }
            }
            for (int i=0;i<adj_in.get(node).size();i++){
                int nod2=adj_in.get(node).get(i).getKey();
                int idx=adj_in.get(node).get(i).getValue();
                if (completed[nod2]) continue;
                if (!visited[nod2]){
                    //visited[nod2]=true;
                    if (balance[node]>0){
                        balance[node]-=1;
                        balance[nod2]+=1;
                    } else {
                        balance[node]+=1;
                        balance[nod2]-=1;
                        edges[idx][0]=node;
                        edges[idx][1]=nod2;
                    }
                }
            }
            for (int i=0;i<adj_out.get(node).size();i++){
                int nod2=adj_out.get(node).get(i).getKey();
                int idx=adj_out.get(node).get(i).getValue();
                if (completed[nod2]) continue;
                if (!visited[nod2]){
                    //visited[nod2]=true;
                    if (balance[node]>0){
                        balance[node]-=1;
                        balance[nod2]+=1;
                        edges[idx][0]=nod2;
                        edges[idx][1]=node;
                    } else {
                        balance[node]+=1;
                        balance[nod2]-=1;
                    }
                }
            }
            for (int i=0;i<adj_in.get(node).size();i++){
                int nod2=adj_in.get(node).get(i).getKey();
                int idx=adj_in.get(node).get(i).getValue();
                if (completed[nod2]) continue;
                if (!visited[nod2]){
                    visited[nod2]=true;
                    que.add(nod2);
                }
            }
            for (int i=0;i<adj_out.get(node).size();i++){
                int nod2=adj_out.get(node).get(i).getKey();
                int idx=adj_out.get(node).get(i).getValue();
                if (completed[nod2]) continue;
                if (!visited[nod2]){
                    visited[nod2]=true;
                    que.add(nod2);
                }
            }
            completed[node]=true;
        }
        for (int i=1;i<=n;i++)
            if (!completed[i]){
                System.out.println("NO");
                return;
            }

        /*System.out.println("YES");
        for (int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            System.out.println(a+" "+b);
        }*/
        newFunc();

        System.exit(0);
    }
    static ArrayList<ArrayList<Map.Entry<Integer,Integer>>> adj_out,adj_in;
    static int[][] edge,edges;
    static boolean[] visited,checked;
    static int[] counter,c2;
    static int n,e;
    static void newFunc(){
        checked=new boolean[e+1];
        Arrays.fill(checked,false);
        adj_out=new ArrayList<>();
        adj_in=new ArrayList<>();
        for (int i=0;i<=n;i++){
            adj_out.add(new ArrayList<>());
            adj_in.add(new ArrayList<>());
        }
        for (int i=0;i<e;i++){
            int a=edge[i][0];
            int b=edge[i][1];
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
        for (int i=0;i<edge.length;i++){
            int a=edge[i][0];
            int b=edge[i][1];
            System.out.println(a+" "+b);
        }
    }
    static int cnt=0;
    static void dfs(int node){
        cnt++;
        //if (visited[node]) return;
        if (cnt>100000)
        {
            System.out.println("YES");
            for (int i=0;i<edges.length;i++){
                int a=edges[i][0];
                int b=edges[i][1];
                System.out.println(a+" "+b);
            }
            System.exit(0);
        }
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
            edge[idx][0]=node;
            edge[idx][1]=next_node;
            dfs(next_node);
        }
    }
}
