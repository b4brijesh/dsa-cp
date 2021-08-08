package jan16Long;

import java.io.*;
import java.util.*;

public class CHEFTMA {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t=Integer.parseInt(br.readLine());
        int i,j;
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            int[] A=new int[n];
            for(j=0;j<n;j++)
                A[j]=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            int[] B=new int[n];
            for(j=0;j<n;j++)
                B[j]=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            Vector<Integer> v=new Vector<Integer>();
            for(j=0;j<k;j++)
                v.add(Integer.parseInt(st.nextToken()));
            st=new StringTokenizer(br.readLine());
            for(j=0;j<m;j++)
                v.add(Integer.parseInt(st.nextToken()));
            int[] diff=new int[n];
            for(j=0;j<n;j++)
                diff[j]=A[j]-B[j];
            Arrays.sort(diff);
            Collections.sort(v);
            long sum=0;
            int res;
            for(j=n-1;j>=0;j--){
                res=Collections.binarySearch(v,diff[j]);
                if(res<-1){
                    res=-(res+1)-1;
                    sum+=(diff[j]-v.elementAt(res));
                    //v.removeElementAt(res);
                    v.subList(res,v.size()).clear();
                }
                else if(res==-1)
                    sum=sum+diff[j];
                else
                    v.removeElementAt(res);
            }
            System.out.println(sum);
        }
    }
}
