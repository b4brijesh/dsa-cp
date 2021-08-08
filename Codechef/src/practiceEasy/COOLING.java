package practiceEasy;

import java.io.*;
import java.util.*;
public class COOLING {
	public static void main(String[] args)throws Exception {
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in.txt"));
		int cases=Integer.parseInt(br.readLine());
		int i,j,nums,pie,count,pieArr[]=new int[30],rackArr[]=new int[30];
		StringTokenizer st;
		for(i=1;i<=cases;i++){
			nums=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			for(j=0;j<nums;j++)
				pieArr[j]=Integer.parseInt(st.nextToken());
			ascSort(pieArr,nums);
			st=new StringTokenizer(br.readLine());
			for(j=0;j<nums;j++)
				rackArr[j]=Integer.parseInt(st.nextToken());
			ascSort(rackArr,nums);
			pie=count=0;
			for(j=0;j<nums;j++)
				if(pieArr[pie]<=rackArr[j]){
					count++;
					pie++;
				}
			System.out.println(count);
		}
		br.close();
	}
	public static void ascSort(int arr[],int num){
		int a,b,temp;
		for(a=0;a<(num-1);a++)
			for(b=a+1;b<num;b++)
				if(arr[b]<arr[a]){
					temp=arr[a];
					arr[a]=arr[b];
					arr[b]=temp;
				}
	}

}
