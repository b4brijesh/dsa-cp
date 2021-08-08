package classical;

import java.io.*;
public class EIGHTS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String s;
        int i;
        for(i=1;i<=t;i++){
            long k=Long.parseLong(br.readLine());
            if((k-1)%4==0)
                s="192";
            else if((k-1)%4==1)
                s="442";
            else if((k-1)%4==2)
                s="692";
            else
                s="942";
            if(k<=4)
                System.out.println(s);
            else
                System.out.println(((k-1)/4)+s);
        }
    }
}
