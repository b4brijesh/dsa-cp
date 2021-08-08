package contest754;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 06-01-2017.
 */
public class A754 {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        int[] a=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++)
            a[i]=Integer.parseInt(st.nextToken());
        boolean fl=false;
        for (int i=0;i<n;i++){
            if (a[i]!=0){fl=true;break;}
        }
        ArrayList<Integer> f=new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<>();
        if (fl){
            System.out.println("YES");
            int sum=0;
            for (int i=0;i<n;i++){
                sum+=a[i];
            }
            if(sum==0){
                int s=0;
                for (int i=n-1;i>=0;i--){
                    s+=a[i];
                    if(s!=0){
                        System.out.println(2);
                        System.out.println(1+" "+i);
                        System.out.println((i+1)+" "+n);
                        break;
                    }
                }
            } else {
                System.out.println(1);
                System.out.println(1+" "+n);
            }
        } else System.out.println("NO");

        System.exit(0);
    }
}
