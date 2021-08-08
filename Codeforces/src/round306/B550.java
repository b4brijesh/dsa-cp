package round306;

import java.io.*;
import java.util.*;
public class B550 {
    static Vector<Integer> v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n,l,r,x;
        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int i,j,k;
        v=new Vector<Integer>();
        for(i=1;i<=n;i++)
            v.add(Integer.parseInt(st.nextToken()));
        for(j=2;j<=n;j++){
            int arr[]=new int[j];
            ArrayIterator it=new ArrayIterator();
            for(k=0;k<j;k++){
                arr[k]=v.elementAt(k);
            }
        }
    }
    private static class ArrayIterator implements Iterator<Integer> {
        int i=0;
        public boolean hasNext() {
            return i<v.size();
        }
        public Integer next() {
            return v.elementAt(i++);
        }
    }
}
