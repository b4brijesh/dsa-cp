package nov14Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class PRPALN {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		int i,j,flag;
		for(i=1;i<=cases;i++){
			String s=br.readLine();
			int len=s.length();
			int subLen=len-1;
			flag=0;
			for(j=0;j<len;j++){
				String sub=s.substring(0,j)+s.substring(j+1);
				String sub1=sub.substring(0,subLen/2);
				String sub2=new StringBuffer(sub.substring((subLen+1)/2)).reverse().toString();
				if(sub1.equals(sub2)){
					System.out.println("YES");
					flag=1;
					break;
				}
			}
			if(flag!=1)
				System.out.println("NO");
		}
	}

}
