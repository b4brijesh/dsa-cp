package Div2C_Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 26-02-2016.
 */

public class C489 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int m=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        String str=find_max(m,s);
        int l=str.length();
        if(s==0 && m==1){
            System.out.println("0 0");
            return;
        }
        if(l==0){
            System.out.println("-1 -1");
            return;
        }
        if(str.length()<m){
            for(int i=1;i<=m-l;i++)
                str+="0";
        }
        String s2=find_min(str);
        System.out.println(s2+" "+str);
    }
    static String find_max(int len,int sum){
        String str="";
        while(sum>0){
            if(sum>=9){
                str+=9;
                sum-=9;
            }
            else{
                str+=sum;
                sum-=sum;
            }
        }
        if(str.length()>len)
            return "";
        else
            return str;
    }
    static String find_min(String s){
        StringBuffer str=new StringBuffer(s);
        StringBuffer s2=str.reverse();
        if(s2.charAt(0)=='0'){
            s2.replace(0,1,"1");
            for(int i=1;i<s2.length();i++){
                if(s2.charAt(i)!='0'){
                    s2.replace(i,i+1,((Character)((char)(s2.charAt(i)-1))).toString());
                    break;
                }
            }
        }
        return s2.toString();
    }
}
