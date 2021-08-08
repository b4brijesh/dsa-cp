package classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 03-03-2016.
 */
public class RENT {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            int n=Integer.parseInt(br.readLine());
            for(int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
            }
            int[] dp=new int[n];
            for(int j=0;j<n;j++){
                //find stops at nth time
            }
        }
    }
    private class Order{
        int start;
        int dur;
        int pri;
        int stop;
    }
}
