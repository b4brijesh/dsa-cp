package march16Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 07-03-2016.
 */
public class STRPALIN {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            String a=br.readLine();
            String b=br.readLine();
            int flag=0;
            outer:for(int j=0;j<a.length();j++){
                char c=a.charAt(j);
                for (int k=0;k<b.length();k++){
                    char d=b.charAt(k);
                    if(c==d){
                        flag=1;
                        break outer;
                    }
                }
            }
            if(flag==0)
                System.out.println("No");
            else System.out.println("Yes");
        }
    }
}
