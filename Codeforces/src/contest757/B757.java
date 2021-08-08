package contest757;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 12-01-2017.
 */
public class B757 {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
        if (n==1){
            System.out.println(1);
            return;
        }
        Arrays.sort(arr);
        boolean[] primes=new boolean[100001];
        Arrays.fill(primes,true);
        for(int i=2;i<=100000;i++){
            if (primes[i]) //primes[i]=true;
                for (int j=i*2;j<=100000;j+=i)
                    primes[j]=false;
        }
        ArrayList<Integer> prim=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for (int i=2;i<=100000;i++)
            if (primes[i]) {
                prim.add(i);
                set.add(i);
            }
        int[] prim2=new int[100001];
        for (int i=0;i<n;i++){
            int num=arr[i];
            for (int j=0;j<prim.size();j++){
                int div=prim.get(j);
                boolean divides=false;
                while (num!=1 && num%div==0) {
                    num=num/div;
                    divides=true;
                }
                if (divides) prim2[div]++;
                if (num==1) break;
                if (set.contains(num)){
                    prim2[num]++;
                    break;
                }
            }
        }
        int max=1;
        for (int i=2;i<=100000;i++){
            max=Math.max(max,prim2[i]);
        }
        System.out.println(max);

        System.exit(0);
    }
}
