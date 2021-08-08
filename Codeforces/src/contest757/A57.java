package contest757;

/**
 * Created by Brijesh on 12-01-2017.
 */
//package icpc17online;

        import java.io.*;
        import java.util.*;

/**
 * Created by brijesh on 10/22/16.
 */
public class A57 {
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
        String ts=br.readLine().trim();
        int B,u2,l,b,a2,s,r;
        B=u2=l=b=a2=s=r=0;
        for(int i=0;i<ts.length();i++){
            char ch=ts.charAt(i);
            if(ch=='B') B++;
            if(ch=='u') u2++;
            if(ch=='l') l++;
            if(ch=='b') b++;
            if(ch=='a') a2++;
            if(ch=='s') s++;
            if(ch=='r') r++;
        }
        u2=u2/2;
        a2=a2/2;
        int min=Math.min(B,Math.min(u2,Math.min(l,Math.min(b,Math.min(a2,Math.min(s,r))))));
        System.out.println(min);

        System.exit(0);
    }
}
