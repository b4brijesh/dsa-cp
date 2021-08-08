package contest631;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 03-03-2016.
 */
public class B631 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] row=new int[n+1];
        int[] col=new int[m+1];
        int[] r1=new int[n+1];
        int[] c1=new int[m+1];
        Arrays.fill(r1,0);
        Arrays.fill(c1,0);
        for(int i=1;i<=k;i++){
            st=new StringTokenizer(br.readLine());
            int cho=Integer.parseInt(st.nextToken());
            switch (cho){
                case 1:
                    int ro=Integer.parseInt(st.nextToken());
                    row[ro]=Integer.parseInt(st.nextToken());
                    r1[ro]=i;
                    break;
                case 2:
                    int co=Integer.parseInt(st.nextToken());
                    col[co]=Integer.parseInt(st.nextToken());
                    c1[co]=i;
                    break;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(r1[i]>c1[j])
                    System.out.print(row[i]);
                else System.out.print(col[j]);
                if(j!=m)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
