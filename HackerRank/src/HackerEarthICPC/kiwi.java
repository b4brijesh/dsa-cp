package HackerEarthICPC;

import java.io.*;
import java.util.*;
public class kiwi {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] primes={};
        int t=Integer.parseInt(br.readLine());
        int i,j,k,l,A,B;
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            A=Integer.parseInt(st.nextToken());
            B=Integer.parseInt(st.nextToken());
            for(j=A;j<=B;j++){
                k=j;
                l=0;
                while(k!=1){
                    if(k%primes[l]==0){
                        //pow=k/primes[l];
                    }
                }
            }
        }
    }
}
