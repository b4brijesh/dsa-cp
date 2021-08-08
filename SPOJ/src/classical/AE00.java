package classical;

import java.io.*;
public class AE00 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int i=1,s=0,d;
        d=(n/i)-i+1;
        while(d>0){
            s=s+d;
            i++;
            d=(n/i)-i+1;
        }
        System.out.println(s);
    }
}
