package practiceEasy;

import java.io.*;
import java.util.*;
public class HolesInTheText {
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in3.txt"));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		for(int i=1;i<=cases;i++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			int len=str.length(),holes=0;
			for(int k=0;k<len;k++){
				if(str.charAt(k)=='A' ||str.charAt(k)=='D'||str.charAt(k)=='O'||str.charAt(k)=='P'||str.charAt(k)=='R'||str.charAt(k)=='Q')
					holes++;
				else if(str.charAt(k)=='B')
					holes+=2;
				else
					continue;
			}
			System.out.println(holes);
		}
		br.close();
	}
}
