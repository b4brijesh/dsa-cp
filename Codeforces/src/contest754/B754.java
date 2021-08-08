package contest754;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 06-01-2017.
 */
public class B754 {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        char[][] g=new char[4][4];
        for (int i=0;i<4;i++){
            g[i]=br.readLine().trim().toCharArray();
        }
        boolean f=false;
        outer:for (int m=0;m<4;m++){
            for (int n=0;n<2;n++){
                char a=g[m][n],b=g[m][n+1],c=g[m][n+2];
                if(match(a,b,c)){
                    //System.out.println(m+" a"+i+" "+j+" "+k);
                    f=true;System.out.println("YES"); break outer;
                }
            }
        }
        if(f) return;
        outer:for (int m=0;m<2;m++){
            for (int n=0;n<4;n++){
                char a=g[m][n],b=g[m+1][n],c=g[m+2][n];
                if(match(a,b,c)){
                    //System.out.println(m+" b"+i+" "+j+" "+k);
                    f=true;System.out.println("YES"); break outer;
                }
            }
        }
        if (f) return;
        outer:for (int m=0;m<4;m++){
            for (int n=0;n<4;n++){
                if (m+2>=4 || n+2>=4) continue ;
                char a=g[m][n],b=g[m+1][n+1],c=g[m+2][n+2];
                if(match(a,b,c)){
                    //System.out.println(m+" c"+i+" "+j+" "+k);
                    f=true;System.out.println("YES"); break outer;
                }
            }
        }
        if (f) return;
        outer:for (int m=0;m<4;m++){
            for (int n=0;n<4;n++){
                if (m+2>=4 || n-2<0) continue ;
                char a=g[m][n],b=g[m+1][n-1],c=g[m+2][n-2];
                if(match(a,b,c)){
                    //System.out.println(m+" d"+i+" "+j+" "+k);
                    f=true;System.out.println("YES"); break outer;
                }
            }
        }
        if (f) return;
        if (!f) System.out.println("NO");

        System.exit(0);
    }
    static boolean match(char a,char b,char c){
        String s=""+a+b+c;
        if (s.equals(".xx") ||s.equals("x.x") ||s.equals("xx.")){
            //System.out.println(s);
            return true;
        }
        return false;
    }
}
