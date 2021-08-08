package jan17Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 09-01-2017.
 */
public class RESERVOI {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        outer:for (int k=0;k<t;k++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            g=new char[n][m];
            for (int i=0;i<n;i++){
                g[i]=br.readLine().trim().toCharArray();
            }
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    char c=g[i][j];
                    boolean valid=true;
                    if (c=='B') valid=validB(i,j);
                    else if (c=='W') valid=validW(i,j);
                    else valid=validA(i,j);
                    if (!valid) {
                        System.out.println("no");
                        continue outer;
                    }
                }
            }
            System.out.println("yes");
        }

        System.exit(0);
    }
    static int n,m;
    static char[][] g;
    static boolean validB(int i,int j){
        if (i+1<n) if (g[i+1][j]!='B') return false;
        return true;
    }
    static boolean validW(int i,int j){
        if (i+1<n) if (g[i+1][j]!='B' && g[i+1][j]!='W') return false;
        if (i-1>=0) if (g[i-1][j]!='W' && g[i-1][j]!='A') return false;
        if (j-1<0) return false;
        if (j+1>=m) return false;
        if (g[i][j-1]!='B' && g[i][j-1]!='W') return false;
        if (g[i][j+1]!='B' && g[i][j+1]!='W') return false;
        return true;
    }
    static boolean validA(int i,int j){
        if (j-1>=0) if (g[i][j-1]=='W') return false;
        if (j+1<m) if (g[i][j+1]=='W') return false;
        return true;
    }
}
