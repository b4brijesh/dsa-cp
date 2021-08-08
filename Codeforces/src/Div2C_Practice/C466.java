    package Div2C_Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 28-02-2016.
 */
public class C466 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        long sum=0L;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            sum+=arr[i];
        }
        double ds=(double)sum/(double)3;
        double is=sum/3;
        if(is!=ds){
            System.out.println(0);
            return;
        }
        long s1=0L,s2=0L,count=0L;
        ArrayList<Integer> al1=new ArrayList<>();
        ArrayList<Integer> al2=new ArrayList<>();
        for(int i=0;i<n;i++){
            s1+=arr[i];
            if(s1==sum/3){
                if(i+1<=n-1)
                    al1.add(i+1);
                //System.out.print(" "+(i+1));
            }
        }
        for(int i=n-1;i>=0;i--){
            s2+=arr[i];
            if(s2==sum/3){
                if(i>=2)
                    al2.add(i);
            }
        }
        Collections.sort(al2);
        int k=0;
        for(int i=0;i<al1.size();i++){
            for(int j=k;j<al2.size();j++){
                if(al2.get(j)>al1.get(i)){
                    count+=al2.size()-j;
                    k=j;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
