package apr15Long;

import java.io.*;
import java.util.*;
public class CARLOS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int i,j,m,k,n,a;
        int word[],x[],y[];
        StringTokenizer st;
        for(i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            m=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());
            n=Integer.parseInt(st.nextToken());
            x=new int[k+1];
            y=new int[k+1];
            word=new int[n+1];
            Vector<Vector<Integer>> list=new Vector<Vector<Integer>>(m+1);
            for(j=0;j<=m;j++)
                list.add(new Vector<Integer>());
            for(j=1;j<=k;j++){
                st=new StringTokenizer(br.readLine());
                x[j]=Integer.parseInt(st.nextToken());
                y[j]=Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(br.readLine());
            for(j=1;j<=n;j++)
                word[j]=Integer.parseInt(st.nextToken());
            for(j=1;j<=m;j++){
                exhaust(j, j, x, y, list.elementAt(j));
                Collections.sort(list.elementAt(j));
                /*System.out.println(j);
                for(a=0;a<list.elementAt(j).size();a++)
                    System.out.print(list.elementAt(j).elementAt(a)+" ");
                System.out.println();*/
            }
        }
    }
    static void exhaust(int index,int index2, int x[], int y[], Vector<Integer> v){
        Stack<Integer> stk=new Stack<Integer>();
        int i,j,k=x.length-1;
        for(i=1;i<=k;i++){
            if(x[i]==index){
                if(y[i]!= index2 && v.indexOf(y[i])==-1) {
                    v.add(y[i]);
                    stk.push(y[i]);
                }
            }
            if(y[i]==index){
                if(x[i]!=index2 && v.indexOf(x[i])==-1) {
                    v.add(x[i]);
                    stk.push(x[i]);
                }
            }
            while(!stk.empty()){
                j=stk.pop();
                exhaust(j,index2,x,y,v);
            }
        }
    }
}
