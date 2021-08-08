package classical;

import java.io.*;
import java.util.*;
public class PT07Y {
    static Vector<Vector<Integer>> adjVec=new Vector<Vector<Integer>>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n,m;
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        int i,j,a,b;
        for(i=0;i<=n;i++)
            adjVec.addElement(new Vector<Integer>());
        for(i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            adjVec.elementAt(a).addElement(b);
            adjVec.elementAt(b).addElement(a);
        }
        /*for(i=1;i<=n;i++){
            //System.out.println(adjVec.elementAt(i).size());
            for(j=0;j<adjVec.elementAt(i).size();j++)
                System.out.print(adjVec.elementAt(i).elementAt(j)+" ");
            System.out.println();
        }*/
        if(m==n-1){
            visited=new boolean[n+1];
            Arrays.fill(visited,false);
            dfs(1);
            for(i=1;i<=n;i++) {
                if (!visited[i]) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
    static void dfs(int a){
        int i;
        visited[a]=true;
        for(i=0;i<adjVec.elementAt(a).size();i++){
            if(!visited[(int)adjVec.elementAt(a).elementAt(i)])
                dfs((int)adjVec.elementAt(a).elementAt(i));
        }
    }
}
