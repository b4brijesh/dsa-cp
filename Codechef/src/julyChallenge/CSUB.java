package julyChallenge;

import java.io.*;
public class CSUB {
	public static void main(String[] args)throws Exception {
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in.txt"));
		int cases=Integer.parseInt(br.readLine());
		int i,j,count,sum,len;
		String str;
		char ch;
		for(i=1;i<=cases;i++) {
			len=Integer.parseInt(br.readLine());
			str=br.readLine();
			count=sum=0;
			for(j=0;j<len;j++){
				ch=str.charAt(j);
				if(ch=='1')
					sum=sum+(++count);
			}
			System.out.println(sum);
		}
		br.close();
	}
}
