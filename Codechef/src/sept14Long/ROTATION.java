package sept14Long;

import java.io.*;
import java.util.*;
public class ROTATION {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n,m,i,count=0,pos;
		String str;
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int a[]=new int[n];
		for(i=1;i<=n;i++)
			a[i-1]=Integer.parseInt(st.nextToken());
		for(i=1;i<=m;i++){
			st=new StringTokenizer(br.readLine());
			str=st.nextToken();
			if(str.equals("C"))
				count+=Integer.parseInt(st.nextToken());
			if(str.equals("A"))
				count-=Integer.parseInt(st.nextToken());
			if(str.equals("R")){
				pos=Integer.parseInt(st.nextToken());
				System.out.println(a[(pos-1+count)%n]);
			}
		}
	}
}
