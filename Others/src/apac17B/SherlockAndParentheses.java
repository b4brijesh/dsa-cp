package apac17B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 28-08-2016.
 */
public class SherlockAndParentheses {
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Documents/SCC.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("F://A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new FileReader("F://A-large.in"));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            int l=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());
            long ll=(long)l,lr=(long)r;
            long res=Math.min(ll,lr)*(Math.min(ll,lr)+1)/2;
            System.out.println("Case #"+(i+1)+": "+res);
        }
    }
}
