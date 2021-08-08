package classical;

import java.io.*;
import java.util.*;
public class ACPC10A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int a,b,c;
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        do{
            if((a+c)==(2*b))
                System.out.println("AP "+(c+b-a));
            else
                System.out.println("GP "+(c*b/a));
            st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
        }while(a!=0 || b!=0 || c!=0);
    }
}
