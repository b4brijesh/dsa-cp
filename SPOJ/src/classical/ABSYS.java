package classical;

import java.io.*;
import java.util.*;
public class ABSYS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int i,j,a,b,c,x=0,y=0,z=0,len;
        String str,s1,s2,s3;
        StringTokenizer st;
        for(i=1;i<=t;i++){
            br.readLine();
            str=br.readLine();
            st=new StringTokenizer(str,"+=");
            s1=st.nextToken().trim();
            s2=st.nextToken().trim();
            s3=st.nextToken().trim();
            len=str.length();
            for(j=0;j<len;j++){
                char ch=str.charAt(j);
                if(ch=='+')
                    x=j;
                if(ch=='=')
                    y=j;
                if(ch=='m')
                    z=j;
            }
            if(z<x){
                b=Integer.parseInt(s2);
                c=Integer.parseInt(s3);
                a=c-b;
            }
            else if(z<y){
                a=Integer.parseInt(s1);
                c=Integer.parseInt(s3);
                b=c-a;
            }
            else{
                a=Integer.parseInt(s1);
                b=Integer.parseInt(s2);
                c=a+b;
            }
            System.out.println(a+" + "+b+" = "+c);
        }
    }
}
