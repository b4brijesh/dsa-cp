package apr15Long;

import java.io.*;
import java.util.*;
public class FRMQ {
    //partial correct
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine().trim());
        int i,j,k,sm,gr,m,x,y,x2,y2;
        long s;
        A arr[]=new A[n];
        for(i=0;i<n;i++)
            arr[i]=new A(Integer.parseInt(st.nextToken().trim()),i);
        Arrays.sort(arr);
        st=new StringTokenizer(br.readLine().trim());
        m=Integer.parseInt(st.nextToken().trim());
        x=Integer.parseInt(st.nextToken().trim());
        y=Integer.parseInt(st.nextToken().trim());
        s=0;
        k=n-1;
        for(i=1;i<=m;i++){
            sm=Math.min(x,y);
            gr=Math.max(x,y);
            j=n-1;
            while(j>=0){
                if(arr[j].index>=sm && arr[j].index<=gr) {
                    s = s + arr[j].val;
                    break;
                }
                j--;
            }
            x=x+7;
            y=y+11;
            if(x>=k)
                x=x%k;
            //x=(x+7)-(x2*(n-1));
            if(y>=n)
                y=y%n;
            //y=(y+11)-(y2*n);
        }
        System.out.println(s);
    }
    static class A implements Comparable<A>,Comparator<A>{
        int val;
        int index;
        A(int v,int i){
            val=v;
            index=i;
        }
        @Override public int compareTo(A o) {
            return this.val-o.val;
        }
        @Override public int compare(A o1, A o2) {
            return o1.val-o2.val;
        }
    }
}
