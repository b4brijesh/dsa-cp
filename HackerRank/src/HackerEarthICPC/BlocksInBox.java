package HackerEarthICPC;

import java.io.*;
import java.util.*;
public class BlocksInBox {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int i,j,len;
        Vector<Vector<Integer>> blocks=new Vector<Vector<Integer>>(n+1);
        for(i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            len=Integer.parseInt(st.nextToken());
            Vector<Integer> v=new Vector<Integer>();
            for(j=0;j<len;j++){
                v.addElement(Integer.parseInt(st.nextToken()));
            }
            blocks.addElement(v);
        }
        for(i=0;i<n;i++){
            System.out.println();
            for(j=0;j<blocks.elementAt(i).size();j++)
                System.out.print(blocks.elementAt(i));}
    }
}
