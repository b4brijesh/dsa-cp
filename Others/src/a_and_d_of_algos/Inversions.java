package a_and_d_of_algos;

/* package whatever; // don't place package name! */

import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Inversions
{
	public static long count=0;
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int i;
		int arr[]=new int[100000];
		for(i=0;i<100000;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		arr=sort(arr,100000);
		// for(i=0;i<3;i++){
		// 	System.out.println(arr[i]);
		// }
		System.out.println(count);
	}
	static int[] sort(int[] z,int len){
		if(len<=1){
			return z;
		}
		int arr1[]=new int[(len+1)/2];
		int arr2[]=new int[len/2];
		int k,l=0,m=(len+1)/2;
		for(k=0;k<(len+1)/2;k++){
			arr1[k]=z[l++];
		}
		for(k=0;k<len/2;k++){
			arr2[k]=z[m++];
		}
		arr1=sort(arr1,(len+1)/2);
		arr2=sort(arr2,len/2);
		l=0;
		m=0;
		for(k=0;k<len;k++){
			if((m==(len/2))||((l<((len+1)/2))&&(arr1[l]<=arr2[m]))){
				z[k]=arr1[l++];
			}
			else{
				z[k]=arr2[m++];
				count=count+arr1.length-l;
			}
		}
		return z;
	}
}