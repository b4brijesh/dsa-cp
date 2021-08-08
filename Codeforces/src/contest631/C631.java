package contest631;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 03-03-2016.
 */
public class C631 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        Integer[] arr=new Integer[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        Manager[] mans=new Manager[m];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            mans[i]=new Manager(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        int newst=0;
        if(arr.length==1){
            System.out.println(arr[0]);
            return;
        }
        while(newst<m){
            int maxi=-1,maxr=0,maxt=0;
            for(int i=newst;i<m;i++){
                if(mans[i].r>maxr){
                    maxr=mans[i].r;
                    maxt=mans[i].t;
                    maxi=i;
                }
            }
            if(maxi!=-1){
                if(maxt==1)
                    Arrays.sort(arr,0,maxr);
                else Arrays.sort(arr,0,maxr,Collections.reverseOrder());
            }
            newst=maxi+1;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
            if(i!=n-1)
                System.out.print(" ");
        }
        System.out.println();
    }
    private static class Manager {
        int t;
        int r;
        Manager(int ti,int ri){
            t=ti;
            r=ri;
        }
    }
}
