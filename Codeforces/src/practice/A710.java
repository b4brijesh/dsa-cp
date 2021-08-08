package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 02-09-2016.
 */
public class A710 {
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Documents/SCC.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s=br.readLine();
        int col=s.charAt(0)-96;
        int row=s.charAt(1)-48;
        //System.out.println(col+" "+row);
        int moves=-1;
        if(col==1 || col==8){
            if(row==1 ||row==8)
                moves=3;
            else moves=5;
        }
        else if(row==1 ||row==8)
            moves=5;
        else moves=8;
        System.out.println(moves);
    }
}
