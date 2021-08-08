package classical;

import java.io.*;
import java.util.*;
public class STPAR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int i,m,n,c,flag;
        n=Integer.parseInt(br.readLine().trim());
        while(n!=0){
            flag=0;
            Vector<Integer> v=new Vector<Integer>();
            st=new StringTokenizer(br.readLine().trim());
            c=1;
            m=Integer.parseInt(st.nextToken().trim());
            do{
                if(m==c) {
                    c++;
                    m=Integer.parseInt(st.nextToken().trim());
                }
                else if (v.size()>0 && v.elementAt(v.size()-1)==c){
                    c++;
                    v.removeElementAt(v.size()-1);
                }
                else {
                    v.add(m);
                    m=Integer.parseInt(st.nextToken().trim());
                }
            }while(st.hasMoreTokens());
            for(i=1;i<v.size();i++){
                if(v.elementAt(i)>=v.elementAt(i-1)) {
                    flag = 1;
                    System.out.println("no");
                    break;
                }
            }
            if(flag==0)
                System.out.println("yes");
            n=Integer.parseInt(br.readLine().trim());
        }
    }
}
