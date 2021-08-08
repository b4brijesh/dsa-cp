package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 7/24/16.
 */
public class B116 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        char[][] arr=new char[n][m];
        boolean[][] marked=new boolean[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(marked[i],false);
            String s=br.readLine();
            for(int j=0;j<m;j++)
                arr[i][j]=s.charAt(j);
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (arr[i][j]=='P'){
                    if((i-1)>=0 && arr[i-1][j]=='W' && !marked[i-1][j]){
                        count++;
                        marked[i-1][j]=true;
                    }
                    else if((j-1)>=0 && arr[i][j-1]=='W' && !marked[i][j-1]){
                        count++;
                        marked[i][j-1]=true;
                    }
                    else if((j+1)<m && arr[i][j+1]=='W' && !marked[i][j+1]){
                        count++;
                        marked[i][j+1]=true;
                    }
                    else if((i+1)<n && arr[i+1][j]=='W' && !marked[i+1][j]){
                        count++;
                        marked[i+1][j]=true;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
