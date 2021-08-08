package july15Cook;

import java.io.*;
import java.util.*;

public class SUMPAIR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i;
        for (i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            int j;
            int[] arr=new int[n];
            for(j=0;j<n;j++)
                arr[j]=Integer.parseInt(st.nextToken());
            Vector<Integer> pairs=new Vector<Integer>();
            Vector<Integer> pairIndices=new Vector<Integer>();
            int k;
            for(j=0;j<n;j++){
                for(k=j+1;k<n;k++){
                    if(arr[k]-arr[j]<d){
                        pairs.add(arr[j]);
                        pairs.add(arr[k]);
                        pairIndices.add(j);
                        pairIndices.add(k);
                    }
                }
            }
            for(j=0;j<pairIndices.size();j+=2){
                int sum=0;
                int el1i=pairIndices.elementAt(j);
                int el2i=pairIndices.elementAt(j+1);
                sum=sum+pairs.elementAt(j)+pairs.elementAt(j+1);
                Vector<Integer> dispairs=new Vector<Integer>();
                dispairs.add(el1i,el2i);
                for(k=j+2;k<pairIndices.size();k+=2){
                    int el3i=pairIndices.elementAt(k);
                    int el4i=pairIndices.elementAt(k+1);

                }
            }
        }
    }
}
