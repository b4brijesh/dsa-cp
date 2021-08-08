package practiceEasy;

import java.io.*;
import java.util.*;
public class EnormousInputTest {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in4.txt"));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int s=0;
		for(int i=1;i<=n;i++) {
			if((Integer.parseInt(br.readLine())%k)==0)
				s++;
		}
		System.out.println(s);
		br.close();
	}
}
