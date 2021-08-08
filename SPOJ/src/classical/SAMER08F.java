package classical;

import java.io.*;
public class SAMER08F {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i,s;
        while((i=Integer.parseInt(br.readLine()))!=0){
            s=(i*(i+1)*((2*i)+1))/6;
            System.out.println(s);
        }
    }
}
