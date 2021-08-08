package snapdeal15;

import java.io.*;
import java.util.*;

public class KthLargest {
    public static void main (String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int i,j,type,x,k;
        Vector<Integer> v=new Vector<Integer>();
        for(i=0;i<n;i++)
            v.add(Integer.parseInt(st.nextToken()));
        for(i=1;i<=q;i++){
            st=new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());
            type=Integer.parseInt(st.nextToken());
            int index1=0,index2=0;
            for(j=1;j<n;j++){
                if(v.elementAt(j)<x)
                    index1++;
                else break;
            }
            if(index1==x)
                index2=index1;
            else index2=index1+1;
            if(type==0){
                if(index1+k>=v.size())
                    System.out.println(-1);
                else
                    System.out.println(v.elementAt(index1+k));
            }
            else {
                if(index2<k)
                    System.out.println(-1);
                else System.out.println(v.elementAt(index2-k));
            }
        }
    }
}
