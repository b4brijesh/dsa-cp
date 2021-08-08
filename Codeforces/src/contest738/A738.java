package contest738;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 11/20/16.
 */
public class A738 {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        String s=br.readLine().trim();
        String s2="";
        boolean cn=false;
        for (int i=0;i<n;){
            if (i+2<n && s.charAt(i)=='o' && s.charAt(i+1)=='g' && s.charAt(i+2)=='o'){
                if (cn) s2+="***";
                cn=true;
                i+=3;
            }
            else if (i+1<n && cn && s.charAt(i)=='g' && s.charAt(i+1)=='o')
                i+=2;
            else if (cn){
                cn=false;
                s2+="***";
                s2+=s.charAt(i);
                i++;
            }
            else {
                s2+=s.charAt(i);
                i++;
            }
        }
        if (cn) s2+="***";
        System.out.println(s2);

        System.exit(0);
    }
}
