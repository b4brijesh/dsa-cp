package contest764;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 2/2/17.
 */
public class C764 {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static long INF=1000000000000000L;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        int m=n-1;
        Edge[] edges=new Edge[m];
        for (int i=0;i<m;i++) {
            edges[i]=new Edge();
            st=new StringTokenizer(br.readLine());
            edges[i].x=Integer.parseInt(st.nextToken());
            edges[i].y=Integer.parseInt(st.nextToken());
        }
        int[] col=new int[n+1];
        st=new StringTokenizer(br.readLine());
        for (int i=1;i<=n;i++)
            col[i]=Integer.parseInt(st.nextToken());
        HashSet<Integer> set=new HashSet<>();
        boolean psbl=true;
        int cnt=0;
        for (int i=0;i<m;i++) {
            int c1=col[edges[i].x],c2=col[edges[i].y];
            if (c1!=c2) {
                if (cnt==0) {
                    set.add(edges[i].x);
                    set.add(edges[i].y);
                    cnt++;
                } else {
                    cnt++;
                    //System.out.print(edges[i].x+" "+edges[i].y);
                    if (set.contains(edges[i].x)) {
                        set.clear();
                        set.add(edges[i].x);
                    }
                    else if (set.contains(edges[i].y)) {
                        set.clear();
                        set.add(edges[i].y);
                    }
                    else {
                        psbl=false;
                        break;
                    }
                }
            }
        }
        if (psbl) {
            System.out.println("YES");
            if (set.size()==0) System.out.println(1);
            else {
                Iterator<Integer> it=set.iterator();
                System.out.println(it.next());
                //System.out.println(it.next());
            }
        } else System.out.println("NO");

        System.exit(0);
    }
}
class Edge{int x,y;}
