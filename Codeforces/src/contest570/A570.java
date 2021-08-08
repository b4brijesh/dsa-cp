package contest570;

import java.io.*;
import java.util.*;
public class A570 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ncands=Integer.parseInt(st.nextToken());
        int ncities=Integer.parseInt(st.nextToken());
        Votes arr[][]=new Votes[ncities][ncands];
        int i,j;
        for(i=0;i<ncities;i++){
            st=new StringTokenizer(br.readLine());
            for(j=0;j<ncands;j++)
                arr[i][j]=new Votes(j,Integer.parseInt(st.nextToken()));
        }
        Votes arr2[]=new Votes[ncands];
        for(i=0;i<ncands;i++)
            arr2[i]=new Votes(i,0);
        for(i=0;i<ncities;i++){
            Arrays.sort(arr[i]);
            arr2[arr[i][0].index].votes++;
        }
        Arrays.sort(arr2);
        System.out.println(arr2[0].index+1);
    }
    private static class Votes implements Comparable<Votes>,Comparator<Votes>{
        int index,votes;
        Votes(int ind,int v){index=ind;votes=v;}
        @Override
        public int compareTo(Votes o) {
            return o.votes-this.votes;
        }
        @Override
        public int compare(Votes o1, Votes o2) {
            return o2.votes-o1.votes;
        }
    }
}
