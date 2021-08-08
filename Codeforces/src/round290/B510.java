package round290;

import java.io.*;
import java.util.*;
public class B510 {
    static boolean cycle;
    static int n,m;
    static char board[][];
    static boolean visited[][];
    static int dx[]={1,-1,0,0};
    static int dy[]={0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        board=new char[n][m];
        visited=new boolean[n][m];
        int i,j;
        for(i=0;i<n;i++) {
            String str=br.readLine();
            for (j = 0; j < m; j++) {
                board[i][j]=str.charAt(j);
            }
        }
        for(i=0;i<n;i++)
            for(j=0;j<m;j++)
                visited[i][j]=false;
        cycle=false;
        for(i=0;i<n;i++) {
            if(cycle)
                break;
            for (j = 0; j < m; j++)
                if (!visited[i][j])
                    dfs(i, j,-1,-1, board[i][j]);
        }
        if(cycle)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    static void dfs(int x, int y,int fromX,int fromY, char color){
        //System.out.println(x+" "+y+" "+cycle+" "+color);
        if(x < 0 || x >= n || y < 0 || y >= m) return;
        if(board[x][y] != color) return;
        if(visited[x][y])
        {
            cycle = true;
            return;
        }
        visited[x][y] = true;
        for(int f = 0; f < 4; f++)
        {
            int nextX = x + dx[f];
            int nextY = y + dy[f];
            //System.out.println(x+" "+y+" "+nextX+" "+nextY+" "+cycle+" "+color);
            if(nextX == fromX && nextY == fromY) continue;
            dfs(nextX, nextY, x, y, color);
        }
    }
}
