package CROC2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 18-03-2016.
 */
public class A644 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int[][] arr=new int[a][b];
        if(n>a*b)
            System.out.println(-1);
        else{
            //Arrays.fill(arr,(int)0);
            int k=1;
            if(b%2!=0){
                outer:for(int i=0;i<a;i++)
                    for(int j=0;j<b;j++){
                        if(k>n)
                            break outer;
                        arr[i][j]=k++;
                    }
            }
            else if(a%2!=0){
                outer:for(int i=0;i<b;i++)
                    for(int j=0;j<a;j++){
                        if(k>n)
                            break outer;
                        arr[j][i]=k++;
                    }
            }
            else{
                int l=2;
                for(int i=0;i<a;i++){
                    for(int j=0;j<b;j++){
                        if((i+j)%2==0){
                            if(k>n)
                                continue;
                            arr[i][j]=k;
                            k+=2;
                        }
                        else {
                            if(l>n)
                                continue;
                            arr[i][j]=l;
                            l+=2;
                        }
                    }
                }
            }
            for(int i=0;i<a;i++){
                for(int j=0;j<b;j++)
                    System.out.print(arr[i][j]+" ");
                System.out.println();
            }
        }
    }
}
