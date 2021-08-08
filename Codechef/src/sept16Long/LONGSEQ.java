package sept16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Brijesh on 06-09-2016.
 */
public class LONGSEQ {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            String s=br.readLine();
            if(s.length()==1){
                System.out.println("Yes");
                continue;
            }
            int c0=0,c1=0;
            for(int j=0;j<s.length();j++)
                if(s.charAt(j)=='0')
                    c0++;
                else c1++;
            if(c0==1 || c1==1)
                System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
