package classical;

import java.io.*;
import java.util.*;

public class HANGOVER {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Vector<Double> v=new Vector<Double>();
        int i=2;
        double s=0;
        while(s<=5.20){
            s=s+(1/(double)i);
            v.add(s);
            i++;
        }
        double c=Double.parseDouble(br.readLine());
        while(c!=0.0){
            i=0;
            while(v.elementAt(i)<c)
                i++;
            System.out.println((i+1)+" card(s)");
            c=Double.parseDouble(br.readLine());
        }
    }
}
