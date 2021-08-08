package contest754;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 06-01-2017.
 */
public class C754 {
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    static String d_loc="/home/brijesh/Downloads/";
    public static void main (String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new FileReader(d_loc+"A-small-attempt0.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine().trim());
        outer:for (int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine().trim());
            HashMap<String,Boolean> map=new HashMap<>();
            st=new StringTokenizer(br.readLine().trim());
            for (int j=0;j<n;j++){
                map.put(st.nextToken().trim(),false);
            }
            int m=Integer.parseInt(br.readLine().trim());
            String[] msgs=new String[m];
            for (int j=0;j<m;j++){
                msgs[j]=br.readLine().trim();
            }
            String[] senders=new String[m];
            for (int j=0;j<m;j++){
                senders[j]=msgs[j].substring(0,msgs[j].indexOf(':'));
            }
            String[] mess=new String[m];
            for (int j=0;j<m;j++){
                mess[j]=msgs[j].substring(msgs[j].indexOf(':')+1,msgs[j].length());
            }
            for (int j=0;j<m;j++){
                if (senders[j].equals("?")){
                    if(j-1>=0)map.put(senders[j-1],true);
                    if(j+1<m) map.put(senders[j+1],true);
                    String name="";
                    for (int k=0;k<mess[j].length();k++){
                        int l=mess[j].charAt(k);
                        if((l>=65 && l<=90) || (l>=97 && l<=122) || (l>=48 && l<=57))
                            name+=mess[j].charAt(k);
                        else {
                            if (map.containsKey(name)) map.put(name,true);
                            name="";
                        }
                    }
                    if (map.containsKey(name)) map.put(name,true);
                    boolean f=false;
                    for (String key:map.keySet()){
                        if (!map.get(key)) {
                            senders[j]=key;
                            f=true;
                            break;
                        }
                    }
                    if (!f){
                        System.out.println("Impossible");
                        continue outer;
                    }
                    for (String key:map.keySet()){
                        map.put(key,false);
                    }
                }
            }
            for (int j=0;j<m;j++)
                System.out.println(senders[j]+":"+mess[j]);
        }

        System.exit(0);
    }
}
