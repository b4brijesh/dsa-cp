package jan17Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 08-01-2017.
 */
public class LazyLoading {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new FileReader
                (d_loc2+"lazy_loading.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] arr=new int[n];
            for (int j=0;j<n;j++)
                arr[j]=Integer.parseInt(br.readLine());
            Arrays.sort(arr);
            int trips=0;
            int k=0;
            for (int j=n-1;j>=0;j--){
                if (k>j) break;
                int top=arr[j];
                if (top>=50) {trips++;continue;}
                int items;
                if (50%top==0) items=(50/top)-1;
                else items=(50/top);
                int l=k+items;
                if (l<=j) {
                    trips++;
                    k=l;
                } else break;
            }
            System.out.println("Case #"+i+": "+trips);
        }

        System.exit(0);
    }
}
