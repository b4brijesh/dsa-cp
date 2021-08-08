package classical;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 06-01-2017.
 */
public class HPYNOS {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        a=new int[1000];
        a[0]=-1;a[1]=1;a[2]=a[3]=a[4]=a[5]=a[6]=a[8]=a[9]-1;a[10]=a[100]=1;
        for(int i=4;i<1000;i++){
            if(a[i]==0) find(i);
        }
        int n=Integer.parseInt(br.readLine());
        int sum=sumDig(n);
        if(a[sum]>0) System.out.println(a[sum]+1);
        else System.out.println(-1);

        System.exit(0);
    }

    private static int find(int i) {
        int num=sumDig(i);
        if(a[num]!=0 && a[num]!=-1) {a[i]=a[num]+1;return a[i];}
        else if (a[num]==-1){a[i]=-1;return a[i];}
        else {int k=find(num); if(k>0) a[i]=k+1; else a[i]=-1; return a[i];}
    }

    private static int sumDig(int i) {
        int sum=0;
        while (i>0){
            int n=i%10;
            sum+=(n*n);
            i/=10;
        }
        return sum;
    }

    static int[] a;
}
