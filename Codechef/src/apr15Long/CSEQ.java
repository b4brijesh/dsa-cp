package apr15Long;

import java.io.*;
import java.math.*;
import java.util.*;
public class CSEQ {
    static long arr[]=new long[1000003];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());
        int i,j,n,l,r,x;
        long prod;
        int pow,m,k;
        StringTokenizer st;
        Arrays.fill(arr,0);
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine().trim());
            n=Integer.parseInt(st.nextToken().trim());
            l=Integer.parseInt(st.nextToken().trim());
            r=Integer.parseInt(st.nextToken().trim());
            x=r-l+1;
            prod=1;
            m=n+x;
            k=Math.min(n, x);
            int dig=(int)(Math.log(n+x)/Math.log(1000003));
            for(j=dig;j>=0;j--){
                pow=(int)Math.pow(1000003,j);
                prod=(prod*(choose(m/pow,k/pow)))%1000003;
                //System.out.println(prod);
                m=m%pow;
                k=k%pow;
                //System.out.println(pow+" "+m+" "+k);
            }
            System.out.println((prod+1000002)%1000003);
        }
    }
    static long choose(int m,int n){
        if(m<n)
            return 0;
        long prod=1;
        long i,base,pr,exp;
        for(i=m;i>m-n;i--)
            prod=(prod*i)%1000003;
        for(i=1;i<=n;i++) {
            if (arr[(int)i] == 0) {
                base = i;
                pr = 1;
                exp = 1000001;
                while (exp > 0) {
                    if (exp % 2 != 0)
                        pr = (pr * base) % 1000003;
                    exp = exp / 2;
                    base = (base * base) % 1000003;
                }
                arr[(int) i] = pr;
                prod = (prod * pr) % 1000003;
                //System.out.println(i+" "+prod);
            }
            else
                prod=prod*arr[(int)i]%1000003;
        }
        return prod;
    }
}
