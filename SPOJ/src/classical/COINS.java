package classical;

import java.io.*;
import java.util.*;
public class COINS {
    static long[] arr=new long[10000001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n;
        String s;
        Arrays.fill(arr,-1L);
        arr[0]=0L;
        s=br.readLine();
        while(s!=null){
            n=Integer.parseInt(s);
            System.out.println(maxCoins(n));
            s=br.readLine();
        }
    }
    static long maxCoins(int n){
        if(n<=10000000 && arr[n]!=-1)
            return arr[n];
        long sum=maxCoins(n/2)+maxCoins(n/3)+maxCoins(n/4);
        if(n>sum){
            if(n<=10000000)
                arr[n]=n;
            return n;
        }
        else {
            if(n<=10000000)
                arr[n]=sum;
            return sum;
        }
    }
}
