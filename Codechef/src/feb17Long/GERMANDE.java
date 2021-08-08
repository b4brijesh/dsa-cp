package feb17Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 11-02-2017.
 */
public class GERMANDE {
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
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++) {
            st=new StringTokenizer(br.readLine());
            int o1=Integer.parseInt(st.nextToken());
            int o2=Integer.parseInt(st.nextToken());
            int n=o1*o2;
            int[] d=new int[n];
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++)
                d[j]=Integer.parseInt(st.nextToken());
            int[] state_one_cnt =new int[o1];
            int tot_one_cnt=0;
            for (int j=0;j<o1;j++) {
                state_one_cnt[j]=0;
                for (int k=0;k<o2;k++)
                    if (d[(j*o2)+k]==1) state_one_cnt[j]++;
                if (state_one_cnt[j]>o2/2) tot_one_cnt++;
            }
            if (tot_one_cnt>o1/2) {
                System.out.println(1);
                continue;
            }
            boolean found=false;
            for (int j=1;j<o2;j++) {
                for (int k=0;k<o1;k++) {
                    int bkp=state_one_cnt[k];
                    state_one_cnt[k]=findNewCount(d,o1,o2,j,k,state_one_cnt[k]);
                    if (state_one_cnt[k]>o2/2) {
                        if (bkp<=o2/2) tot_one_cnt++;
                    } else {
                        if (bkp>o2/2) tot_one_cnt--;
                    }
                }
                if (tot_one_cnt>o1/2) {
                    found=true;
                    System.out.println(1);
                    break;
                }
            }
            if (!found) System.out.println(0);
        }

        System.exit(0);
    }

    private static int findNewCount(int[] d, int o1, int o2, int j, int st_no,int p) {
        int next=(((st_no+1)*o2)+j-1)%(o1*o2);
        int last=((st_no*o2)+j-1)%(o1*o2);
        if (d[next]==d[last]) return p;
        else {
            if (d[next]==1 && d[last]==0) return p+1;
            else return p-1;
        }
    }
}
