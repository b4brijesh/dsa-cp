package feb17Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 2/13/17.
 */
public class INTERVAL2 {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static long INF=1000000000000000L;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++) {
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            long[] a=new long[n];
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) a[j]=Integer.parseInt(st.nextToken());
            int[] b=new int[m];
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) b[j]=Integer.parseInt(st.nextToken());
            long[] cum=new long[n];
            cum[0]=a[0];
            for (int j=1;j<n;j++) cum[j]=cum[j-1]+a[j];
            long[] rangeSum=new long[n];
            int x=m-1;
            int len=b[x];
            for (int j=0;j<n;j++) {
                int l=j+len-1;
                if (l>=n) break;
                if (j==0) rangeSum[j]=cum[l];
                else rangeSum[j]=cum[l]-cum[j-1];
            }
            if (m==1) {
                long max=0;
                for (int j=0;j<n;j++) {
                    max=Math.max(max,rangeSum[j]);
                }
                System.out.println(max);
            } else {
                if (x%2!=0) {
                    for (int j=0;j<n;j++)
                        rangeSum[j]=-rangeSum[j];
                }
                long[] nSum=new long[n];
                while (--x>=0) {
                    len=b[x];
                    Deque<Integer> deque=new ArrayDeque<>();
                    int idx=0;
                    long sum;
                    for (int j=0;j<n;j++) {
                        int l=j+len-1;
                        if (l>=n) break;
                        if (x%2==0) {
                            if (j==0) sum=cum[l];
                            else sum=cum[l]-cum[j-1];
                        } else {
                            if (j==0) sum=-cum[l];
                            else sum=-(cum[l]-cum[j-1]);
                        }
                        if (j==0) {
                            for (int k=1;k<n;k++) {
                                int lt=k+b[x+1]-1;
                                if (lt>=l) break;
                                idx++;
                                if (x%2==0) {
                                    while (!deque.isEmpty() &&
                                            rangeSum[k]<rangeSum[deque.getLast()])
                                    deque.removeLast();
                                } else {
                                    while (!deque.isEmpty() &&
                                            rangeSum[k]>rangeSum[deque.getLast()])
                                        deque.removeLast();
                                }
                                deque.addLast(k);
                            }
                            nSum[j]=sum+rangeSum[deque.getFirst()];
                        } else {
                            while (!deque.isEmpty() && deque.getFirst()<=j)
                                deque.removeFirst();
                            idx++;
                            if (x%2==0) {
                                while (!deque.isEmpty() &&
                                        rangeSum[idx]<rangeSum[deque.getLast()])
                                    deque.removeLast();
                            } else {
                                while (!deque.isEmpty() &&
                                        rangeSum[idx]>rangeSum[deque.getLast()])
                                    deque.removeLast();
                            }
                            deque.addLast(idx);
                            nSum[j]=sum+rangeSum[deque.getFirst()];
                        }
                    }
                    System.arraycopy(nSum,0,rangeSum,0,n);
                    Arrays.fill(nSum,0);
                }
                long mas=Long.MIN_VALUE;
                for (int j=0;j<n;j++)
                    mas=Math.max(mas,rangeSum[j]);
                System.out.println(mas);
            }
        }
        System.exit(0);
    }
}
