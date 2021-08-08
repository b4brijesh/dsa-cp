package contest579;

import java.io.*;
import java.util.*;
public class C579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int x2=a+b;
        /*int k=2;
        double x3=(double)x2/(double)k;
        if(b==0){
            System.out.println("0.000000001");
            return;
        }
        while(x3>=b){
            k+=2;
            x3=(double)x2/(double)k;
        }
        if(k==2)
            System.out.println(-1);
        else
            System.out.println((double)x2/(double)(k-2));*/
        if(b==0){
            System.out.println("0.000000001");
            return;
        }
        int k=(int)((double)x2/(double)b);
        if(k%2!=0)
            k--;
        if(k==0)
            System.out.println(-1);
        else System.out.println((double)x2/(double)k);
    }
}
