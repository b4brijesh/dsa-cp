package feb17Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 2/13/17.
 */
public class INTERVAL {
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
            //System.out.println(Arrays.toString(cum));
            long[] rangeSum=new long[n];
            if (m==1) {
                int len=b[0];
                for (int j=0;j<n;j++) {
                    int l=j+len-1;
                    if (l>=n) break;
                    if (j==0) rangeSum[j]=cum[l];
                    else rangeSum[j]=cum[l]-cum[j-1];
                }
                long max=0;
                for (int j=0;j<n;j++) {
                    max=Math.max(max,rangeSum[j]);
                }
                System.out.println(max);
            } else {
                int len=b[m-1];
                for (int j=0;j<n;j++) {
                    int l=j+len-1;
                    if (l>=n) break;
                    if (j==0) rangeSum[j]=cum[l];
                    else rangeSum[j]=cum[l]-cum[j-1];
                }
                if ((m-1)%2!=0) {
                    for (int j=0;j<n;j++)
                        rangeSum[j]=-rangeSum[j];
                }
                //System.out.println(m-1+" "+ Arrays.toString(rangeSum));
                long[] nSum=new long[n];
                int x=m-2;
                while (x>=0) {
                    if (x%2==0) {
                        len=b[x];
                        //long max=Long.MIN_VALUE,secMax=Long.MIN_VALUE;
                        long min=Long.MAX_VALUE,secMin=Long.MAX_VALUE;
                        int idx=0;
                        for (int j=0;j<n;j++) {
                            int l=j+len-1;
                            if (l>=n) break;
                            long sum;
                            if (j==0) sum=cum[l];
                            else sum=cum[l]-cum[j-1];
                            if (j==0) {
                                for (int k=1;k<n;k++) {
                                    int lt=k+b[x+1]-1;
                                    if (lt>=l) break;
                                    idx++;
                                    /*if (max!=Long.MIN_VALUE) {
                                        if (rangeSum[k]>=max) {
                                            secMax=max;
                                            max=rangeSum[k];
                                        } else if (rangeSum[k]>secMax)
                                            secMax=rangeSum[k];
                                    } else {
                                        if (rangeSum[k]>=max)
                                            max=rangeSum[k];
                                    }*/
                                    if (min!=Long.MAX_VALUE) {
                                        if (rangeSum[k]<=min) {
                                            secMin=min;
                                            min=rangeSum[k];
                                        } else if (rangeSum[k]<secMin)
                                            secMin=rangeSum[k];
                                    } else {
                                        if (rangeSum[k]<=min)
                                            min=rangeSum[k];
                                    }
                                }
                                //nSum[j]=sum+max;
                                nSum[j]=sum+min;
                            } else {
                                /*if (max==rangeSum[j]) {
                                    if (secMax!=Long.MIN_VALUE) {
                                        max=secMax;
                                        secMax=Long.MIN_VALUE;
                                    } else max=Long.MIN_VALUE;
                                }
                                idx++;
                                if (rangeSum[idx]>=max) {
                                    secMax=max;
                                    max=rangeSum[idx];
                                } else if (rangeSum[idx]>secMax)
                                    secMax=rangeSum[idx];
                                nSum[j]=sum+max;*/
                                if (min==rangeSum[j]) {
                                    if (secMin!=Long.MAX_VALUE) {
                                        min=secMin;
                                        secMin=Long.MAX_VALUE;
                                    } else min=Long.MAX_VALUE;
                                }
                                idx++;
                                if (rangeSum[idx]<=min) {
                                    secMin=min;
                                    min=rangeSum[idx];
                                } else if (rangeSum[idx]<secMin)
                                    secMin=rangeSum[idx];
                                nSum[j]=sum+min;
                            }
                        }
                        // copy nSum to rangeSum
                        System.arraycopy(nSum,0,rangeSum,0,n);
                        //System.out.println(x+" "+ Arrays.toString(rangeSum));
                    } else {
                        len=b[x];
                        long min=Long.MAX_VALUE,secMin=Long.MAX_VALUE;
                        int idx=0;
                        for (int j=0;j<n;j++) {
                            int l=j+len-1;
                            if (l>=n) break;
                            long sum;
                            if (j==0) sum=-cum[l];
                            else sum=-(cum[l]-cum[j-1]);
                            if (j==0) {
                                for (int k=1;k<n;k++) {
                                    int lt=k+b[x+1]-1;
                                    if (lt>=l) break;
                                    idx++;
                                    if (min!=Long.MAX_VALUE) {
                                        if (rangeSum[k]<=min) {
                                            secMin=min;
                                            min=rangeSum[k];
                                        } else if (rangeSum[k]<secMin)
                                            secMin=rangeSum[k];
                                    } else {
                                        if (rangeSum[k]<=min)
                                            min=rangeSum[k];
                                    }
                                }
                                nSum[j]=sum+min;
                            } else {
                                if (min==rangeSum[j]) {
                                    if (secMin!=Long.MAX_VALUE) {
                                        min=secMin;
                                        secMin=Long.MAX_VALUE;
                                    } else min=Long.MAX_VALUE;
                                }
                                idx++;
                                if (rangeSum[idx]<=min) {
                                    secMin=min;
                                    min=rangeSum[idx];
                                } else if (rangeSum[idx]<secMin)
                                    secMin=rangeSum[idx];
                                nSum[j]=sum+min;
                            }
                        }
                        // copy nSum to rangeSum
                        System.arraycopy(nSum,0,rangeSum,0,n);
                        //System.out.println(x+" "+ Arrays.toString(rangeSum));
                    }
                    x--;
                }
                long mas=Long.MIN_VALUE;
                for (int j=0;j<n;j++) {
                    mas=Math.max(mas,rangeSum[j]);
                }
                System.out.println(mas);
            }
        }

        System.exit(0);
    }
}
