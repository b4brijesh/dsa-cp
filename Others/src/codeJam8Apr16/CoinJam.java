package codeJam8Apr16;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 10-Apr-2016.
 */
public class CoinJam {
    //static byte[] arr;
    static long count;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Downloads/C-large.in"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int j=Integer.parseInt(st.nextToken());
            System.out.println("Case #"+i+":");
            count=(long)(Math.pow(2,n-1))+1;
            int c2=0;
            out:while(count<(long)Math.pow(2,n)){
                String str=findNextCoin();
                //System.out.println(str);
                if(str.charAt(0)!='1' || str.charAt(n-1)!='1'){
                    count++;
                    continue out;
                }
                count++;
                long[] arr=new long[11];
                outer:for(int k=2;k<=10;k++){
                    String s=Long.toString(Long.parseLong(str,k),10);
                    long num=Long.parseLong(s);
                    //System.out.println(k+" "+str+" "+s+" ");
                    int flag=0;
                    for(long l=2;l<num;l++){
                        if(l>1000000)
                            continue out;
                        if(num%l==0){
                            flag=1;
                            arr[k]=l;
                            continue outer;
                        }
                    }
                    if(flag==0)
                        continue out;
                }
                System.out.print(str+" ");
                for(int k=2;k<=9;k++)
                    System.out.print(arr[k]+" ");
                System.out.println(arr[10]);
                c2++;
                if(c2==j)
                    break;
            }
        }
    }
    static String findNextCoin(){
        String s=Long.toBinaryString(count);
        return s;
    }
}
