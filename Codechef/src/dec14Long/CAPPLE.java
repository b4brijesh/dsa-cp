package dec14Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class CAPPLE {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		for(int i=1;i<=cases;i++){
			int nt=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			int arr[]=new int[nt];
			for(int j=0;j<nt;j++)
				arr[j]=Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			int count=1;
			for(int k=1;k<nt;k++){
				if(arr[k]!=arr[k-1])
					count++;
			}
			System.out.println(count);
		}
	}
}
