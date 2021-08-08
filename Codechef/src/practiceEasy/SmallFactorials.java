package practiceEasy;

import java.io.*;
public class SmallFactorials {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in3.txt"));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		for(int i=1;i<=cases;i++){
			int num=Integer.parseInt(br.readLine()),arr[]=new int[200],carry=0,x,j,k,l,m=1,n;
			arr[0]=1;
			for(j=1;j<=num;j++){
				k=0;
				n=m;
				m=1;
				do{
					x=j*arr[k]+carry;
					arr[k]=x%10;
					carry=x/10;
					k++;
					m++;
				}
				while( (carry!=0) || ((n-1)>k) );
			}
			for(l=m-2;l>=0;l--){
				System.out.print(arr[l]);
			}
			System.out.println();
		}
		br.close();
	}
}
