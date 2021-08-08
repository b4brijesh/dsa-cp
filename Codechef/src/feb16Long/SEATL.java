package feb16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Brijesh on 12-02-2016.
 */
public class SEATL {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Pair>> list=new ArrayList<ArrayList<Pair>>(1000001);
        for(int j=0;j<=1000000;j++){
            //list.add(j,new ArrayList<>());
        }
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
            /*ArrayList<ArrayList<Pair>> list=new ArrayList<ArrayList<Pair>>(1000001);
            for(int j=0;j<=1000000;j++){
                list.add(j,new ArrayList<>());
            }*/
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    list.get(arr[j][k]).add(new Pair(j,k));
                }
            }

            int max=0;

            ArrayList<Integer> nons=new ArrayList<>();
            for(int j=1;j<=1000000;j++){
                if(!list.get(j).isEmpty()){
                    nons.add(j);
                    //System.out.println(j);
                }
            }

            for(int d=0;d<nons.size();d++){
                int j=nons.get(d);
                LinkedHashMap<Integer,Integer> rmap=new LinkedHashMap<>();
                LinkedHashMap<Integer,Integer> cmap=new LinkedHashMap<>();
                ArrayList al=list.get(j);
                //System.out.println(j);
                for(int k=0;k<al.size();k++){
                    rmap.put(Pair.getX((Pair)al.get(k)),(rmap.get(Pair.getX((Pair)al.get(k)))!=null)
                            ?(rmap.get(Pair.getX((Pair)al.get(k)))+1):1);

                    //System.out.println("rmap for row="+Pair.getX((Pair)al.get(k))+" val"+"="+rmap.get(Pair.getX((Pair)al.get(k))));

                    cmap.put(Pair.getY((Pair)al.get(k)),(cmap.get(Pair.getY((Pair)al.get(k)))!=null)
                            ?(cmap.get(Pair.getY((Pair)al.get(k)))+1):1);

                    //System.out.println("cmap for col="+Pair.getY((Pair)al.get(k))+" val"+"="+cmap.get(Pair.getY((Pair)al.get(k))));
                }
                //System.out.println();
                //System.out.println("rmap size="+rmap.size());
                int maxr=0,maxc=0,r=-1,c=-1,l=0,f=0;
                for(int k=0;k<rmap.size();){
                    //System.out.println("l="+l+" rcount="+rmap.get(l));
                    if(rmap.containsKey(l)){
                        if(rmap.get(l)>maxr){
                            maxr=rmap.get(l);
                            r=l;
                        }
                        k++;
                    }
                    l++;
                }
                //System.out.println("cmap size="+cmap.size());
                for(int k=0;k<cmap.size();){
                    //System.out.println("f="+f+" ccount="+cmap.get(f));
                    if(cmap.containsKey(f)){
                        if(cmap.get(f)>maxc){
                            maxc=cmap.get(f);
                            c=f;
                        }
                        k++;
                    }
                    f++;
                }
                int maxx=0;
                if(r>=0 && c>=0)
                    maxx=(arr[r][c]!=j)?(maxr+maxc):(maxr+maxc-1);
                max=Math.max(max,maxx);
                //System.out.println("max after "+j+"="+max);
                list.get(j).clear();
            }
            System.out.println(max);
        }
    }
    private static class Pair{
        int a;
        int b;
        public Pair(int x,int y){
            a=x;
            b=y;
        }
        public static int getX(Pair p){
            return p.a;
        }
        public static int getY(Pair p){
            return p.b;
        }
    }
}
