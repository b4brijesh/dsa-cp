package practiceEasy;

import java.io.*;
import java.util.*;
public class PERMUT2 {
	public static void main(String[] args)throws Exception {
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in.txt"));
		int nums,i,j,k,flag;
		int numArr[]=new int[100000];
		while((nums=Integer.parseInt(br.readLine()))!=0){
			flag=0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(i=0;i<nums;i++)
				numArr[i]=Integer.parseInt(st.nextToken());
			for(j=0;j<nums;j++){
				k=numArr[j]-1;
				if(numArr[k]!=(j+1))
					flag=1;
			}
			if(flag==1)
				System.out.println("not ambiguous");
			else
				System.out.println("ambiguous");
		}
		br.close();
	}
}
