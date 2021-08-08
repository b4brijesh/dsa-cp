package apac17C;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 9/29/16.
 */
public class C {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-small-practice.in"));
        BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-large-practice.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            int n=Integer.parseInt(br.readLine());
            required_list=new TreeMap<>();
            visited=new boolean[n];
            evaluated=new boolean[n];
            Arrays.fill(visited,false);
            Arrays.fill(evaluated,false);
            vars=new String[n];
            mapped_str=new HashMap<>();
            for(int j=0;j<n;j++){
                String line=br.readLine().trim();
                int idx_of_eq=line.indexOf('=');
                int idx_of_ob=line.indexOf('(');
                //int idx_of_cb=line.indexOf(')');
                String var=line.substring(0,idx_of_eq);
                String[] var_names=line.substring(idx_of_ob+1,line.length()-1).split(",");
                vars[j]=var;
                mapped_str.put(var,j);
                if(var_names.length==1 && var_names[0].isEmpty())
                    required_list.put(var,EMPTY_ARRAY);
                else required_list.put(var,var_names);
            }
            boolean good=true;
            for(int j=0;j<n;j++){
                if(!visited[j]){
                    good=dfs(j);
                    if (!good) break;
                }
            }
            if (good)
                System.out.println("Case #"+(i)+": "+"GOOD");
            else System.out.println("Case #"+(i)+": "+"BAD");
        }
    }
    private static TreeMap<String,String[]> required_list;
    private static boolean[] visited,evaluated;
    private static String[] vars;
    private static HashMap<String,Integer> mapped_str;
    private static boolean dfs(int idx){
        visited[idx]=true;
        boolean dum=true;
        for(int i=0;i<required_list.get(vars[idx]).length;i++){
            String req=required_list.get(vars[idx])[i];
            if(!required_list.containsKey(req)) return false;
            int mapped_int=mapped_str.get(req);
            if(visited[mapped_int] && !evaluated[mapped_int]) return false;
            if(!visited[mapped_int])
                dum=dfs(mapped_int);
            if(!dum) return false;
        }
        evaluated[idx]=true;
        return true;
    }
}
