package cookOff69;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by brijesh on 9/27/16.
 */
public class LCPMAX {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            q=Integer.parseInt(st.nextToken());
            String str_s=br.readLine().trim();
            String str_t=br.readLine().trim();
            cs=str_s.toCharArray();
            ct=str_t.toCharArray();
            for(int j=1;j<=q;j++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                lcp(x,y);
            }
        }
    }
    static int n,q;
    static char[] cs,ct;
    private static void lcp(int x,int y){
        char[] bijection=new char[10];
        Arrays.fill(bijection,'k');
        boolean[] assigned_seta=new boolean[10];
        Arrays.fill(assigned_seta,false);
        boolean[] assigned_setb=new boolean[10];
        Arrays.fill(assigned_setb,false);
        int len=0;
        for(int i=x-1,j=y-1;i<n && j<n;i++,j++){
            if(!assigned_seta[cs[i]-97] && !assigned_setb[ct[j]-97]){
                assigned_seta[cs[i]-97]=true;
                assigned_setb[ct[i]-97]=true;
                bijection[cs[i]-97]=ct[j];
                len++;
            } else if(bijection[cs[i]-97]==ct[j])
                len++;
            else break;
        }
        System.out.print(len+" ");
        Queue<Character> unassigned=new LinkedList<>();
        for(int i=0;i<10;i++){
            if(!assigned_setb[i])
                unassigned.add((char)(i+97));
        }
        for(int i=0;i<10;i++){
            if(!assigned_seta[i])
                bijection[i]=unassigned.remove();
        }
        String s=new String(bijection);
        System.out.println(s);
    }
}
