package CROC2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 18-03-2016.
 */
public class B644 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        ArrayList<Query> arr=new ArrayList<>();
        for(int i=1;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int t=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            Query q=new Query(t,d);
            long time=0;
            if(arr.isEmpty() || arr.size()<b){
                arr.add(q);
            }
            else{
            }
        }
    }
}
class Query{
    int ti,di,fi=-1;
    Query(int a,int b){ti=a;di=b;}
}
