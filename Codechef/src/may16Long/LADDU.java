package may16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 08-05-2016.
 */
public class LADDU {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int acts=Integer.parseInt(st.nextToken());
            String ori=st.nextToken();
            long sum=0L;
            for(int j=1;j<=acts;j++){
                st=new StringTokenizer(br.readLine());
                String str=st.nextToken();
                if(str.equals("CONTEST_WON")){
                    int rank=Integer.parseInt(st.nextToken());
                    if(rank<20)
                        sum+=(300+(20-rank));
                    else //if(rank<=500)
                        sum+=300;
                }
                else if(str.equals("TOP_CONTRIBUTOR"))
                    sum+=300;
                else if(str.equals("BUG_FOUND")){
                    int sev=Integer.parseInt(st.nextToken());
                    sum+=sev;
                }
                else if(str.equals("CONTEST_HOSTED"))
                    sum+=50;
            }
            //System.out.println(sum);
            if(ori.equals("INDIAN"))
                System.out.println(sum/200);
            else if(ori.equals("NON_INDIAN"))
                System.out.println(sum/400);
        }
    }
}
