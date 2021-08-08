package classical;

import java.io.*;
import java.util.*;
public class PRIME1 {
    static Vector<Integer> myPrimes=new Vector<Integer>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        int i,j,k,l,m=(int)Math.sqrt(1000000000)+1;
        boolean[] isPrime=new boolean[m+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(i=2;i<=m;i++){
            if(isPrime[i]){
                //System.out.println(i);
                myPrimes.addElement(i);
                for(j=i*2;j<=m;j+=i)
                    isPrime[j]=false;
            }
        }
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int range;
            if(a>m)
                range=b-a+1;
            else if(b>m){
                for(j=a;j<=m;j++)
                    if(isPrime[j])
                        System.out.print(j+" ");
                a=m+1;
                range=b-a+1;
            }
            else {
                for(j=a;j<=b;j++)
                    if(isPrime[j])
                        System.out.print(j+" ");
                System.out.println();
                continue;
            }
            boolean[] isPrm=new boolean[range];
            Arrays.fill(isPrm,true);
            //System.out.println(a+" "+b+" "+range);
            for(j=0;j<myPrimes.size();j++){
                l=((a-1)/myPrimes.elementAt(j))*myPrimes.elementAt(j);
                //System.out.println(myPrimes.elementAt(j)+" "+l);
                for(k=l+myPrimes.elementAt(j);k<=b;k+=myPrimes.elementAt(j)){
                    isPrm[k-a]=false;
                    //System.out.println("false: "+k);
                }
            }
            for(j=0;j<range;j++)
                if(isPrm[j])
                    System.out.print((a+j)+" ");
            System.out.println();
        }
    }
}