package trial;

import java.io.*;
import java.util.StringTokenizer;
public class DIGONUM {
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		for(int i=1;i<=cases;i++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			String str=br.readLine();
			int m=n;
			int flag=1;
			String str1=null,str2=null;
			for(int j=1;j<=(n-k);j++){
				for(int l=1;l<=m;l++){
					if(str.charAt(l-1)==Character.forDigit(flag,10)){
						str1=str.substring(0,l-1);
						str2=str.substring(l,m);
						str1=str1.concat(str2);
						str=str1;
						m--;
						flag=1-flag;
						break;
					}
					if(l==m){
						str1=str.substring(1);
						str=str1;
						flag=1-flag;
						m--;
					}
				}
			}
			System.out.println(str1);
		}
		br.close();
	}

}
