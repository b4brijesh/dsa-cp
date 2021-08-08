package round306;

import java.io.*;
import java.util.*;
public class C550 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        int i,j,k,len,n,flag=0;
        len=s.length();
        outer1:for(i=0;i<=len-3;i++){
            for(j=i+1;j<=len-2;j++){
                for(k=j+1;k<=len-1;k++){
                    n=Integer.parseInt(""+s.charAt(i)+s.charAt(j)+s.charAt(k));
                    if(n%8==0){
                        System.out.println("YES");
                        System.out.println(n);
                        flag=1;
                        break outer1;
                    }
                }
            }
        }
        if(flag==0) {
            outer2:
            for (i = 0; i <= len - 2; i++) {
                for (j = i + 1; j <= len - 1; j++) {
                    n = Integer.parseInt("" + s.charAt(i) + s.charAt(j));
                    if (n % 8 == 0) {
                        System.out.println("YES");
                        System.out.println(n);
                        flag = 1;
                        break outer2;
                    }
                }
            }
        }
        if(flag==0) {
            outer3:
            for (i = 0; i <= len - 1; i++) {
                n = Integer.parseInt("" + s.charAt(i));
                if (n % 8 == 0) {
                    System.out.println("YES");
                    System.out.println(n);
                    flag = 1;
                    break outer3;
                }
            }
        }
        if(flag==0)
            System.out.println("NO");
    }
}
