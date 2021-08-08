package rmq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 08-06-2017.
 */
public class SparseTable {
    static int N,lgN;
    static int A[];
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N=Integer.parseInt(br.readLine());
        int lgN=(int)(Math.log(N)+1);
        st=new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++)
            A[i]=Integer.parseInt(st.nextToken());
        preprocess();
        st=new StringTokenizer(br.readLine());
        int i=Integer.parseInt(st.nextToken());
        int j=Integer.parseInt(st.nextToken());
        int k=(int)Math.log(j-i+1);
        if(A[spTbl[i][k]] <= A[spTbl[j - (1 << k) + 1][k]]) {
            System.out.println(spTbl[i][k]);
        } else {
            System.out.println(spTbl[j - (1 << k) + 1][k]);
        }
    }

    //sparse table stores index of minimum value element in range
    static int[][] spTbl=new int[N][lgN];
    private static void preprocess() {
        //initialize sparse table for the intervals with length 1
        for (int i=0;i<N;i++)
            spTbl[i][0]=i;
        //compute values from smaller to bigger intervals
        for (int j = 1; (1 << j) <= N; j++) {
            //length of each interval is 2^j i.e. i ranges from i to i+(2^j)-1
            for (int i = 0; (i + (1 << j) - 1) < N; i++) {
                if (A[spTbl[i][j - 1]] < A[spTbl[i + (1 << (j - 1))][j - 1]])
                    spTbl[i][j] = spTbl[i][j - 1];
                else
                    spTbl[i][j] = spTbl[i + (1 << (j - 1))][j - 1];
            }
        }
    }

}
