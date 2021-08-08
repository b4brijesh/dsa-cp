package classical;

import java.io.*;
import java.math.*;
import java.util.*;

public class ACODE {
    static BigInteger fact[]=new BigInteger[5000];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int len,i,count=0,x,n;
        char c1,c2;
        Vector<Integer> v=new Vector<Integer>();
        BigInteger ans,sum;
        for(i=0;i<5000;i++)
            fact[i]=BigInteger.ZERO;
        fact[0]=BigInteger.ONE;
        while(!(str.charAt(0)=='0')){
            ans=BigInteger.ONE;
            len=str.length();
            count=0;
            for(i=1;i<len;i++){
                c1=str.charAt(i-1);
                c2=str.charAt(i);
                if(c1>'2'||c1=='0') {
                    v.add(count);
                    //System.out.print(count+" ");
                    count = 0;
                }
                else if(c1=='2'&&(c2=='7'||c2=='8'||c2=='9')) {
                    v.add(count);
                    //System.out.print(count+" ");
                    count = 0;
                }
                else if(c1=='2'&&c2=='0'){
                    if(count>0)
                        count--;
                    v.add(count);
                    //System.out.print(count+" ");
                    count = 0;
                }
                else if(c1=='1'&&c2=='0') {
                    if(count>0)
                        count--;
                    v.add(count);
                    //System.out.print(count+" ");
                    count = 0;
                }
                else
                    count++;
            }
            v.add(count);
            //System.out.print(count+" ");
            //System.out.println();
            for(i=0;i<v.size();i++){
                if(v.elementAt(i)==0)
                    continue;
                x=0;
                sum=BigInteger.ZERO;
                n=v.elementAt(i)+1;
                while(n-(2*x)>=0){
                    sum=sum.add(factorial(n - x).divide(factorial(n - (2 * x)).multiply(factorial(x))));
                    x++;
                }
                if(!sum.equals(BigInteger.ZERO)) {
                    //System.out.print(sum + " ");
                    ans = ans.multiply(sum);
                }
            }
            System.out.println(ans);
            v.clear();
            str=br.readLine();
        }
    }
    static BigInteger factorial(int b){
        int c=b;
        if(!fact[c].equals(BigInteger.ZERO))
            return fact[c];
        else
            while(fact[c].equals(BigInteger.ZERO))
                c--;
        for(int i=c+1;i<=b;i++)
            fact[i]=fact[i-1].multiply(BigInteger.valueOf(i));
        return fact[b];
    }
}
