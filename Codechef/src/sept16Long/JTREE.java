package sept16Long;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 9/10/16.
 */
public class JTREE {
    static ArrayList<Long> tree;
    static ArrayList<ArrayList<Integer>> adj_list;
    static ArrayList<ArrayList<kwPair>> ticket;
    static int N,M;
    static long[] min_cost;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());//N=num_of_cities
        M=Integer.parseInt(st.nextToken());//M=num_of_tickets
        adj_list=new ArrayList<>();
        for(int i=0;i<N;i++)
            adj_list.add(new ArrayList<>());
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int ai=Integer.parseInt(st.nextToken());
            int bi=Integer.parseInt(st.nextToken());
            adj_list.get(bi-1).add(ai-1);
        }
        ticket=new ArrayList<>();
        for(int i=0;i<N;i++)
            ticket.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int vi=Integer.parseInt(st.nextToken());
            int ki=Integer.parseInt(st.nextToken());
            int wi=Integer.parseInt(st.nextToken());
            ticket.get(vi-1).add(new kwPair(ki,wi));
        }
        tree=new ArrayList<>();
        for(int j=0;j<1000007;j++)
            tree.add(j,Long.MAX_VALUE);
        update(1,0,N-1,0,0);
        min_cost=new long[N];
        min_cost[0]=0;

        Stack<Integer> stack= new Stack<>();
        stack.push(-1);
        for(int i=0;i<adj_list.get(0).size();i++){
            int new_node=adj_list.get(0).get(i);
            stack.push(new_node);
        }
        int count=0;
        while(!stack.isEmpty()){
            int node=stack.pop();
            if(node==-1) {
                count--;
                continue;
            }
            update(1,0,N-1,count+1,Long.MAX_VALUE);
            long min=Long.MAX_VALUE;
            for(int j=0;j<ticket.get(node).size();j++){
                int ki=ticket.get(node).get(j).times;
                long wi=ticket.get(node).get(j).cost;
                //System.out.println("kw="+ki+" "+wi);
                //System.out.println("range="+(count-ki+1)+" "+count);
                if(count-ki+1>=0)
                    min=Math.min(min,wi+query(1,0,N-1,count-ki+1,count));
                else min=Math.min(min,wi+query(1,0,N-1,0,count));
            }
            min_cost[node]=min;
            update(1,0,N-1,count+1,min);
            stack.push(-1);
            count++;
            for(int i=0;i<adj_list.get(node).size();i++){
                int new_node=adj_list.get(node).get(i);
                stack.push(new_node);
            }
        }
        int Q=Integer.parseInt(br.readLine());
        for(int i=0;i<Q;i++){
            int hi=Integer.parseInt(br.readLine());
            sb.append(min_cost[hi-1]+"\n");
        }
        System.out.print(sb);
        /*System.out.println("--------");
        for(int i=0;i<min_cost.length;i++){
            System.out.print(min_cost[i]+" ");
        }
        System.out.println();*/
    }
    static class kwPair{
        int times,cost;
        kwPair(int times,int cost){this.times=times;this.cost=cost;}
    }
    static void update(int node,int start,int end,int idx,long val){
        if(start==end){
            tree.set(node,val);
            //System.out.println("nv="+node+" "+val);
            return;
        }
        int mid=(start+end)/2;
        if(start<=idx && idx<=mid)
            update(2*node,start,mid,idx,val);
        else update(2*node+1,mid+1,end,idx,val);
        tree.set(node,Math.min(tree.get(2*node),tree.get(2*node+1)));
    }
    static long query(int node,int start,int end,int l,int r){
        if(r<start || end<l)
            return Long.MAX_VALUE;
        if(l<=start && r>=end){
            //System.out.println("get="+node+" "+tree.get(node));
            return tree.get(node);
        }
        int mid=(start+end)/2;
        long m1=query(2*node,start,mid,l,r);
        long m2=query(2*node+1,mid+1,end,l,r);
        //System.out.println("mins="+m1+" "+m2);
        return Math.min(m1,m2);
    }
}
