package cookOff68;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 10/4/16.
 */
public class ALTARAY {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            int n=Integer.parseInt(br.readLine());
            long[] arr=new long[n];
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++)
                arr[j]=Long.parseLong(st.nextToken());
            int[] las=new int[n];
            Arrays.fill(las,-1);
            for(int j=0;j<n;j++){
                if(las[j]==-1){
                    int k=j+1,len=1;
                    while(k<n){
                        if(arr[k]*arr[k-1]<0){
                            k++;
                            len++;
                        }
                        else break;
                    }
                    for(int l=j;l<k;l++){
                        las[l]=len;
                        len--;
                    }
                }
            }
            for(int j=0;j<n;j++)
                System.out.print(las[j]+" ");
            System.out.println();
        }
        System.exit(0);
    }
}
