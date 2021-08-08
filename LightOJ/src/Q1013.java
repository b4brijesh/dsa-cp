import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 10/6/16.
 */
public class Q1013 {
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
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            System.out.println("Case "+i+": ");
            String s1=br.readLine().trim();
            String s2=br.readLine().trim();
            int s1_len=s1.length(),s2_len=s2.length();
            long[][][] dp=new long[s2_len+1][s1_len+1][2];
            for(int j=0;j<=s1_len;j++){
                dp[0][j][0]=0;
                dp[0][j][1]=1;
            }
            for(int j=0;j<=s2_len;j++){
                dp[j][0][0]=1;
                dp[j][0][1]=0;
            }
            dp[0][0][0]=dp[0][0][1]=1;
            int[] s2_ch_count=new int[24];
            //s1_ch_count[s1_ch-65]==s2_ch_count[s2_ch-65]
            for (int j=1;j<=s2_len;j++){
                int[] s1_ch_count=new int[24];
                char s2_ch=s2.charAt(j-1);
                s2_ch_count[s2_ch-65]++;
                for (int k=1;k<=s1_len;k++){
                    char s1_ch=s1.charAt(k-1);
                    s1_ch_count[s1_ch-65]++;
                    char s1_prev=' ',s2_prev=' ';
                    if(k-2>=0) s1_prev=s1.charAt(k-2);
                    if(j-2>=0) s2_prev=s2.charAt(j-2);
                    if(s1_ch==s2_ch){
                        if(s1_prev==s2_prev) dp[j][k][0]=dp[j][k][1]=dp[j-1][k-1][0];
                        else {
                            if(s2_ch_count[s1_prev-65]<=s1_ch_count[s1_prev-65]
                                    && s2_ch_count[s2_prev-65]>s1_ch_count[s2_prev-65])
                                dp[j][k][0]=dp[j][k][1]=dp[j-1][k-1][0];
                            else if(s2_ch_count[s2_prev-65]<=s1_ch_count[s2_prev-65])
                            dp[j][k][0]=dp[j][k][1]=dp[j-1][k-1][0]+dp[j-1][k-1][1];
                        }
                    } else {
                        if(s2_ch==s1_prev) dp[j][k][0]=dp[j][k-1][0];
                        else dp[j][k][0]=dp[j][k-1][0]+dp[j][k-1][1];
                        if(s1_ch==s2_prev) dp[j][k][1]=dp[j-1][k][0];
                        else dp[j][k][1]=dp[j-1][k][0]+dp[j-1][k][1];
                    }
                }
            }
            for(int j=0;j<=s2_len;j++){
                for (int k=0;k<=s1_len;k++)
                    System.out.print(dp[j][k][0]+"h"+dp[j][k][1]+" ");
                System.out.println();
            }
            if (s1.charAt(s1_len-1)==s2.charAt(s2_len-1))
                System.out.println(dp[s2_len][s1_len][0]);
            else System.out.println(dp[s2_len][s1_len][0]+dp[s2_len][s1_len][1]);
        }

        System.exit(0);
    }
}
