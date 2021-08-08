package tcfs15p;

import java.io.*;
import java.util.*;
public class CAMERAS {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int ncam=Integer.parseInt(st.nextToken());
		int nsurge=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int cam[]=new int[ncam];
		int start[]=new int[nsurge];
		int stop[]=new int[nsurge];
		int i,j,count=0;
		for(i=1;i<=ncam;i++)
			cam[i-1]=Integer.parseInt(st.nextToken());
		for(i=1;i<=nsurge;i++){
			st=new StringTokenizer(br.readLine());
			start[i-1]=Integer.parseInt(st.nextToken());
			stop[i-1]=Integer.parseInt(st.nextToken());
		}
//		for(i=0;i<nsurge;i++){
//			for(j=0;j<ncam;j++){
//				if((start[i]<=cam[j])&&(cam[j]<=stop[i])){
//					cam[j]=0;
//					count++;
//				}
//			}
//		}
		
//		int numArr[]=new int[1000000000];
//		for(i=1;i<=nsurge;i++){
//			for(j=start[i-1];j<=stop[i-1];j++)
//				numArr[j]=1;
//		}
//		for(i=1;i<=ncam;i++){
//			if(numArr[cam[i-1]]!=0)
//				count++;
//		}
		for(i=0;i<ncam;i++){
			for(j=0;j<nsurge;j++)
				if((cam[i]<=stop[j]) && (cam[i]>=start[j])){
					count++;
					break;
				}
		}
		System.out.println(count);
	}
}
