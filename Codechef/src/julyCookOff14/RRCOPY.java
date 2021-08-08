package julyCookOff14;

import java.io.*;
import java.util.StringTokenizer;

public class RRCOPY {
	private static StringTokenizer st;
	static BufferedReader br;
	public static void main(String[] args)throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(next());
        for(int j=1;j<=tc;j++) {
            int n = Integer.parseInt(next());
            boolean[] used = new boolean[100001];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(next());
                if (!used[x]) ans++;
                used[x] = true;
            }
            System.out.println(ans);
        }
	}
	
	public static String next()throws IOException {
      while (st == null || !st.hasMoreTokens())
          st = new StringTokenizer(br.readLine());
      return st.nextToken();
	}
}