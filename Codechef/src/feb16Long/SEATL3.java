package feb16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Brijesh on 14-02-2016.
 */
public class SEATL3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int[][] arr=new int[n][m];
            for(int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++)
                    arr[j][k]=Integer.parseInt(st.nextToken());
            }
            HashMap<Integer,ArrayList<Pair>> list=new HashMap<Integer, ArrayList<Pair>>();
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(list.containsKey(arr[j][k]))
                        list.get(arr[j][k]).add(new Pair(j,k));
                    else {
                        ArrayList<Pair> arl=new ArrayList();
                        arl.add(new Pair(j,k));
                        list.put(arr[j][k],arl);
                    }
                }
            }
            int max=0;
            Iterator it =list.keySet().iterator();
            HashMap<Integer,Integer> rowcountmap=new HashMap<>();
            HashMap<Integer,Integer> colcountmap=new HashMap<>();
            HashMap<Integer,Integer> rset=new HashMap<Integer, Integer>();
            HashMap<Integer,Integer> cset=new HashMap<Integer, Integer>();
            for(int d=0;d<list.size();d++){
                int j=(Integer)it.next();
                /*HashMap<Integer,Integer> rowcountmap=new HashMap<>();
                HashMap<Integer,Integer> colcountmap=new HashMap<>();*/
                ArrayList al=list.get(j);
                for(int k=0;k<al.size();k++){
                    rowcountmap.put(Pair.getX((Pair)al.get(k)),(rowcountmap.get(Pair.getX((Pair)al.get(k)))!=null)
                            ?(rowcountmap.get(Pair.getX((Pair)al.get(k)))+1):1);
                    colcountmap.put(Pair.getY((Pair)al.get(k)),(colcountmap.get(Pair.getY((Pair)al.get(k)))!=null)
                            ?(colcountmap.get(Pair.getY((Pair)al.get(k)))+1):1);
                }
                ArrayList li1=new ArrayList<>(rowcountmap.entrySet());

                Iterator it1=li1.iterator();
                int rmax=-1;
                while (it1.hasNext()){
                    Map.Entry<Integer,Integer> e=(Map.Entry<Integer, Integer>) it1.next();
                    if(e.getValue()>rmax)
                        rmax=e.getValue();
                }
                Iterator it2=li1.iterator();
                while (it2.hasNext()){
                    Map.Entry<Integer,Integer> e=(Map.Entry<Integer, Integer>) it2.next();
                    if(e.getValue()==rmax)
                        rset.put(e.getKey(),e.getValue());
                }
                ArrayList li2=new ArrayList<>(colcountmap.entrySet());

                Iterator it3=li2.iterator();
                int cmax=-1;
                while (it3.hasNext()){
                    Map.Entry<Integer,Integer> e=(Map.Entry<Integer, Integer>) it3.next();
                    if(e.getValue()>cmax)
                        cmax=e.getValue();
                }
                Iterator it4=li2.iterator();
                while (it4.hasNext()){
                    Map.Entry<Integer,Integer> e=(Map.Entry<Integer, Integer>) it4.next();
                    if(e.getValue()==cmax)
                        cset.put(e.getKey(),e.getValue());
                }
                int nummax=0;
                ArrayList li3=new ArrayList(rset.entrySet());
                ArrayList li4=new ArrayList(cset.entrySet());
                Iterator it5=li3.iterator();
                outer:while(it5.hasNext()){
                    Map.Entry<Integer,Integer> rowe=(Map.Entry<Integer, Integer>) it5.next();
                    Iterator it6=li4.iterator();
                    while (it6.hasNext()){
                        Map.Entry<Integer,Integer> cole=(Map.Entry<Integer, Integer>) it6.next();
                        if(j==arr[rowe.getKey()][cole.getKey()]){
                            nummax=rowe.getValue()+cole.getValue()-1;
                        }
                        else{
                            nummax=rowe.getValue()+cole.getValue();
                            break outer;
                        }
                    }
                }
                max=Math.max(max,nummax);
                rowcountmap.clear();
                colcountmap.clear();
                rset.clear();
                cset.clear();
            }
            System.out.println(max);
        }
    }
    private static class Pair{
        int a;int b;
        public Pair(int x,int y){a=x;b=y;}
        public static int getX(Pair p){
            return p.a;
        }
        public static int getY(Pair p){
            return p.b;
        }
    }
}
