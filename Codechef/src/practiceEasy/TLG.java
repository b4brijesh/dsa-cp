package practiceEasy;

import java.io.*;
import java.util.*;
public class TLG {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in.txt"));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int rounds=Integer.parseInt(br.readLine());
		int s=0,t=0,lead=0,maxLead=0,winner=1;
		for(int i=1;i<=rounds;i++){
			StringTokenizer st= new StringTokenizer(br.readLine());
			s=s+Integer.parseInt(st.nextToken());
			t=t+Integer.parseInt(st.nextToken());
			lead=Math.abs(s-t);
			if(lead>maxLead){
				winner=(s>t)?1:2;
				maxLead=lead;
			}
		}
		System.out.println(winner+" "+maxLead);
		br.close();
	}

}
