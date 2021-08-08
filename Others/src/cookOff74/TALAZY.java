package cookOff74;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 9/22/16.
 */
public class TALAZY {
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
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            long backup_n=n,backup_b=b;
            long time=0;
            long idx=1;
            long m2=m;
            while(backup_n>0){
                long done;
                if(backup_n%2==0)
                    done=backup_n/2;
                else done=(backup_n+1)/2;
                long rem=backup_n-done;
                time+=(idx*m2*done);
                time+=b;
                idx*=2;
                backup_n=rem;
            }
            time-=b;
            System.out.println(time);
        }
    }
}
