package practiceEasy;

import java.io.*;
//Run for 98690
public class PRPALIN {
	public static void main(String[] args)throws Exception {
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in.txt"));
		int i,flag=0,len,num=Integer.parseInt(br.readLine());
		String s,half1,half2;
		StringBuffer sb;
		while(flag==0){
			s=String.valueOf(num);
			len=s.length();
			half1=s.substring(0,(len+1)/2);
			half2=s.substring(len/2,len);
			sb=new StringBuffer(half2);
			half2=sb.reverse().toString();
			if(half1.equals(half2)){
				for(i=2;i<num;i++)
					if((num%i)==0){
						flag=0;
						System.out.println(num);
						break;
					}
					else
						flag=1;
			}
			num++;
		}
		System.out.println(num-1);
		br.close();
	}

}
