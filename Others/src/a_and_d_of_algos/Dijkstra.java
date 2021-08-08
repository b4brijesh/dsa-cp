package a_and_d_of_algos;

import java.util.*;
import java.io.*;

public class Dijkstra {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("E://Downloads/dijkstraData.txt"));
        StringTokenizer st;
        Vector<Vector<Integer>> adj=new Vector<Vector<Integer>>();
        Vector<Integer> v1=new Vector<>();
        Vector<Vector<Integer>> weights=new Vector<>();
        Vector<Integer> v2=new Vector<>();
        adj.add(v1);
        weights.add(v2);
        int i,j,k;
        for(i=1;i<=200;i++){
            st=new StringTokenizer(br.readLine(),"\t,");
            st.nextToken();
            v1=new Vector<>();
            v2=new Vector<>();
            while(st.hasMoreTokens()){
                j=Integer.parseInt(st.nextToken());
                v1.add(j);
                k=Integer.parseInt(st.nextToken());
                v2.add(k);
            }
            adj.add(v1);
            weights.add(v2);
        }
        /*for(i=0;i<adj.size();i++){
            for(j=0;j<adj.elementAt(i).size();j++){
                System.out.print(adj.elementAt(i).elementAt(j)+",");
                System.out.print(weights.elementAt(i).elementAt(j)+" ");
            }
            System.out.println();
        }*/
        Vector<Integer> x=new Vector<>();
        int[] lens=new int[201];
        Arrays.fill(lens,1000000);
        x.add(1);
        lens[1]=0;
        int min,minver;
        while(x.size()!=200){
            min=1000001;
            minver=201;
            for(int v:x){
                for(int w:adj.elementAt(v)){
                    if(!x.contains(w)){
                        if(lens[v]+weights.elementAt(v).elementAt(adj.elementAt(v).indexOf(w))<min){
                            min=Math.min(min,lens[v]+weights.elementAt(v).elementAt(adj.elementAt(v).indexOf(w)));
                            minver=w;
                            System.out.println("e"+v+" "+w);
                        }
                    }
                }
            }
            //System.out.println(min+" "+minver);
            if(minver<201){
                lens[minver]=min;
                x.add(minver);
            }
        }
        System.out.println(lens[7]+","+lens[37]+","+lens[59]+","+lens[82]+","+lens[99]
                +","+lens[115]+","+lens[133]+","+lens[165]+","+lens[188]+","+lens[197]);//7,37,59,82,99,115,133,165,188,197
    }
}
