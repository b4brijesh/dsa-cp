package contest734;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 11/20/16.
 */
public class D734 {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        int x0=Integer.parseInt(st.nextToken()),
                y0=Integer.parseInt(st.nextToken());
        ArrayList<Map.Entry<Integer,Character>> ulist=new ArrayList<>();
        ArrayList<Map.Entry<Integer,Character>> dlist=new ArrayList<>();
        ArrayList<Map.Entry<Integer,Character>> llist=new ArrayList<>();
        ArrayList<Map.Entry<Integer,Character>> rlist=new ArrayList<>();
        ArrayList<Map.Entry<Integer,Character>> ullist=new ArrayList<>();
        ArrayList<Map.Entry<Integer,Character>> urlist=new ArrayList<>();
        ArrayList<Map.Entry<Integer,Character>> drlist=new ArrayList<>();
        ArrayList<Map.Entry<Integer,Character>> dllist=new ArrayList<>();
        Comparator asct=new Comparator<Map.Entry<Integer, Character>>() {
            @Override
            public int compare(Map.Entry<Integer, Character> e1, Map.Entry<Integer, Character> e2) {
                return e1.getKey() - e2.getKey();
            }
        };
        Comparator dsct=new Comparator<Map.Entry<Integer, Character>>() {
            @Override
            public int compare(Map.Entry<Integer, Character> e1, Map.Entry<Integer, Character> e2) {
                return e2.getKey() - e1.getKey();
            }
        };
        for (int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            char c=st.nextToken().charAt(0);
            int xi=Integer.parseInt(st.nextToken());
            int yi=Integer.parseInt(st.nextToken());
            if (xi==x0){
                if (yi>y0) ulist.add(new AbstractMap.SimpleEntry<>(yi,c));
                else dlist.add(new AbstractMap.SimpleEntry<>(yi,c));
            } else if (yi==y0){
                if (xi>x0) rlist.add(new AbstractMap.SimpleEntry<>(xi,c));
                else llist.add(new AbstractMap.SimpleEntry<>(xi,c));
            } else if (Math.abs(xi-x0)==Math.abs(yi-y0)){
                if (xi<x0){
                    if (yi<y0) dllist.add(new AbstractMap.SimpleEntry<>(xi,c));
                    else ullist.add(new AbstractMap.SimpleEntry<>(xi,c));
                } else {
                    if (yi<y0) drlist.add(new AbstractMap.SimpleEntry<>(xi,c));
                    else urlist.add(new AbstractMap.SimpleEntry<>(xi,c));
                }
            }
        }
        Collections.sort(ulist,asct);
        Collections.sort(dlist,dsct);
        Collections.sort(rlist,asct);
        Collections.sort(llist,dsct);
        Collections.sort(dllist,dsct);
        Collections.sort(ullist,dsct);
        Collections.sort(urlist,asct);
        Collections.sort(drlist,asct);
        //boolean uf,df,lf,rf,ulf,urf,drf,dlf;
        //uf=df=lf=rf=ulf=urf=drf=dlf=false;
        boolean check=false;
        for (int i=0;i<ulist.size();i++){
            char c=ulist.get(i).getValue();
            if (c=='B') break;
            else check=true;
        }
        for (int i=0;i<dlist.size();i++){
            char c=dlist.get(i).getValue();
            if (c=='B') break;
            else check=true;
        }
        for (int i=0;i<llist.size();i++){
            char c=llist.get(i).getValue();
            if (c=='B') break;
            else check=true;
        }
        for (int i=0;i<rlist.size();i++){
            char c=rlist.get(i).getValue();
            if (c=='B') break;
            else check=true;
        }
        for (int i=0;i<dllist.size();i++){
            char c=dllist.get(i).getValue();
            if (c=='R') break;
            else check=true;
        }
        for (int i=0;i<ullist.size();i++){
            char c=ullist.get(i).getValue();
            if (c=='R') break;
            else check=true;
        }
        for (int i=0;i<drlist.size();i++){
            char c=drlist.get(i).getValue();
            if (c=='R') break;
            else check=true;
        }
        for (int i=0;i<urlist.size();i++){
            char c=urlist.get(i).getValue();
            if (c=='R') break;
            else check=true;
        }
        if (check) System.out.println("YES");
        else System.out.println("NO");
    }
}
