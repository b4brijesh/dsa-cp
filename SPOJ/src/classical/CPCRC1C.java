package classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 29-02-2016.
 */
public class CPCRC1C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long[] dp=new long[10];
        dp[0]=45L;
        for(int i=1;i<10;i++){
            dp[i]=(10L*dp[i-1])+(45L*(long)Math.pow(10,i));
        }
        int[] sin=new int[10];
        sin[0]=0;
        for(int i=1;i<10;i++)
            sin[i]=sin[i-1]+i;
        st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        do{
            long sum_a,sum_b;
            sum_a=dgt_sum(a-1,dp,sin);
            sum_b=dgt_sum(b,dp,sin);
            System.out.println(sum_b-sum_a);
            st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
        }while (a!=-1 && b!=-1);
    }
    static long dgt_sum(int a,long[] dp,int[] sin){
        int dig,i=0,k=0,prev_dig=0;
        long dig_sum,sum=0;
        while(a>0){
            dig=a%10;
            int num=dig*(int)Math.pow(10,i);
            if(i==0){
                dig++;
                dig_sum=sin[num];
            }
            else{
                dig_sum=(dp[k]*(long)dig)+((long)Math.pow(10,i)*(dig>0?(long)sin[dig-1]:0));
                k++;
            }
            dig_sum+=(long)(prev_dig*dig);
            //System.out.println("dig_sum="+dig_sum);
            sum+=dig_sum;
            prev_dig+=(dig*(int)Math.pow(10,i));
            //System.out.println("prev_dig="+prev_dig);
            i++;
            a/=10;
        }
        //System.out.println("sum="+sum);
        return sum;
    }
}
