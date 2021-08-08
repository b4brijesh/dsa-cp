package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 7/22/16.
 */
public class A144 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        int minind=-1,maxind=-1,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]<=min){
                min=arr[i];
                minind=i;
            }
            if(arr[i]>max){
                max=arr[i];
                maxind=i;
            }
        }
        if(minind<maxind){
            System.out.println(maxind+(n-minind-1)-1);
        } else{
            System.out.println(maxind+(n-minind-1));
        }
    }
}
