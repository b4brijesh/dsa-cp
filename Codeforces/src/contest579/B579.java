package contest579;

import java.io.*;
import java.util.*;
public class B579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int i,j,k=0;
        Pair[] arr=new Pair[(2*n)*((2*n)-1)/2];
        boolean[] paired;
        paired=new boolean[2*n+1];
        Arrays.fill(paired,false);
        for(i=2;i<=(2*n);i++){
            st=new StringTokenizer(br.readLine());
            for(j=1;j<=i-1;j++){
                arr[k++]=new Pair(i,j,Integer.parseInt(st.nextToken()));
                //System.out.println(arr[k-1].i+" "+arr[k-1].j+" "+arr[k-1].strength);
            }
        }
        int[] finarr=new int[2*n+1];
        Arrays.sort(arr);
        for(i=arr.length-1;i>=0;i--){
            if(!paired[arr[i].i] && !paired[arr[i].j]){
                paired[arr[i].i]=true;
                paired[arr[i].j]=true;
                finarr[arr[i].i]=arr[i].j;
                finarr[arr[i].j]=arr[i].i;
            }
        }
        for(i=1;i<finarr.length-1;i++){
            System.out.print(finarr[i]+" ");
        }
        System.out.println(finarr[i]);
    }
    static class Pair implements Comparable<Pair>{
        int i,j,strength;
        Pair(int i,int j,int strength){this.i=i;this.j=j;this.strength=strength;}
        @Override
        public int compareTo(Pair o) {
            return this.strength-o.strength;
        }
    }
}
