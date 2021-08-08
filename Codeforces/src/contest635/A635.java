package contest635;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 28-02-2016.
 */
public class A635 {
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int r,c,n,k;
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[r][c];
        for(int i=0;i<r;i++){
            Arrays.fill(arr[i],0);
        }
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            arr[x-1][y-1]=1;
        }
        int max=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                for(int l=i;l<r;l++){
                    for(int m=j;m<c;m++){
                        int count=violas(i,j,l,m);
                        //System.out.println(i+" "+j+" "+" "+l+" "+m);
                        if(count>=k)
                            max++;
                    }
                }
            }
        }
        System.out.println(max);
    }
    static int violas(int a,int b,int c,int d){
        int count=0;
        for(int i=a;i<=c;i++){
            for(int j=b;j<=d;j++){
                if(arr[i][j]==1)
                    count++;
            }
        }
        //System.out.println("c"+count);
        return count;
    }
}
