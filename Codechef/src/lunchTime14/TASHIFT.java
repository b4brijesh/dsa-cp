package lunchTime14;

import java.io.*;
public class TASHIFT {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int len=Integer.parseInt(br.readLine());
		String A=br.readLine();
		String B=br.readLine();
		int i,count,finCount=0,shiftCounter=0,minShift=0;
		while(shiftCounter<len){
			count=0;
			i=0;
			while(A.charAt(i)==B.charAt(i++))
				count++;
			if(count>finCount){
				finCount=count;
				minShift=shiftCounter;
			}
			B=B.substring(1, len)+B.charAt(0);
			shiftCounter++;
		}
		System.out.println(minShift);
	}
}
