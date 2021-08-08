package HackerEarthICPC;

import java.io.*;
import java.util.*;
public class primes {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int i,j,count,count2=0;
        outer:for(i=2;i<=500000000;i++){
            count=0;
            for(j=1;j<=i;j++){
                if(i%j==0)
                    count++;
                if(count>2)
                    continue outer;
            }
            if(count==2){
                System.out.print(i+",");
                count2++;
            }
        }
        System.out.println(count2);
    }
}
