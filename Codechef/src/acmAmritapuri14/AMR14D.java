package acmAmritapuri14;

import java.util.*;
import java.io.*;
public class AMR14D {
	public static void main (String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine().trim());
		int i,n,j;
		StringTokenizer st;
		int arr[];
		outer:for(i=1;i<=cases;i++){
		    n=Integer.parseInt(br.readLine().trim());
		    st=new StringTokenizer(br.readLine().trim());
		    arr=new int[n];
		    for(j=0;j<n;j++)
		        arr[j]=Integer.parseInt(st.nextToken().trim());
		    Arrays.sort(arr);
		    for(j=1;j<n;j++){
		        if(arr[j]==arr[j-1]){
		            System.out.println("NO");
		            continue outer;
		        }
		    }
		    System.out.println("YES");
		}
	}
}
