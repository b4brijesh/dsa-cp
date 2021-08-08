package jan17Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 10-01-2017.
 */
public class TOURISTS {
    static int e09$7=1000000007;
    static double e_06=0.000001;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    static String d_loc2="C:\\Users\\Brijesh\\Downloads\\";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());
        int[] arr=new int[n+1];
        //+1=start dot; -1=end arrow
        int[] ar2=new int[n+1];
        int[] ar3=new int[n+1];
        int[][] edges=new int[e][2];
        int[][] backup=new int[e][2];
        for (int i=0;i<e;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            edges[i][0]=a;
            edges[i][1]=b;
            if (arr[a]==0) {
                arr[a]=1;
                if (arr[b]==0) {
                    arr[b]=-1;
                    ar2[b]=a;
                    ar3[a]=b;
                }
                else if (arr[b]==1) {
                    arr[b]=0;
                    ar2[b]=a;
                    ar3[a]=b;
                }
                else { //arr[b]=-1;
                    //reverse
                    arr[a]=-1;
                    arr[b]=0;
                    ar2[a]=b;
                    ar3[b]=a;
                }
            }
            else if (arr[a]==-1){
                arr[a]=0;
                if (arr[b]==0) {
                    arr[b]=-1;
                    ar2[b]=a;
                    ar3[a]=b;
                }
                else if (arr[b]==1) {
                    arr[b]=0;
                    ar2[b]=a;
                    ar3[a]=b;
                }
                else { //arr[b]=-1;
                    //reverse
                    arr[b]=0;
                    int curr=a;
                    int prev=b;
                    int next_node=ar2[curr];
                    while (arr[curr]!=1){
                        int next_next=ar2[next_node];
                        ar2[curr]=prev;
                        ar3[prev]=curr;
                        prev=curr;
                        curr=next_node;
                        next_node=next_next;
                    }
                    arr[curr]=-1;
                    ar2[curr]=prev;
                    ar3[prev]=curr;
                }
            }
            else { //arr[a]=1;
                if (arr[b]==0) {
                    arr[b]=1;
                    ar2[a]=b;
                    ar3[b]=a;
                    arr[a]=0;
                }
                else if (arr[b]==-1) {
                    arr[b]=0;
                    ar2[a]=b;
                    ar3[b]=a;
                    arr[a]=0;
                }
                else { //arr[b]=1;
                    //reverse
                    arr[a]=0;
                    arr[b]=0;
                    ar2[b]=a;
                    //int prev=b;
                    int curr=a;
                    int next_node=ar3[a];
                    ar3[a]=b;
                    while (arr[curr]!=-1){
                        int next_next;
                        if (arr[next_node]==-1) next_next=ar3[1];
                        else next_next=ar3[next_node];
                        ar2[curr]=next_node;
                        ar3[next_node]=curr;
                        //prev=curr;
                        curr=next_node;
                        next_node=next_next;
                    }
                    arr[curr]=1;
                }
            }
        }
        for (int i=1;i<=n;i++){
            if (arr[i]!=0) {
                System.out.println("NO");
                return;
            }
        }
        boolean[] visited=new boolean[n+1];
        Arrays.fill(visited,false);

        System.out.println("YES");
        for (int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            if (ar3[a]==b || ar2[b]==a) System.out.println(a+" "+b);
            else System.out.println(b+" "+a);
        }

        System.exit(0);
    }
}
