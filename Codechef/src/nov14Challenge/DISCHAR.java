package nov14Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class DISCHAR {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		int arr[],index,i,j,k,count;
		for(i=1;i<=cases;i++){
			String s=br.readLine();
			int len=s.length();
			arr=new int[26];
			count=0;
			for(j=0;j<len;j++){
				index=s.charAt(j)-97;
				if(arr[index]==0)
					arr[index]=1;
			}
			for(k=0;k<26;k++)
				if(arr[k]!=0)
					count++;
			System.out.println(count);
		}
	}
}