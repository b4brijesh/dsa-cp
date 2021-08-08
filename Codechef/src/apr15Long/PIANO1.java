package apr15Long;

import java.io.*;

public class PIANO1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());
        int i,j,n,len,count,scount,tcount,sum;
        String s;
        for(i=1;i<=t;i++){
            s=br.readLine().trim();
            n=12*Integer.parseInt(br.readLine().trim());
            len=s.length();
            scount=tcount=0;
            for(j=0;j<len;j++) {
                if (s.charAt(j) == 'S')
                    scount++;
                if(s.charAt(j)=='T')
                    tcount++;
            }
            sum=(2*tcount)+scount;
            j=1;
            count=0;
            while((sum*j)<n){
                count+=n-sum*j;
                j++;
            }
            System.out.println(count);
        }
    }
}
