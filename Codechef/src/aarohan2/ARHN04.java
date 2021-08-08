package aarohan2;

import java.io.*;
import java.math.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class ARHN04
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		int i,j,l;
		String a,b,st;
		for(i=1;i<=cases;i++){
		    st=br.readLine().trim();
		    l=st.length();
		    for(j=0;j<l;j++){
		        if(st.charAt(j)=='+'){
		            a=st.substring(0,j);
		            b=st.substring(j+1);
		            add(a,b);
		        }
		        if(st.charAt(j)=='-'){
		            a=st.substring(0,j);
		            b=st.substring(j+1);
		            sub(a,b);
		        }
		    }
		}
	}
	static void add(String a,String b){
	    BigInteger m=new BigInteger(a);
	    BigInteger n=new BigInteger(b);
	    BigInteger sum=m.add(n);
	    System.out.println(sum);
	}
	static void sub(String a,String b){
	    BigInteger m=new BigInteger(a);
	    BigInteger n=new BigInteger(b);
	    BigInteger sub=m.subtract(n);
	    System.out.println(sub);
	}
}
