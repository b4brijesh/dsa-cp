package weekOfCode24;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/12/16.
 */
public class Q2 {
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
        int g=Integer.parseInt(br.readLine());
        for (int i=1;i<=g;i++){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine().trim();
            if (n==1){
                System.out.println("YES");
                continue;
            }
            boolean _present=false;
            for (int j=0;j<s.length();j++)
                if (s.charAt(j)=='_'){
                    _present=true;
                    break;
                }
            if (!_present){
                boolean poss=true;
                for (int j=0;j<s.length();j++){
                    char ch=s.charAt(j);
                    if (j==0)
                        if(s.charAt(j+1)!=ch){
                            poss=false;
                            break;
                        }
                    else if (j==s.length()-1)
                        if(s.charAt(j-1)!=ch){
                            poss=false;
                            break;
                        }
                    else if (s.charAt(j+1)!=ch && s.charAt(j-1)!=ch){
                        poss=false;
                        break;
                    }
                }
                if (poss) System.out.println("YES");
                else System.out.println("NO");
            }
            else {
                int[] count=new int[26];
                for (int j=0;j<s.length();j++){
                    if (s.charAt(j)!='_')
                        count[s.charAt(j)-65]++;
                }
                boolean poss=true;
                for (int j=0;j<26;j++){
                    if (count[j]==1){
                        poss=false;
                        break;
                    }
                }
                if (poss) System.out.println("YES");
                else System.out.println("NO");
            }
        }

        System.exit(0);
    }
}
