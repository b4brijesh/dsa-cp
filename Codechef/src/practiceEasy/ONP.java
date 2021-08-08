package practiceEasy;

import java.io.*;
public class ONP {
	public static void main(String[] args) throws Exception {
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in.txt"));
		int cases=Integer.parseInt(br.readLine());
		String input;
		char a;
		int i,j,opCount,strLen,braCount;
		char opArr[];
		for(i=1;i<=cases;i++) {
			input=br.readLine();
			strLen=input.length();
			opArr=new char[strLen];
			opCount=0;
			braCount=0;
			for(j=0;j<strLen;j++) {
				a=input.charAt(j);
				if(a=='(')
					braCount++;
				if(a==')')
					braCount--;
				if((a>='a') && (a<='z'))
					System.out.print(a);
				if((a=='+')||(a=='-')||(a=='*')||(a=='/')||(a=='^')) {
					opArr[opCount]=a;
					opCount++;
				}
				if((a==')')&&(opCount>0)&&(braCount==opCount)) {
					System.out.print(opArr[opCount-1]);
					opCount--;
				}
			}
			System.out.println();
		}
		
		br.close();
	}
}
