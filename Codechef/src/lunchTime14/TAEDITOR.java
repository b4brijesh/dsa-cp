package lunchTime14;

import java.io.*;
import java.util.*;
public class TAEDITOR {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int queries=Integer.parseInt(br.readLine());
		StringTokenizer st;
		String s="";
		int index,len;
		for(int i=1;i<=queries;i++){
			st=new StringTokenizer(br.readLine());
			if(st.nextToken().equals("+")){
				index=Integer.parseInt(st.nextToken());
				s=s.substring(0,index)+st.nextToken()+s.substring(index);
				continue;
			}
			else{
				index=Integer.parseInt(st.nextToken());
				len=Integer.parseInt(st.nextToken());
				System.out.println(s.substring(index-1, index+len-1));
			}
		}
	}

}
