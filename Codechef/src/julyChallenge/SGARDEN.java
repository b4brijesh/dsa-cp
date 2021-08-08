package julyChallenge;

import java.io.*;
import java.util.*;
public class SGARDEN {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int j,k,l,m,n,start=0,temp;
		for(int i=1;i<=cases;i++){
			int bNum=Integer.parseInt(br.readLine());
			int posArr[]=new int[bNum];
			int count[]=new int[bNum];
			st=new StringTokenizer(br.readLine());
			for(j=1;j<=bNum;j++)
				posArr[j-1]=Integer.parseInt(st.nextToken());
			l=0;
			m=-1;
			for(k=0;k<bNum;k++){
				if(posArr[k]!=0){
					start=l=k;
					m++;
					do{
						temp=l;
						l=posArr[l]-1;
						posArr[temp]=0;
						count[m]++;
					}while(l!=start);
				}
			}
			n=1;
			while((n<bNum)&&(count[n]!=0)){
				count[n]=count[n]*count[n-1]
						/gcd(Math.max(count[n],count[n-1]),
								Math.min(count[n],count[n-1]));
				n++;
			}
			System.out.println(count[n-1]);
		}
	}
	
	public static int gcd(int a,int b){
		int rem=a%b;
		if(rem!=0)
			return gcd(b,rem);
		else
			return b;
	}
}
