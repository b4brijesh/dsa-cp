package sept14Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class CHEFLR {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		int strLen,j,x,num;
		char ch;
		for(int i=1;i<=cases;i++) {
			String str=br.readLine();
			strLen=str.length();
			x=0;
			for(j=0;j<strLen;j++) {
				ch=str.charAt(j);
				if(ch=='l')
					x=x*2;
				else
					x=(x*2)+1;
			}
			if((strLen%2)==0)
				num=(((((int)Math.pow(4,(strLen/2))-1)/3)+1+x)*2)-1;
			else
				num=((((((int)Math.pow(4,((strLen-1)/2))-1)*2)/3)+1+x)*2);
			System.out.println(num%1000000007);
		}
	}
}