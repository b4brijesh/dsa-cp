package aug16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 11-08-2016.
 */
public class CHEFRRUN {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] A=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                A[j]=Integer.parseInt(st.nextToken());
            }
            int[] count=new int[n];
            int[] visited=new int[n];
            Arrays.fill(visited,-1);
            int cou=0,lim=0;
            for(int j=0;j<n;j++){
                if(visited[j]==-1){
                    lim++;
                    //System.out.println("Visiting: "+j);
                    int k=j,l=1,old=-1;
                    do{
                        count[k]=l;
                        //System.out.println("Chaining: "+k+" count="+count[k]);
                        visited[k]=lim;
                        old=k;
                        k=k+A[k]+1;
                        //System.out.println("new k="+k);
                        k=k%n;
                        l++;
                    }while (visited[k]==-1);
                    if(visited[old]==visited[k]){
                        cou=cou+(count[old]-count[k]+1);
                        //System.out.println("old="+old+"k="+k);
                        //System.out.println("cou="+cou);
                    }
                }
            }
            System.out.println(cou);
        }
    }
}
