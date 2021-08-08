package classical;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 06-01-2017.
 */
public class NY10A {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++){
            int m=Integer.parseInt(br.readLine());
            char[] chars=br.readLine().trim().toCharArray();
            int[] seqs=new int[8];
            for (int j=2;j<40;j++){
                if (chars[j]=='H'){
                    if (chars[j-1]=='H'){
                        if (chars[j-2]=='H')
                            seqs[7]++;
                        else seqs[3]++;
                    } else {
                        if (chars[j-2]=='H')
                            seqs[5]++;
                        else seqs[1]++;
                    }
                } else {
                    if (chars[j-1]=='H'){
                        if (chars[j-2]=='H')
                            seqs[6]++;
                        else seqs[2]++;
                    } else {
                        if (chars[j-2]=='H')
                            seqs[4]++;
                        else seqs[0]++;
                    }
                }
            }
            System.out.print(m+" ");
            for (int j=0;j<8;j++)
                System.out.print(seqs[j]+" ");
            System.out.println();
        }

        System.exit(0);
    }
}
