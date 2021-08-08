package practiceEasy;

import java.io.*;
public class Factorial {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in4.txt"));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		for(int i=1;i<=cases;i++) {
			int sum=0,powe;
			int num=Integer.parseInt(br.readLine());
			for(int j=5;j<=num;j+=5) {
				int divi=0,k=1;
				while(divi==0) {
					powe=(int)Math.pow(5,k);
					divi=j%powe;
					if(divi==0)
						sum++;
					k++;
				}
			}
			System.out.println(sum);
		}
		br.close();
	}
}
