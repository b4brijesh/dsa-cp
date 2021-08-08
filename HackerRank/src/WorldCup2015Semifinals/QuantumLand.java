package WorldCup2015Semifinals;

import java.io.*;
import java.util.*;
public class QuantumLand {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] path=new int[n+1];
        int[] prob=new int[n+1];
        int i;
        for(i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            path[i]=Integer.parseInt(st.nextToken());
            prob[i]=Integer.parseInt(st.nextToken());
        }
        boolean[] visited=new boolean[n+1];
        Arrays.fill(visited,false);
        double probability=0.0;
        for(i=1;i<=n;i++){
            if(!visited[i]){
                visited[i]=true;
                Vector<Integer> v=new Vector<Integer>();
                v.add(i);
                while(!visited[path[i]]){
                    i=path[i];
                    visited[i]=true;
                    v.add(i);
                }
                if(v.contains(path[i])){
                    i=path[i];
                    int start=i;
                    int length=1;
                    double probab=prob[i]/100d;
                    while(path[i]!=start){
                        i=path[i];
                        length++;
                        probab=probab*prob[i]/100;
                    }
                    if (length>1)
                        probability=probability+probab;
                }
            }
        }
        System.out.printf("%.2f\n",probability);
    }
}
