package a_and_d_of_algos;

import java.io.*;
import java.util.*;
public class KargerMinCut {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("C://kargerMinCut.txt"));
        Vector<Vector<Integer>> adj=new Vector<Vector<Integer>>(201);
        int i,j,k,l;
        StringTokenizer st;
        Vector<Integer> v=new Vector<Integer>();
        adj.add(v);
        for(i=1;i<=200;i++){
            st=new StringTokenizer(br.readLine());
            st.nextToken();
            v=new Vector<Integer>();
            while(st.hasMoreTokens()){
                k=Integer.parseInt(st.nextToken());
                if(k!=i)
                    v.add(k);
            }
            adj.add(v);
            /*for(j=0;j<v.size();j++)
                System.out.print(v.elementAt(j)+" ");
            System.out.println();*/
        }
        int min=99,prevmin=99,count=0;
        for(i=1;i<=212000;i++){
            Vector<Vector<Integer>> clone=new Vector<Vector<Integer>>(201);
            for(j=0;j<adj.size();j++){
                v=new Vector<Integer>();
                for(k=0;k<adj.elementAt(j).size();k++){
                    l=adj.elementAt(j).elementAt(k);
                    v.add(l);
                }
                clone.add(v);
            }
            int m=200,v1,v2;
            while(m>2){
                //System.out.println("Vertices remaining="+(clone.size()-1));
                v1=(int)(1+Math.random()*(clone.size()-2));//find a random vertex
                v2=clone.elementAt(v1).elementAt((int)(Math.random()*(clone.elementAt(v1).size()-1)));
                //System.out.println("Vetices chosen="+v1+" "+v2+" m="+m+" n="+(200-m));
                contract(clone, v1, v2);
                m--;
            }
            System.out.println("cuts["+i+"]="+clone.elementAt(1).size());
            min=Math.min(min,clone.elementAt(1).size());
            if(clone.elementAt(1).size()==prevmin)
                count++;
            prevmin=min;
        }
        System.out.println("min cut="+min+" freq="+count);
    }
    static void contract(Vector<Vector<Integer>> adj,int v1,int v2){
        int v3=Math.min(v1,v2);
        v2=Math.max(v1,v2);
        v1=v3;
        Vector<Integer> vec1=adj.elementAt(v1);
        Vector<Integer> vec2=adj.elementAt(v2);
        Vector<Integer> v=new Vector<Integer>();
        v.add(v2);
        vec1.removeAll(v);
        v.removeElement(v2);
        v.add(v1);
        vec2.removeAll(v);
        vec1.addAll(vec2);

        int i,j;
        for(i=1;i<adj.size();i++){
            for(j=0;j<adj.elementAt(i).size();j++){
                if(adj.elementAt(i).elementAt(j)==v2)
                    adj.elementAt(i).set(j,v1);
                if(adj.elementAt(i).elementAt(j)>v2)
                    adj.elementAt(i).set(j,adj.elementAt(i).elementAt(j)-1);
            }
        }
        adj.removeElementAt(v2);
        //adj.set(v2,new Vector<Integer>());
    }
}
