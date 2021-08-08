package classical;

import java.io.*;
import java.util.*;
public class NGM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long i= Long.parseLong(br.readLine());
        if(i%10==0)
            System.out.println("2");
        else{
            System.out.println("1");
            System.out.println(i%10);
        }
    }
}
