package trial;

import java.io.*;
import java.util.*;
public class TRAINING {
	public static void main(String args[])throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		for(int i=1;i<=cases;i++){
			int numWalls=Integer.parseInt(br.readLine());
			int wallX[][]=new int[2000][2000];
			int wallY[][]=new int[2000][2000];
			int j,count=0;
			for(j=1;j<=numWalls;j++){
				StringTokenizer st=new StringTokenizer(br.readLine());
				wallX[j-1][0]=Integer.parseInt(st.nextToken());
				wallY[j-1][0]=Integer.parseInt(st.nextToken());
				wallX[j-1][1]=Integer.parseInt(st.nextToken());
				wallY[j-1][1]=Integer.parseInt(st.nextToken());
			}
			int queries=Integer.parseInt(br.readLine());
			for(int k=1;k<=queries;k++){
				StringTokenizer st=new StringTokenizer(br.readLine());
				int qtype=Integer.parseInt(st.nextToken());
				if(qtype==1){
					wallX[j][0]=Integer.parseInt(st.nextToken());
					wallY[j][0]=Integer.parseInt(st.nextToken());
					wallX[j][1]=Integer.parseInt(st.nextToken());
					wallY[j][1]=Integer.parseInt(st.nextToken());
					j++;
				}
				if(qtype==0){
					count=0;
					float pos=Float.parseFloat(st.nextToken());
					for(int l=0;l<j;l++){
						if((pos>=wallX[l][0]) && (pos<=wallX[l][1]))
							count++;
					}
					System.out.println(count);
				}
			}
		}
		br.close();
	}

}
