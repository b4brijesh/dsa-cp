package a_and_d_of_algos;

import java.io.*;
import java.util.*;

public class SCC {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Documents/SCC.txt"));
        StringTokenizer st;
        Vector<Vector<Integer>> graph=new Vector<Vector<Integer>>();
        Vector<Vector<Integer>> ginv=new Vector<Vector<Integer>>();
        Vector<Integer> v;
        int i,j;
        for(i=0;i<=875714;i++){
            v=new Vector<Integer>();
            graph.add(v);
            v=new Vector<>();
            ginv.add(v);
        }
        String s;
        while((s=br.readLine())!=null){
            st=new StringTokenizer(s);
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            //System.out.println("edge="+v1+" "+v2);
            graph.elementAt(v1).add(v2);
            ginv.elementAt(v2).add(v1);
        }
        /*for(i=0;i<=9;i++){
            for(j=0;j<ginv.elementAt(i).size();j++){
                System.out.print(i+"="+ginv.elementAt(i).elementAt(j)+" ");
            }
            System.out.println();
        }*/
        dfsloop(ginv,1);
        dfsloop(graph,2);
    }
    static boolean[] explored=new boolean[875715];
    static Stack<Integer> stack=new Stack<Integer>();
    static int count;
    static int t=0;
    static void dfsloop(Vector<Vector<Integer>> g,int pass){
        System.out.println(pass+"=pass");
        int i;
        Arrays.fill(explored,false);
        if(pass==1){
            for(i=875714;i>=1;i--){
                //System.out.println("dfsloop i="+i);
                if(!explored[i]){
                    //System.out.println("pass="+pass+"i="+i);
                    dfs(g,i,pass);
                }
            }
        }
        if(pass==2){
            Vector<Integer> v=new Vector<>();
            while(!stack.isEmpty()){
                int j=stack.pop();
                if(!explored[j]){
                    count=1;
                    dfs(g,j,2);
                    //System.out.println("j="+j+"pass="+pass+"c="+count);
                    v.add(count);
                }
            }
            Collections.sort(v);
            System.out.println(v.elementAt(v.size()-1)+" "+v.elementAt(v.size()-2)+" "+v.elementAt(v.size()-3)+" "+v.elementAt(v.size()-4)+" "+v.elementAt(v.size()-5)+" ");
        }
    }
    static void dfs(Vector<Vector<Integer>> g,int i,int pass){
        Stack<Integer> stk=new Stack<>();
        stk.push(i);
        Vector<Integer> v=new Vector<Integer>();
        explored[i]=true;
        int j,k;
        while(!stk.empty()){
            j=stk.pop();
            if(pass==1){
                //System.out.println("p="+j);
                v.add(j);
            }
            for(k=0;k<g.elementAt(j).size();k++){
                if(!explored[g.elementAt(j).elementAt(k)]){
                    explored[g.elementAt(j).elementAt(k)]=true;
                    if(pass==2){
                        //System.out.println(g.elementAt(j).elementAt(k));
                        count++;
                    }
                    stk.push(g.elementAt(j).elementAt(k));
                }
            }
        }
        if(pass==1){
            for(j=v.size()-1;j>=0;j--){
                //System.out.println("push="+v.elementAt(j));
                stack.push(v.elementAt(j));
            }
        }
    }
}
