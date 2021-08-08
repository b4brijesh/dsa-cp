package round306;

import java.io.*;
import java.util.*;
public class A550 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        int len=s.length();
        int i,flag=0;
        String s2;
        for(i=0;i<=len-2;i++){
            s2=s.substring(i,i+2);
            if(flag==0) {
                if (s2.equals("AB")) {
                    flag = 1;
                    i++;
                    continue;
                }
            }
            if(flag==1)
                if(s2.equals("BA")){
                    flag=3;
                    System.out.println("YES");
                    break;
                }
        }
        if(flag!=3) {
            flag=0;
            for (i = 0; i <= len - 2; i++) {
                s2 = s.substring(i, i + 2);
                if (flag == 0) {
                    if (s2.equals("BA")) {
                        flag = 2;
                        i++;
                        continue;
                    }
                }
                if (flag == 2)
                    if (s2.equals("AB")) {
                        flag = 3;
                        System.out.println("YES");
                        break;
                    }
            }
        }
        if(flag!=3)
            System.out.println("NO");
    }
}
