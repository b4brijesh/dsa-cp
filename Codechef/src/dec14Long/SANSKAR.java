package dec14Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;
public class SANSKAR {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		for(int i=1;i<=cases;i++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			int arr[]=new int[n];
			int sum=0;
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				arr[j]=Integer.parseInt(st.nextToken());
				sum=sum+arr[j];
			}
			if((sum%k)!=0)
				System.out.println("no");
			//Arrays.sort(arr);
			//int div=sum/k,max=n-k+1;
		}
	}
}
