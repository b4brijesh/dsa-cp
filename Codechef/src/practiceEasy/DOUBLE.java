package practiceEasy;

import java.io.*;
public class DOUBLE {
	public static void main(String[] args)throws Exception {
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in.txt"));
		int i,j,cases=Integer.parseInt(br.readLine());
		for(i=1;i<=cases;i++)
			if(((j=Integer.parseInt(br.readLine()))%2)==0)
				System.out.println(j);
			else
				System.out.println(j-1);
		br.close();
	}
}
