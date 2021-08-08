package june15Long;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class CHPLGNS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i,j,k,n,m,x,y;
        BigInteger dis,max;
        class Polygon implements Comparator<Polygon>,Comparable<Polygon>{
            int ind;
            BigInteger val;
            public int compareTo(Polygon o) {
                return this.val.compareTo(o.val);
            }
            public int compare(Polygon o1, Polygon o2) {
                return o1.compareTo(o2);
            }
        }
        for(i=1;i<=t;i++){
            n=Integer.parseInt(br.readLine().trim());
            Polygon pol[]=new Polygon[n];
            int pol3[]=new int[n];
            for(j=0;j<n;j++){
                max=BigInteger.ZERO;
                m=Integer.parseInt(br.readLine().trim());
                st=new StringTokenizer(br.readLine().trim());
                k=0;
                do{
                    x=Integer.parseInt(st.nextToken().trim());
                    y=Integer.parseInt(st.nextToken().trim());
                    dis=BigInteger.valueOf(((long) x * x) + (y * y));
                    max=dis.max(max);
                    k++;
                }while(k<m);
                pol[j]=new Polygon();
                pol[j].val=max;
                pol[j].ind=j;
            }
            Arrays.sort(pol);
            for(j=0;j<n;j++)
                pol3[pol[j].ind]=j;
            for(j=0;j<n-1;j++)
                System.out.print(pol3[j]+" ");
            System.out.println(pol3[n-1]);
        }
    }
}
