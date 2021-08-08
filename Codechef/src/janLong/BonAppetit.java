package janLong;

import java.io.*;
import java.util.StringTokenizer;

public class BonAppetit {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in2.txt"));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		
		for(int i=1;i<=cases;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int cust=Integer.parseInt(st.nextToken());
			//int compa=Integer.parseInt(st.nextToken());
			for(int j=1;j<=cust;j++) {
				
			}
		}
		br.close();

	}

}
