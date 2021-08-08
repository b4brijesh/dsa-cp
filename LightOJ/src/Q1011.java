import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 10/4/16.
 */
public class Q1011 {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            n=Integer.parseInt(br.readLine());
            pri_idx=new int[n][n];
            for(int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                for (int k=0;k<n;k++)
                    pri_idx[j][k]=Integer.parseInt(st.nextToken());
            }
            int m=(int) Math.pow(2,n);
            dp=new int[n][m];
            for(int j=0;j<n;j++)
                Arrays.fill(dp[j],-1);
            System.out.println("Case "+i+": "+solve(0,0));
        }
        System.exit(0);
    }
    static int[][] dp;
    static int n;
    static int[][] pri_idx;
    static int solve(int idx,int bitmask){
        if(idx==n) return 0;
        if(dp[idx][bitmask]!=-1) return dp[idx][bitmask];
        int ans=0;
        for(int j=0;j<n;j++){
            if((bitmask & (1<<j))==0){
                int new_mask=bitmask | (1<<j);
                ans=Math.max(ans,pri_idx[idx][j]+solve(idx+1,new_mask));
            }
        }
        dp[idx][bitmask]=ans;
        //System.out.println(idx+" "+Integer.toBinaryString(bitmask)+" "+dp[idx][bitmask]);
        return ans;
    }
}
