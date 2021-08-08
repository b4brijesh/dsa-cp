package classical;

import java.io.*;
public class ARITH {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in.txt"));
		int cases=Integer.parseInt(br.readLine());
		int i,j,k,l,m,n,strLen,str1Len,str2Len,mul,num1,num2,dig1,dig2,digOp,res,resLen,maxLen,carry;
		char ch=' ';
		int resArr[],resLenArr[];
		String str,str1=null,str2=null;
		for(i=1;i<=cases;i++) {
			str=br.readLine();
			strLen=str.length();
			for(j=0;j<strLen;j++) {
				ch=str.charAt(j);
				if((ch=='+')||(ch=='-')||(ch=='*')) {
					str1=str.substring(0,j);
					str2=str.substring(j+1,strLen);
					break;
				}
			}
			str1Len=str1.length();
			str2Len=str2.length();
			num1=Integer.parseInt(str1);
			num2=Integer.parseInt(str2);
			res=resLen=l=maxLen=0;
			resArr=new int[str2Len];
			resLenArr=new int[str2Len];
			switch(ch) {
			case '+':
				carry=0;
				while((num1>0)||(num2>0)||(carry>0)) {
					dig1=num1%10;
					dig2=num2%10;
					digOp=dig1+dig2+carry;
					res=((int)Math.pow(10,resLen)*(digOp%10))+res;
					carry=digOp/10;
					num1=num1/10;
					num2=num2/10;
					resLen++;
				}
				
				break;
			case '-':
				while(num1>0) {
					dig1=num1%10;
					dig2=num2%10;
					digOp=dig1-dig2;
					res=((int)Math.pow(10,resLen)*(digOp%10))+res;
					num1=num1/10;
					num2=num2/10;
					resLen++;
				}
				break;
			case '*':
				while(num2>0) {
					carry=0;
					mul=num1;
					res=resLen=0;
					dig2=num2%10;
					while((mul>0)||(carry>0)) {
						dig1=mul%10;
						digOp=(dig1*dig2)+carry;
						res=((int)Math.pow(10,resLen)*(digOp%10))+res;
						carry=digOp/10;
						mul=mul/10;
						resLen++;
					}
					num2=num2/10;
					resArr[l]=res;
					resLen=Integer.toString(res).length();
					resLenArr[l++]=resLen;
					maxLen=Math.max(maxLen,resLen+l-1);
				}
				break;
			}
			maxLen=Math.max(maxLen,str2Len+1);
			maxLen=Math.max(maxLen,resLen);
			maxLen=Math.max(maxLen,str1Len);
			for(k=1;k<=(maxLen-str1Len);k++)
				System.out.print(' ');
			System.out.println(str1);
			for(k=1;k<=(maxLen-str2Len-1);k++)
				System.out.print(' ');
			System.out.print(ch);
			System.out.println(str2);
			n=Math.max(str2Len+1,resLenArr[0]);
			for(k=1;k<=maxLen-n;k++)
				System.out.print(' ');
			for(k=1;k<=n;k++)
				System.out.print('-');
			System.out.println();
			if(l>1) {
				while(l>0) {
					m=resArr.length-l;
					for(k=1;k<=(maxLen-resLenArr[m])-m;k++)
						System.out.print(' ');	
					System.out.println(resArr[m]);
					l--;
				}
				for(k=1;k<=maxLen;k++)
					System.out.print('-');
				System.out.println();
				res=0;
				for(l=0;l<resArr.length;l++)
					res=res+((int)Math.pow(10,l)*resArr[l]);
				System.out.println(res);
				System.out.println();
				continue;
			}
			for(k=1;k<=(maxLen-resLen);k++)
				System.out.print(' ');
			System.out.println(res);
			System.out.println();
		}
		br.close();
	}

}
