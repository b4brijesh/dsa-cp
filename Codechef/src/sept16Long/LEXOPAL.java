package sept16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Brijesh on 06-09-2016.
 */
public class LEXOPAL {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            String s=br.readLine();
            char[] str=new char[s.length()];
            for(int j=0;j<s.length();j++)
                str[j]=s.charAt(j);
            boolean pal=true;
            for(int j=0;j<(str.length+1)/2;j++){
                char c1=str[j];
                char c2=str[str.length-1-j];
                if(c1=='.' && c2=='.'){
                    str[j]='a';
                    str[str.length-1-j]='a';
                }
                else if(c1=='.')
                    str[j]=str[str.length-1-j];
                else if(c2=='.')
                    str[str.length-1-j]=str[j];
                if(str[j]!=str[str.length-1-j]){
                    pal=false;
                    break;
                }
            }
            if(pal)
                System.out.println(new String(str));
            else System.out.println(-1);
        }
    }
}
