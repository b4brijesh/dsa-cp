package tcfs15p;

import java.io.*;
import java.util.*;
public class MARKS {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int i,j,k,counter,flag;
		int mark[][]=new int[5][100000];
		int count[]=new int[5];
		int lim[]=new int[5];
		for(i=1;i<=n;i++){
			StringTokenizer st= new StringTokenizer(br.readLine());
			char ch=st.nextToken().charAt(0);
			int marks=Integer.parseInt(st.nextToken());
			switch(ch){
				case 'A':mark[0][count[0]]=marks;count[0]++;break;
				case 'B':mark[1][count[1]]=marks;count[1]++;break;
				case 'C':mark[2][count[2]]=marks;count[2]++;break;
				case 'D':mark[3][count[3]]=marks;count[3]++;break;
				case 'E':mark[4][count[4]]=marks;count[4]++;break;
			}
		}
		for(i=0;i<5;i++){
			Arrays.sort(mark[i],0,count[i]);
			lim[i]=count[i]/10;
		}
		for(j=0;j<5;j++){
			if(count[j]>0)
				counter=1;
			else
				counter=0;
			flag=0;
			for(k=1;k<count[j];k++){
				if (mark[j][k]!=mark[j][k-1]){
					if(counter>lim[j]){
						System.out.print(mark[j][k-1]+" ");
						flag=1;
					}
					counter=1;
				}
				else
					counter++;
			}
			if(counter>lim[j]){
				System.out.print(mark[j][k-1]+" ");
				flag=1;
			}
			if(flag==0)
				System.out.println("Nothing Unusual");
			System.out.println();
		}
	}
}
