package julyChallenge;

import java.io.*;
import java.util.*;
public class RETPO {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int i,x,y,modX,modY,diff;
		for(i=1;i<=cases;i++) {
			st=new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			modX=Math.abs(x);
			modY=Math.abs(y);
			if(modX==modY)
				System.out.println(2*modX);
			else if(modX>modY) {
				diff=modX-modY;
				System.out.println((2*modY)+((diff/2)*4)+((diff%2)*3));
			}
			else {
				diff=modY-modX;
				System.out.println((2*modX)+((diff/2)*4)+((diff%2)*1));
			}
		}
	}
}
