package cookOff64;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 10/11/16.
 */
public class SEALINE {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-practice.in"));
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for (int i=1;i<=t;i++){
            int n=Integer.parseInt(br.readLine());
            if(n==1){
                br.readLine();
                System.out.println(0);
                continue;
            }
            int[] arr=new int[n];
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++)
                arr[j]=Integer.parseInt(st.nextToken());
            LinkedList<Integer> ll=new LinkedList<>();
            ll.add(1);
            int lsize=1,sum=0;
            for (int j=1;j<n;j++){
                if (arr[j]==0){
                    lsize++;
                    ll.addFirst(j+1);
                    continue;
                }
                Iterator<Integer> it=ll.iterator();
                int idx=0;
                while (it.hasNext()){
                    int num=it.next();
                    if (num==arr[j]){
                        //System.out.println((idx+1)+" "+(lsize-idx-1));
                        if(idx+1>lsize-idx-1){
                            sum+=(lsize-idx-1);
                        } else sum+=(idx+1);
                        lsize++;
                        ll.add(idx+1,j+1);
                        break;
                    } else idx++;
                }
            }
            System.out.println(sum);
        }

        System.exit(0);
    }
}
