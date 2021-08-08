package sept15Long;

import java.io.*;
import java.util.*;
public class MSTEP {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i;
        for(i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            Numbr[] arr=new Numbr[n*n];
            int j,k;
            for(j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                for(k=0;k<n;k++){
                    int num=Integer.parseInt(st.nextToken())-1;
                    arr[num]=new Numbr();
                    arr[num].row=j;
                    arr[num].col=k;
                }
            }
            int dist,sum=0;
            for(j=1;j<n*n;j++){
                dist=Math.abs(arr[j].row-arr[j-1].row)+Math.abs(arr[j].col-arr[j-1].col);
                sum=sum+dist;
            }
            System.out.println(sum);
        }
    }
    static class Numbr{
        int row,col;
    }
}
