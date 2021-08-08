package classical;

import java.io.*;
public class TOANDFRO {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String s,sub;
        StringBuffer sb;
        int len,m,i,j;
        char arr[][];
        while(n!=0){
            s=br.readLine();
            len=s.length();
            m=len/n;
            arr=new char[m][n];
            for(i=0;i<len;i=i+n){
                sub=s.substring(i,i+n);
                sb=new StringBuffer(sub);
                if(((i/n)%2)!=0)
                    sub=sb.reverse().toString();
                for(j=0;j<n;j++){
                    arr[i/n][j]=sub.charAt(j);
                }
            }
            for(i=0;i<n;i++)
                for(j=0;j<m;j++)
                    System.out.print(arr[j][i]);
            System.out.println();
            n=Integer.parseInt(br.readLine());
        }
    }
}
