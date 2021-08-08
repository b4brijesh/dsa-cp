package aug16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Brijesh on 15-08-2016.
 */
public class SHAIKHGN {
    static int n;
    static int[][] g;
    static int[][] fv_time;
    static boolean[] visited;
    static Map<Integer,TreeSet<Integer>> cycle_times;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());
        g=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                g[i][j]=Integer.parseInt(st.nextToken());
        }
        fv_time=new int[n][n];
        visited=new boolean[n];
        cycle_times=new HashMap<>();
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++)
                fv_time[i][j]=Integer.MAX_VALUE;
            visited[i]=false;
            cycle_times.put(i,new TreeSet<>());
        }
        for(int i=0;i<n;i++){
            Arrays.fill(visited,false);
            if(!visited[i]){
                visited[i]=true;
                fv_time[i][i]=0;
                ArrayList<Integer> stack=new ArrayList<>();
                stack.add(i);
                dfs(i,stack,0);
                stack.remove(stack.size()-1);
                //System.out.println(stack.size());
                //System.out.println(last_visited.size());
            }
        }

        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++)
                if(fv_time[i][j]==Integer.MAX_VALUE)
                    fv_time[i][j]=-1;
        }

        /*for(int i=0;i<n;i++){
            System.out.print((i+1)+": ");
            for (int j=0;j<n;j++){
                System.out.print(fv_time[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Cycles");
        for(int i=0;i<n;i++){
            TreeSet arl=cycle_times.get(i);
            System.out.print((i+1)+": ");
            Iterator it=arl.iterator();
            while (it.hasNext())
                System.out.print(it.next()+" ");
            System.out.println();
        }*/

        int m=Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int k=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            TreeSet<Integer> ids=new TreeSet<>();
            for(int j=0;j<n;j++){
                if(fv_time[x-1][j]>k || fv_time[x-1][j]<0)
                    continue;
                int r=k-fv_time[x-1][j];
                if(r==0){
                    ids.add(j);
                    continue;
                }
                //System.out.println("r:"+r+" "+k+" "+fv_time[x-1][j]);
                TreeSet<Integer> ts=cycle_times.get(j);
                Iterator<Integer> it=ts.iterator();
                while (it.hasNext()){
                    int cy_len=it.next();
                    //System.out.println("cylen:"+cy_len);
                    if(r%cy_len==0){
                        ids.add(j);
                        break;
                    }
                }
            }
            //System.out.println("Query:"+(i+1));
            if(ids.size()==0){
                System.out.println(0);
                System.out.println(-1);
            }
            else{
                System.out.println(ids.size());
                Iterator<Integer> it=ids.iterator();
                int j=0;
                while (it.hasNext()){
                    if(j==0){
                        System.out.print((it.next()+1));
                        j++;
                    }else System.out.print(" "+(it.next()+1));
                }
                System.out.println();
            }
        }
    }
    static void dfs(int vertex,ArrayList<Integer> stack,int curr_time){
        for(int j=0;j<n;j++){
            if(g[vertex][j]==1){
                if(!visited[j]){
                    visited[j]=true;
                    stack.add(j);
                    int new_time=curr_time+1;
                    for(int i=0;i<stack.size();i++,new_time--){
                        if(fv_time[stack.get(i)][j]>new_time)
                            fv_time[stack.get(i)][j]=new_time;
                    }
                    dfs(j,stack,curr_time+1);
                    stack.remove(stack.size()-1);
                }else{
                    boolean found=false;
                    int index=-1;
                    for(int i=stack.size()-1;i>=0;i--){
                        if(stack.get(i)==j){
                            found=true;
                            index=i;
                        }
                    }
                    if(found){
                        int cycle_len=stack.size()-index;
                        for(int i=stack.size()-1;i>index;i--){
                            int c=cycle_len-1;
                            for(int k=i-1;k>=index;k--){
                                if(fv_time[stack.get(i)][stack.get(k)]>c)
                                    fv_time[stack.get(i)][stack.get(k)]=c--;
                            }
                            cycle_times.get(stack.get(i)).add(cycle_len);
                        }
                        cycle_times.get(stack.get(index)).add(cycle_len);
                    }else{
                        int new_time=curr_time+1;
                        for(int i=0;i<stack.size();i++,new_time--){
                            if(fv_time[stack.get(i)][j]>new_time)
                                fv_time[stack.get(i)][j]=new_time;
                        }
                        for(int k=0;k<n;k++){
                            if(fv_time[j][k]!=Integer.MAX_VALUE){
                                new_time=curr_time+1;
                                for(int i=0;i<stack.size();i++,new_time--){
                                    if(fv_time[stack.get(i)][k]>(new_time+fv_time[j][k]))
                                        fv_time[stack.get(i)][k]=new_time+fv_time[j][k];
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
