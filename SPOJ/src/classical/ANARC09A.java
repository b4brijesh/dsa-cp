package classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 28-02-2016.
 */
public class ANARC09A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s;
        int j=1;
        while((s=br.readLine()).charAt(0)!='-'){
            int count=0,rep=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='{')
                    count++;
                else count--;
                if(count==-1){
                    rep++;
                    count=1;
                }
            }
            System.out.println((j++)+". "+(rep+(count/2)));
        }
    }
}
