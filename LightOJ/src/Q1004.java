import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 10/4/16.
 */
public class Q1004 {
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
            int n=Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Long>> rows=new ArrayList<>();
            ArrayList<ArrayList<Long>> max_sums=new ArrayList<>();
            for(int j=0;j<(2*n-1);j++){
                st=new StringTokenizer(br.readLine());
                rows.add(new ArrayList<Long>());
                max_sums.add(new ArrayList<Long>());
                while(st.hasMoreTokens()){
                    rows.get(j).add(Long.parseLong(st.nextToken()));
                    max_sums.get(j).add(0L);
                }
            }
            max_sums.get(0).set(0,rows.get(0).get(0));
            for(int j=1;j<n;j++){
                for(int k=0;k<rows.get(j).size();k++){
                    long s1=0,s2=0;
                    if(k-1>=0)
                        s1=max_sums.get(j-1).get(k-1)+rows.get(j).get(k);
                    if(k<rows.get(j-1).size())
                        s2=max_sums.get(j-1).get(k)+rows.get(j).get(k);
                    max_sums.get(j).set(k,Math.max(max_sums.get(j).get(k),Math.max(s1,s2)));
                }
            }
            for(int j=n;j<(2*n-1);j++){
                for(int k=0;k<rows.get(j).size();k++){
                    long s1,s2;
                    s1=max_sums.get(j-1).get(k)+rows.get(j).get(k);
                    s2=max_sums.get(j-1).get(k+1)+rows.get(j).get(k);
                    max_sums.get(j).set(k,Math.max(max_sums.get(j).get(k),Math.max(s1,s2)));
                }
            }
            System.out.println("Case "+i+": "+max_sums.get(2*n-2).get(0));
        }
        System.exit(0);
    }
}
