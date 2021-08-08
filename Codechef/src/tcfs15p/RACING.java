package tcfs15p;

import java.io.*;
public class RACING {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int r=Integer.parseInt(br.readLine());
		int s=Integer.parseInt(br.readLine());
		int j,pr1=1,pr2=1,out=0,min;
		min=Math.min(r,s);
		if((Math.abs(r-s)<2)||(Math.max(r,s)<n))
			out=0;
		else{
			for(j=(n-1+min);j>=n;j--)
				pr1=pr1*j;
			for(j=1;j<=min;j++)
				pr2=pr2*j;
			if(Math.max(r,s)==n)
				out=(pr1/pr2)%1000000007;
			else
				out=(int)(Math.pow(2,min)*(pr1/pr2))%1000000007;
		}
		System.out.println(out);
	}
}
