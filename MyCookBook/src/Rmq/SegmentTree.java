package rmq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 08-06-2017.
 */

//copied from CodeChef DIVMAC
public class SegmentTree {
    static long p;
    static HashMap<Long,long[]> map,map2;
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int q=Integer.parseInt(st.nextToken());
            p=Long.parseLong(st.nextToken());
            a=new int[n];
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++)
                a[j]=Integer.parseInt(st.nextToken());

            map=new HashMap<>();
            //if (p>1000000){
            for (int l=0;l<=250;l++) for (int j=0;j<=250;j++) for (int k=0;k<=250;k++){
                long sum=((l*l)+(j*j)+(k*k))%p;
                if (!map.containsKey(sum)){
                    long[] arr={l,j,k};
                    map.put(sum,arr);
                }
            }
            //}
            map2=new HashMap<>();

            tree=new ArrayList<>();
            for (int j=0;j<5*n;j++)
                tree.add(j,0L);
            build_segtree(1,0,n-1);
            for (int j=0;j<q;j++){
                st=new StringTokenizer(br.readLine());
                int type=Integer.parseInt(st.nextToken());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                if (type==1){
                    update(1,0,n-1,x-1,y);
                    //System.out.println(a[0]);
                } else {
                    long res=query(1,0,n-1,x-1,y-1)%p;
                    f4squares(res);
                }
            }
        }

        System.exit(0);
    }
    static ArrayList<Long> tree;
    static int[] a;
    static void build_segtree(int node,int start,int end){
        if(start==end){
            tree.set(node,(long)a[start]);
        }
        else {
            int mid=(start+end)/2;
            build_segtree(2*node,start,mid);
            build_segtree(2*node+1,mid+1,end);
            tree.set(node,(tree.get(2*node)*tree.get(2*node+1))%p);
        }
    }
    static void update(int node,int start,int end,int idx,int val){
        if(start==end){
            a[idx]=val;
            tree.set(node,(long)val);
            return;
        }
        int mid=(start+end)/2;
        if(start <= idx && idx <= mid)
            update(2*node,start,mid,idx,val);
        else update(2*node+1,mid+1,end,idx,val);
        tree.set(node,(tree.get(2*node)*tree.get(2*node+1))%p);
    }
    static long query(int node,int start,int end,int l,int r){
        if(r<start || end<l)
            return 1;
        if(l<=start && r>=end)
            return tree.get(node);
        int mid=(start+end)/2;
        long m1=query(2*node,start,mid,l,r);
        long m2=query(2*node+1,mid+1,end,l,r);
        return (m1*m2)%p;
    }
    static void f4squares(long n){
        //System.out.println(n);
        n=n%p;
        if (map2.containsKey(n)) {
            long[] arr=map2.get(n);
            System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
            return;
        }
        if (map.containsKey(n)) {
            long[] arr=map.get(n);
            System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+0);
            return;
        }
        long t1, t2, t;
        for (long i = (long) Math.sqrt(n/4); i <=(long) Math.sqrt(n); i++) {
            t1 = n - i * i;
            if (t1<100000 && !map.containsKey(t1)) continue;
            /*if (p>1000000 && map.containsKey(t1)) {
                long[] arr=map.get(t1);
                System.out.println(i+" "+arr[0]+" "+arr[1]+" "+arr[2]);
                return;
            }*/
            if (map.containsKey(t1)){
                long[] arr=map.get(t1);
                System.out.println(i+" "+arr[0]+" "+arr[1]+" "+arr[2]);
                long[] arr2={i,arr[0],arr[1],arr[2]};
                map2.put(n,arr2);
                return;
            }
            for (long j = (long) Math.sqrt(t1 / 3); j <= i && j * j <= t1; j++) {
                t2 = t1 - j * j;
                for (long k = (long) Math.sqrt(t2 / 2); k <= j && k * k <= t2; k++) {
                    t = (long) Math.sqrt(t2 - k * k);
                    if (t <= k && t * t == t2 - k * k) {
                        System.out.println(i+" "+j+" "+k+" "+t);
                        long[] arr={j,k,t};
                        long[] arr2={i,j,k,t};
                        map.put(t1,arr);
                        map2.put(n,arr2);
                        return;
                    }
                }
            }
        }
    }
}
