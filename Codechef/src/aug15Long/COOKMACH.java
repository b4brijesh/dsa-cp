package aug15Long;

import java.io.*;
import java.util.*;
public class COOKMACH {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int i=1,j,ini=0,fin=0,count;
        StringTokenizer st;
        ArrayList<Integer> al=new ArrayList<Integer>();
        while(i<=10000000){
            al.add(i);
            i=i*2;
        }
        for(i=1;i<=t;i++) {
            //ini=fin=-1;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (j = 0; j < al.size(); j++) {
                if (al.get(j) == b)
                    fin = j;
                if (al.get(j) <= a)
                    ini = j;
            }
            j=ini;
            count=0;
            while(al.get(j)!=a) {
                a=a/2;
                count++;
                j--;
            }
            ini=j;
            count=count+Math.abs(fin-ini);
            System.out.println(count);
        }
    }
}
