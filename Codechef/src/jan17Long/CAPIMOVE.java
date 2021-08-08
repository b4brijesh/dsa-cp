package jan17Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 07-01-2017.
 */
public class CAPIMOVE {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] pop=new int[n];
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) pop[j]=Integer.parseInt(st.nextToken());
            ArrayList<Map.Entry<Integer,Integer>> list=new ArrayList<AbstractMap.Entry<Integer, Integer>>();
            for (int j=0;j<n;j++){
                list.add(new AbstractMap.SimpleEntry<Integer, Integer>(pop[j],j+1));
            }
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getKey()-o1.getKey();//descnding
                }
            });
            ArrayList<ArrayList<Integer>> adj_list=new ArrayList<>();
            for (int j=0;j<=n;j++)
                adj_list.add(new ArrayList<>());
            for (int j=0;j<n-1;j++){
                st=new StringTokenizer(br.readLine());
                int v=Integer.parseInt(st.nextToken());
                int u=Integer.parseInt(st.nextToken());
                adj_list.get(v).add(u);
                adj_list.get(u).add(v);
            }
            int[] caps=new int[n+1];
            for (int j=1;j<=n;j++){
                HashSet<Integer> infected=new HashSet<>();
                infected.add(j);
                for (int k=0;k<adj_list.get(j).size();k++)
                    infected.add(adj_list.get(j).get(k));
                boolean max_found=false;
                for (int k=0;k<list.size();k++){
                    int planet=list.get(k).getValue();
                    if (!infected.contains(planet)){
                        max_found=true;
                        caps[j]=planet;
                        break;
                    }
                }
                if (!max_found) caps[j]=0;
            }
            for (int j=1;j<=n;j++)
                System.out.print(caps[j]+" ");
            System.out.println();
        }

        System.exit(0);
    }
}
