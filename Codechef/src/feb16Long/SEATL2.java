package feb16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Brijesh on 14-02-2016.
 */
public class SEATL2 {
    public static void main(String[] args) throws Exception {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            /*ArrayList<int[]> arr=new ArrayList<int[]>();
            for(int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                int[] row=new int[m];
                for(int k=0;k<m;k++){
                    row[k]=Integer.parseInt(st.nextToken());
                }
                arr.add(row);
            }*/
            /*HashMap<Integer,ArrayList<Pair>> list=new HashMap<Integer, ArrayList<Pair>>();
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
            Iterator iter =list.keySet().iterator();
            for(int d=0;d<list.size();d++){
                int j=(Integer)iter.next();
                HashMap<Integer,Integer> rowcountmap=new HashMap<>();
                HashMap<Integer,Integer> colcountmap=new HashMap<>();
                ArrayList al=list.get(j);
                for(int k=0;k<al.size();k++){
                    rowcountmap.put(Pair.getX((Pair)al.get(k)),(rowcountmap.get(Pair.getX((Pair)al.get(k)))!=null)
                            ?(rowcountmap.get(Pair.getX((Pair)al.get(k)))+1):1);
                    colcountmap.put(Pair.getY((Pair)al.get(k)),(colcountmap.get(Pair.getY((Pair)al.get(k)))!=null)
                            ?(colcountmap.get(Pair.getY((Pair)al.get(k)))+1):1);
                }
                List li1=new ArrayList<>(rowcountmap.entrySet());
                Collections.sort(li1, new Comparator<HashMap.Entry<Integer,Integer>>() {
                    public int compare(HashMap.Entry<Integer,Integer> o1,HashMap.Entry<Integer,Integer> o2){
                        return o1.getValue().compareTo(o2.getValue());
                    }
                });
                HashMap<Integer,Integer> rset=new HashMap<Integer, Integer>();
                ListIterator it1=li1.listIterator(li1.size());
                int rmax=-1,count1=0;
                while (it1.hasPrevious()){
                    Map.Entry<Integer,Integer> e=(Map.Entry<Integer, Integer>) it1.previous();
                    if(count1==0)
                        rmax=e.getValue();
                    if(e.getValue()==rmax){
                        rset.put(e.getKey(),e.getValue());
                    }
                    count1++;
                }
                ArrayList li2=new ArrayList<>(colcountmap.entrySet());
                Collections.sort(li2, new Comparator<HashMap.Entry<Integer,Integer>>() {
                    public int compare(HashMap.Entry<Integer,Integer> o1,HashMap.Entry<Integer,Integer> o2){
                        return o1.getValue().compareTo(o2.getValue());
                    }
                });
                HashMap<Integer,Integer> cset=new HashMap<Integer, Integer>();
                ListIterator it2=li2.listIterator(li2.size());
                int cmax=-1,count2=0;
                while (it2.hasPrevious()){
                    Map.Entry<Integer,Integer> e=(Map.Entry<Integer, Integer>) it2.previous();
                    if(count2==0)
                        cmax=e.getValue();
                    if(e.getValue()==cmax){
                        cset.put(e.getKey(),e.getValue());
                    }
                    count2++;
                }
                int nummax=0;
                ArrayList li3=new ArrayList(rset.entrySet());
                ArrayList li4=new ArrayList(cset.entrySet());
                Iterator it3=li3.iterator();
                outer:while(it3.hasNext()){
                    Map.Entry<Integer,Integer> rowe=(Map.Entry<Integer, Integer>) it3.next();
                    Iterator it4=li4.iterator();
                    while (it4.hasNext()){
                        Map.Entry<Integer,Integer> cole=(Map.Entry<Integer, Integer>) it4.next();
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
        }*/
    }
}