package contest733;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 01-11-2016.
 */
public class D733 {
    static int e09$7=1000000007;
    static double e_07=0.0000001;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-practice.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        int[] a=new int[n];int[] b=new int[n];int[] c=new int[n];
        for (int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int z=Integer.parseInt(st.nextToken());
            long sum=((long)(x))+y+z;
            a[i]=Math.min(x,Math.min(y,z));
            c[i]=Math.max(x,Math.max(y,z));
            b[i]=(int)(sum-a[i]-c[i]);
        }
        PP[] pals=new PP[n];
        for (int i=0;i<n;i++){
            pals[i]=new PP(a[i],b[i],c[i],i);
        }
        Arrays.sort(pals, new Comparator<PP>() {
            @Override
            public int compare(PP o1, PP o2) {
                if (o1.c!=o2.c) return o2.c-o1.c;
                else if (o1.b!=o2.b) return o2.b-o1.b;
                else return o2.a-o1.a;
            }
        });
        int f=0,h=-1;
        long max=0;
        for (int i=0;i<n-1;i++){
            if (pals[i].b==pals[i+1].b && pals[i].c==pals[i+1].c){
                long min=Math.min(pals[i].a+pals[i+1].a,Math.min(pals[i].b,pals[i].c));
                if (min>=max){
                    f=i;h=i+1;
                    max=min;
                }
            }
            else {
                long min=Math.min(pals[i].a,Math.min(pals[i].b,pals[i].c));
                if (min>=max){
                    f=i;h=-1;
                    max=min;
                }
            }
        }
        long min=Math.min(pals[n-1].a,Math.min(pals[n-1].b,pals[n-1].c));
        if (min>=max){
            f=n-1;h=-1;
            max=min;
        }
        if (h==-1){
            System.out.println(1);
            System.out.println(pals[f].idx+1);
        } else {
            System.out.println(2);
            System.out.println((pals[f].idx+1)+" "+(pals[h].idx+1));
        }

        System.exit(0);
    }
}
class PP{
    int a,b,c,idx;
    PP(int a,int b,int c,int idx){this.a=a;this.b=b;this.c=c;this.idx=idx;}
}
