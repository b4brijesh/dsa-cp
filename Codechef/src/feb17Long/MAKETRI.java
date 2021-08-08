package feb17Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by brijesh on 2/5/17.
 */
public class MAKETRI {
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
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        long l=Long.parseLong(st.nextToken());
        long r=Long.parseLong(st.nextToken());
        long[] a=new long[n];
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++)
            a[i]=Long.parseLong(st.nextToken());
        Arrays.sort(a);
        TreeMap<Long,Boolean> ranges=new TreeMap<>();
        TreeMap<Long,Integer> of=new TreeMap<>();
        TreeMap<Long,Integer> cf=new TreeMap<>();
        long min,max;
        for (int i=1;i<n;i++) {
            min=a[i]-a[i-1]+1;
            max=a[i]+a[i-1]-1;
            if (min<l && max<l) continue;
            if (min>r && max>r) continue;
            if (min<l && max>=l) min=l;
            if (max>r && min<=r) max=r;
            ranges.put(min,true);
            of.put(min, of.containsKey(min) ? of.get(min)+1 : 1);
            ranges.put(max,false);
            cf.put(max, cf.containsKey(max) ? cf.get(max)+1 : 1);
        }
        int cnt=0;
        long total=0;
        long lo=0,hi;
        boolean closed=true;
        for (Long key : ranges.keySet()) {
            //System.out.println(key+" "+ranges.get(key));
            if (of.containsKey(key)) cnt+=of.get(key);
            if (cf.containsKey(key)) cnt-=cf.get(key);
            if (closed) {
                lo=key;
                closed=false;
            }
            if (cnt==0) {
                hi=key;
                total+=(hi-lo+1);
                closed=true;
            }
        }
        System.out.println(total);

        System.exit(0);
    }
}