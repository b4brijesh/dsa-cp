package ZeptoLabCodeRush15;

import java.io.*;
public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String s=br.readLine();
        int i,j,k,l,m=n/4,count;
        boolean flag=false;
        outer:for(i=0;i<n;i++){
            for(j=1;j<=m;j++){
                count=0;
                k=i;
                while(k<n && s.charAt(k)=='*') {
                    k += j;
                    count++;
                }
                if(count>=4) {
                    System.out.println("yes");
                    flag=true;
                    break outer;
                }
            }
        }
        if(!flag)
            System.out.println("no");
    }
}
