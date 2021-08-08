package WorldCup2015;

import java.io.*;
import java.util.*;
public class bishopWar {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        char[][] arr=new char[n][m];
        int i,j,k;
        String s;
        for(i=0;i<n;i++){
            s=br.readLine();
            for (j=0;j<m;j++){
                arr[i][j]=s.charAt(j);
            }
        }

    }
}