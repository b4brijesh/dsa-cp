package apac16D;

import java.io.*;
import java.util.*;

public class DynamicGrid {
    static boolean[][] explored;
    static int r,c;
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Documents/SCC.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        int i,j,k,l;
        String s;
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            r=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            int[][] grid=new int[r][c];
            explored=new boolean[r][c];
            for(j=0;j<r;j++){
                s=br.readLine().trim();
                for(k=0;k<c;k++){
                    grid[j][k]=Integer.parseInt(s.charAt(k)+"");
                }
            }
            System.out.println("Case #"+i+":");
            int n=Integer.parseInt(br.readLine());
            for(j=1;j<=n;j++){
                st=new StringTokenizer(br.readLine());
                char op=st.nextToken().charAt(0);
                //System.out.println("j="+j);
                if(op=='M'){
                    int row=Integer.parseInt(st.nextToken());
                    int col=Integer.parseInt(st.nextToken());
                    grid[row][col]=Integer.parseInt(st.nextToken());
                    continue;
                }
                int count=0;
                for(k=0;k<r;k++)
                    Arrays.fill(explored[k],false);
                for(k=0;k<r;k++){
                    for(l=0;l<c;l++){
                        if(!explored[k][l]){
                            explored[k][l]=true;
                            if(grid[k][l]==1){
                                dfs(grid,k,l);
                                count++;
                                //System.out.println(k+" "+l);
                            }
                        }
                    }
                }
                System.out.println(count);
            }
        }
    }
    static void dfs(int[][] grid,int row,int col){
        explored[row][col]=true;
        //System.out.println("row="+row+"col="+col);
        if(col-1>=0 && !explored[row][col-1] && grid[row][col-1]==1)
            dfs(grid,row,col-1);
        if(col+1<c && !explored[row][col+1] && grid[row][col+1]==1)
            dfs(grid,row,col+1);
        if(row-1>=0 && !explored[row-1][col] && grid[row-1][col]==1)
            dfs(grid,row-1,col);
        if(row+1<r && !explored[row+1][col] && grid[row+1][col]==1)
            dfs(grid,row+1,col);
    }
}
