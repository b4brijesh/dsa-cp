package junLong;

import java.util.*;
import java.io.*;
 
public class CHEFZOT {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		int i,num,count=0,fin=0;
		int len=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(i=1;i<=len;i++) {
			num=Integer.parseInt(st.nextToken());
			if(num==0)
				count=0;
			else 
				count++;
			if(count>fin)
				fin=count;
		}
		System.out.println(fin);
	}
}