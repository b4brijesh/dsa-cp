package contest765;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 14-02-2017.
 */
public class D765 {
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
        int[] f=new int[n+1];
        st=new StringTokenizer(br.readLine());
        ArrayList<ArrayList<Integer>> arrayList=new ArrayList<>();
        for (int i=0;i<=n;i++)
            arrayList.add(new ArrayList<>());
        for (int i=1;i<=n;i++) {
            f[i]=Integer.parseInt(st.nextToken());
            arrayList.get(f[i]).add(i);
        }
        boolean ptd=false;
        for (int i=1;i<=n;i++) {
            if (arrayList.get(i).size()!=0) {
                boolean found=false;
                for (int j=0;j<arrayList.get(i).size();j++) {
                    if (arrayList.get(i).get(j)==i) {
                        found=true;
                        break;
                    }
                }
                if(!found) {
                    ptd=true;
                    System.out.println(-1);
                    return;
                }
            }
        }
        int m=0;
        for (int i=1;i<=n;i++) {
            if (arrayList.get(i).size()!=0) m++;
        }
        int[] g=new int[n+1];
        int[] h=new int[m+1];
        int k=1;
        for (int i=1;i<=n;i++) {
            if (arrayList.get(i).size()!=0) {
                h[k]=i;
                k++;
            }
        }
        k=1;
        for (int i=1;i<=n;i++) {
            if (arrayList.get(i).size()!=0) {
                for (int j=0;j<arrayList.get(i).size();j++) {
                    g[arrayList.get(i).get(j)]=k;
                }
                k++;
            }
        }
        System.out.println(m);
        for (int i=1;i<=n;i++)
            System.out.print(g[i]+" ");
        System.out.println();
        for (int i=1;i<=m;i++)
            System.out.print(h[i]+" ");
        System.out.println();

        System.exit(0);
    }
}
