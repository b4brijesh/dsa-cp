package trial;

import java.io.*;
public class TRISQRS {
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		int tri=0;
		for(int i=1;i<=cases;i++){
			int side=Integer.parseInt(br.readLine());
			if((side%2)!=0)
				tri=(int)Math.pow(((side-1)/2),2)*2;
			else
				tri=(int)Math.pow((side/2),2)*2;
		}
		System.out.println(tri);
	}
}
