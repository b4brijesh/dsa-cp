package a_and_d_of_algos;

import java.io.*;
public class QuickSort {
	static int count=0;
	static int[] arr=new int[10000];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int i;
		for(i=0;i<10000;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		quicksort(0,10000-1);
		System.out.println(count);
	}
	
	static void quicksort(int i,int j){
		int len=j-i+1;
		if(len<=1)
			return ;
		int n,temp,med=i;
		int mid=i+(len-1)/2;
		if(arr[i]<arr[j]){
			if(arr[i]>arr[mid])
				med=i;
			else if(arr[mid]<arr[j])
				med=mid;
			else
				med=j;
		}
		else{
			if(arr[j]>arr[mid])
				med=j;
			else if(arr[mid]>arr[i])
				med=i;
			else
				med=mid;
		}
		//System.out.println(i+" "+mid+" "+j+" "+med);
		int piv=arr[med];
		temp=arr[i];
		arr[i]=arr[med];
		arr[med]=temp;
		int m=i+1;
		count=count+(len-1);
		for(n=i+1;n<=j;n++){
			if(arr[n]<piv){
				temp=arr[m];
				arr[m]=arr[n];
				arr[n]=temp;
				m++;
			}
		}
		temp=arr[i];
		arr[i]=arr[m-1];
		arr[m-1]=temp;
		quicksort(i,m-2);
		quicksort(m,j);
	}
}
