package Section1_3;
/*
ID: bsahoon1
LANG: JAVA
TASK: wormhole
*/
import java.io.*;
import java.util.*;
public class wormhole {
    static class Wormhole{int x,y;Wormhole(int x,int y){this.x=x;this.y=y;}}
    static class WPair{Wormhole wh1,wh2;WPair(Wormhole wh1,Wormhole wh2){this.wh1=wh1;this.wh2=wh2;}}
    static Vector<WPair> set;
    static Vector<Wormhole> wvec=new Vector<Wormhole>();
    static int count=0,n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int i,j;
        for(i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            Wormhole wh=new Wormhole(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));//form a wormhole
            wvec.add(wh);//form a vectr of all input wormholes
        }
        set=new Vector<WPair>(n/2);
        dfs(wvec);
        System.out.println(count);
    }
    static void dfs(Vector<Wormhole> vector){
        if (vector.size()==0){
            //set is formed. now process it.
            /*for(WPair wp:set){
                System.out.print("((" + wp.wh1.x + "," + wp.wh1.y + "),(" + wp.wh2.x + "," + wp.wh2.y + ")),");
            }*/
            //System.out.println();
            boolean cycle=checkCycle(set);
            System.out.println(cycle);
            if(cycle){
                count++;
            }
            return;
        }
        Wormhole wh=vector.firstElement();
        vector.remove(wh);
        LinkedList<Wormhole> adjList=new LinkedList<Wormhole>();
        adjList.addAll(vector);
        for(Wormhole x:adjList){
            WPair pair=new WPair(wh,x);
            set.add(pair);
            vector.remove(x);
            dfs(vector);
            vector.add(x);
            set.remove(pair);
        }
        vector.add(wh);
    }
    static boolean checkCycle(Vector<WPair> wpset){
        int numPairs=n/2;
        WPair wp2;
        boolean[] visited=new boolean[numPairs];
        Arrays.fill(visited,false);
        for(WPair wp:wpset){
            while (!visited[wpset.indexOf(wp)]){
                wp2=visit(wpset,wp);
                visited[wpset.indexOf(wp)]=true;
                if(wp2!=null)
                    wp=wp2;
            }
        }
        return false;
    }
    static WPair visit(Vector<WPair> wpset, WPair wp){
        Wormhole wh;
        int i;
        for(i=1;i<=2;i++){
            if(i==1)
                wh=wp.wh1;
            else
                wh=wp.wh2;
            wvec.remove(wh);
            for(Wormhole wh2:wvec){
                if(wh2.y==wh.y && wh2.x>=wh.x){
                    return pairContaining(wh2);
                }
            }
        }
        return null;
    }
    static WPair pairContaining(Wormhole wh){
        for(WPair x:set){
            if(x.wh1==wh || x.wh2==wh)
                return x;
        }
        return null;
    }
}