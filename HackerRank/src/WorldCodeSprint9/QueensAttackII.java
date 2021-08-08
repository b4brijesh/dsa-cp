package WorldCodeSprint9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 28-01-2017.
 */
public class QueensAttackII {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static long INF=1000000000000000L;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int rq=Integer.parseInt(st.nextToken());
        int cq=Integer.parseInt(st.nextToken());
        //findTotal(n,rq,cq);
        int[][] obs=new int[k][2];
        for (int i=0;i<k;i++) {
            st=new StringTokenizer(br.readLine());
            obs[i][0]=Integer.parseInt(st.nextToken());
            obs[i][1]=Integer.parseInt(st.nextToken());
        }
        int sum=0;
        int mini_up=n+1,mini_dn=0;
        for (int i=0;i<k;i++) {
            if (obs[i][1]==cq) {
                if (obs[i][0]>rq) mini_up=Math.min(mini_up,obs[i][0]);
                else mini_dn=Math.max(mini_dn,obs[i][0]);
            }
        }
        sum+=(mini_up-rq-1);
        //System.out.println(sum);
        sum+=(rq-mini_dn-1);
        //System.out.println(sum);
        int mini_rt=n+1,mini_lt=0;
        for (int i=0;i<k;i++) {
            if (obs[i][0]==rq) {
                if (obs[i][1]>cq) mini_rt=Math.min(mini_rt,obs[i][1]);
                else mini_lt=Math.max(mini_lt,obs[i][1]);
            }
        }
        sum+=(mini_rt-rq-1);
        //System.out.println(sum);
        sum+=(rq-mini_lt-1);
        //System.out.println(sum);
        int mini_ur=(n-rq>n-cq)?n+1:cq+(n-rq)+1,mini_ul=(n-rq>cq-1)?0:cq-(n-rq)-1;
        int mini_dr=(rq-1>n-cq)?n+1:cq+rq,mini_dl=(rq>cq)?0:cq-rq;
        for (int i=0;i<k;i++) {
            if (obs[i][0]>rq && obs[i][0]-rq==obs[i][1]-cq)
                mini_ur=Math.min(mini_ur,obs[i][1]);
            else if (obs[i][0]>rq && obs[i][0]-rq==cq-obs[i][1])
                mini_ul=Math.max(mini_ul,obs[i][1]);
            else if (obs[i][0]<rq && rq-obs[i][0]==obs[i][1]-cq)
                mini_dr=Math.min(mini_dr,obs[i][1]);
            else if (obs[i][0]<rq && rq-obs[i][0]==cq-obs[i][1])
                mini_dl=Math.max(mini_dl,obs[i][1]);
        }
        sum+=(mini_ur-rq-1);
        //System.out.println(sum);
        sum+=(rq-mini_ul-1);
        //System.out.println(sum);
        sum+=(mini_dr-rq-1);
        //System.out.println(sum);
        sum+=(rq-mini_dl-1);
        System.out.println(sum);

        System.exit(0);
    }
}
