package contest631;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 03-03-2016.
 */
public class D631 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int nt=Integer.parseInt(st.nextToken());
        int ms=Integer.parseInt(st.nextToken());
        String t="",s="";
        st=new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String tok=st.nextToken();
            int len=tok.charAt(0)-48;
            //System.out.println(len);
            char c=tok.charAt(2);
            for(int i=1;i<=len;i++)
                t+=c;
        }
        st=new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String tok=st.nextToken();
            int len=tok.charAt(0)-48;
            char c=tok.charAt(2);
            for(int i=1;i<=len;i++)
                s+=c;
        }
        //System.out.println(t+" "+s);
        int count=0;
        int tlen=t.length(),slen=s.length();
        for(int i=0;i<=tlen-slen;i++){
            String sub=t.substring(i,i+slen);
            //System.out.println(sub);
            if(sub.equals(s))
                count++;
        }
        System.out.println(count);
    }
}
