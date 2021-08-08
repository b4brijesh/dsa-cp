package practice;

import java.io.*;
import java.util.*;

/**
 * Created by brijesh on 9/25/16.
 */
public class C719 {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/B-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int t=Integer.parseInt(st.nextToken());
        String s=br.readLine().trim();
        char[] str=s.toCharArray();
        int dec_i=0;
        for(int i=0;i<n;i++){
            if(str[i]=='.') {dec_i=i;break;}
        }
        int init_pos=dec_i;
        for(int i=dec_i+1;i<n;i++){
            if(str[i]>52){
                init_pos=i;break;
            }
        }
        if (init_pos==dec_i){
            System.out.println(s);
        } else{
            int old_init_pos=-1,carry=0;
            while(t>0 && old_init_pos!=init_pos){
                int idx=init_pos-1;
                while(idx>dec_i && str[idx]==57){
                    str[idx]=48;
                    idx--;
                }
                if(idx==dec_i) carry=1;
                if(idx>dec_i) str[idx]++;
                old_init_pos=init_pos;
                if(str[idx]>52)
                    init_pos=idx;
                t--;
            }
            int carry2=0;
            if(carry==1){
                int index=dec_i-1;
                while (index>=0 && str[index]==57){
                    str[index]=48;
                    index--;
                }
                if(index<0) carry2=1;
                if(index>=0) str[index]++;
            }
            if(carry2==0){
                String fs=new String(str,0,old_init_pos);
                if(fs.charAt(fs.length()-1)=='.')
                    System.out.println(fs.substring(0,fs.length()-1));
                else System.out.println(fs.substring(0,fs.length()));
            } else{
                String fs=new String("1").concat(new String(str,0,dec_i));
                System.out.println(fs);
            }
        }
    }
}
