package moodys16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 10/2/16.
 */
public class Q4 {
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
        int[] p=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            p[i]=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj_list=new ArrayList<>();
        Node[] nodes=new Node[n];
        for(int i=0;i<n;i++){
            adj_list.add(new ArrayList<>());
            nodes[i]=new Node(i);
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken())-1;
            int v=Integer.parseInt(st.nextToken())-1;
            adj_list.get(u).add(v);
            adj_list.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            int sum=p[i];
            for(int j=0;j<adj_list.get(i).size();j++){
                sum-=p[adj_list.get(i).get(j)];
            }
            nodes[i].eff_val=sum;
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                return t1.eff_val-node.eff_val;
            }
        });
        boolean[] rejected=new boolean[n];
        Arrays.fill(rejected,false);
        int sum=0;
        for(int i=0;i<n;i++){
            int idx=nodes[i].index;
            if(!rejected[idx]){
                //System.out.println(idx+" "+p[idx]);
                sum+=p[idx];
                for(int j=0;j<adj_list.get(idx).size();j++){
                    //System.out.print("f"+j);
                    rejected[adj_list.get(idx).get(j)]=true;
                }
            }
        }
        System.out.println(sum);
    }
    private static class Node{
        int index,eff_val=Integer.MIN_VALUE;
        Node(int index){this.index=index;}
    }
}
