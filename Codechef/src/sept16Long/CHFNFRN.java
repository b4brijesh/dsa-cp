package sept16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by brijesh on 9/7/16.
 */
public class CHFNFRN {
    static boolean[][] adj_mat;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            adj_mat=new boolean[n][n];
            boolean[] setA=new boolean[n];
            boolean[] setB=new boolean[n];
            for(int j=0;j<n;j++){
                Arrays.fill(adj_mat[j],false);
                adj_mat[j][j]=true;
                setA[j]=true;
                setB[j]=false;
            }
            for(int j=0;j<m;j++){
                st=new StringTokenizer(br.readLine());
                int ai=Integer.parseInt(st.nextToken());
                int bi=Integer.parseInt(st.nextToken());
                adj_mat[ai-1][bi-1]=true;
                adj_mat[bi-1][ai-1]=true;
            }
            boolean poss=true;
            for(int j=0;j<n;j++){
                if(setA[j]){
                    boolean j_inB=true;
                    for(int k=0;k<n;k++){
                        if(setB[k]){
                            if(!adj_mat[j][k]){
                                j_inB=false;
                                break;
                            }
                        }
                    }
                    HashSet<Integer> not_c=new HashSet<>();
                    for(int k=0;k<n;k++){
                        if(!setB[k] && !adj_mat[j][k])
                            not_c.add(k);
                    }
                    Iterator<Integer> it=not_c.iterator();
                    int it_count=0;
                    boolean it_inB=true;
                    while(it.hasNext()){
                        int num=it.next();
                        boolean num_inB=true;
                        for(int k=0;k<n;k++){
                            if(setB[k]){
                                if(!adj_mat[num][k]){
                                    it_inB=false;
                                    num_inB=false;
                                }
                            }
                        }
                        if(num_inB){
                            it_count++;
                            setA[num]=false;
                            setB[num]=true;
                        }
                        else break;
                    }
                    //System.out.println("itinB="+j+it_inB);
                    if(!it_inB){
                        Iterator<Integer> it2=not_c.iterator();
                        while (it2.hasNext()){
                            int num=it2.next();
                            setA[num]=true;
                            setB[num]=false;
                        }
                    }
                    else if(it_inB && j_inB){

                    }
                    if(j_inB){
                        setA[j]=false;
                        setB[j]=true;
                        continue;
                    }
                    if(!j_inB && !it_inB){
                        poss=false;
                        break;
                    }
                }
            }
            if(poss)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
