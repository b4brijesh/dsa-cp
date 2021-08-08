package contest579;

import java.io.*;
import java.util.*;
public class A579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int count=0;
        while (x > 0) {
            int logval = (int) ((double) Math.log(x) / (double) Math.log(2));
            int pow = (int) Math.pow(2, logval);
            x = x - pow;
            count++;
            //System.out.println(x);
        }
        System.out.println(count);
    }
}
