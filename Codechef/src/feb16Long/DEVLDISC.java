package feb16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 07-02-2016.
 */
public class DEVLDISC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++){
            int n=Integer.parseInt(br.readLine());
            if(n<=6){
                System.out.println(-1);
                continue;
            }
            System.out.println(n);
            if(n%2!=0){
                for(int j=1;j<n-1;j++)
                    System.out.println(j+" "+(j+1));
                System.out.println((n-1)+" "+1);
                System.out.println((((n/2)+1)-2)+" "+n);
            }
            else {
                for(int j=1;j<n-2;j++)
                    System.out.println(j+" "+(j+1));
                System.out.println((n-2)+" "+1);
                int avg1=(1+(n/2))/2;
                System.out.println(avg1+" "+(n-1));
                int avg2=(((n/2)+(n-1))/2)+1;
                System.out.println(avg2+" "+n);
            }
            System.out.println(1);
        }
    }
}
