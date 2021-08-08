package classical;

import java.io.*;
import java.math.*;
import java.util.*;
public class MUL {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i;
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            BigInteger a=new BigInteger(st.nextToken());
            BigInteger b=new BigInteger(st.nextToken());
            System.out.println((a.multiply(b)).toString());
        }
    }
}
