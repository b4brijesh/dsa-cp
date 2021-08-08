package worksAp;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/15/16.
 */
public class testGenerator {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-practice.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int k=1;k<=6;k++){
            System.out.println();
            for (int i=1;i<=10;i++){
                for (int j=1;j<=10;j++){
                    System.out.print((int)Math.floor(Math.random()));
                }
                System.out.println();
            }
        }
        Exception e;
        System.exit(0);
    }
}
