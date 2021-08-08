package apac16D;


import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 9/22/16.
 */
public class C {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            System.out.println("Case #"+i+": ");
            int n=Integer.parseInt(br.readLine());
            char[][] address=new char[n][32];
            int[] P=new int[n];
            for(int j=0;j<n;j++){
                ss=br.readLine().split("\\p{Punct}");
                P[j]=Integer.parseInt(ss[4]);
                String s1=String.format("%8s",Integer.toBinaryString(Integer.parseInt(ss[0]))).replace(' ','0');
                String s2=String.format("%8s",Integer.toBinaryString(Integer.parseInt(ss[1]))).replace(' ','0');
                String s3=String.format("%8s",Integer.toBinaryString(Integer.parseInt(ss[2]))).replace(' ','0');
                String s4=String.format("%8s",Integer.toBinaryString(Integer.parseInt(ss[3]))).replace(' ','0');
                String s5=s1.concat(s2).concat(s3).concat(s4);
                address[j]=s5.toCharArray();
                //System.out.println(s5);
            }
            TreeMap<String,Integer> subnet=new TreeMap<>();
            for(int j=0;j<n;j++){
                Arrays.fill(address[j],P[j],32,'0');
                String s=String.copyValueOf(address[j]);
                if(subnet.containsKey(s)){
                    subnet.put(s,Math.min(subnet.get(s),P[j]));
                }
                else subnet.put(s,P[j]);
            }
            Set<String> key_set=subnet.keySet();
            for(String key:key_set){
                int a1=Integer.parseInt(key.substring(0,8),2);
                int a2=Integer.parseInt(key.substring(8,16),2);
                int a3=Integer.parseInt(key.substring(16,24),2);
                int a4=Integer.parseInt(key.substring(24,32),2);
                int p=subnet.get(key);
                System.out.println(a1+"."+a2+"."+a3+"."+a4+"/"+p);
            }
        }
    }
}
