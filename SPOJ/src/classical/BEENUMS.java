package classical;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by Brijesh on 03-02-2016.
 */
public class BEENUMS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int i=1,j=1;
        Vector<Integer> v=new Vector<>();
        while (i<=1000000000){
            v.add(i);
            i=i+(6*j++);
        }
        while((i=Integer.parseInt(br.readLine()))!=-1){
            if(v.contains(i))
                System.out.println("Y");
            else System.out.println("N");
        }
    }
}
