package practiceEasy;

import java.io.*;
public class NUMGAME {
	public static void main(String[] args)throws Exception {
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in.txt"));
		int cases=Integer.parseInt(br.readLine());
		for(int i=1;i<=cases;i++){
			if((Integer.parseInt(br.readLine())%2)==0)
				System.out.println("ALICE");
			else
				System.out.println("BOB");
		}
		br.close();
	}
}