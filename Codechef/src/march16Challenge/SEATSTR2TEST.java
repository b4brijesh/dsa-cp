package march16Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Brijesh on 12-03-2016.
 */
public class SEATSTR2TEST {
    static String s="mmmmmmmnnn";
    static char[] str=s.toCharArray();
    static Vector<String> v=new Vector<String>();
    static Set<String> set=new HashSet<String>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long[] fact=new long[11];
        fact[0]=1;
        for(int i=1;i<=10;i++)
            fact[i]=(fact[i-1]*(i%1000000007))%1000000007;
        permute(0,s.length()-1);
        Iterator it=set.iterator();
        while (it.hasNext()){
            v.add((String)it.next());
        }
        int count=0;
        for(int i=0;i<v.size();i++){
            for(int j=0;j<v.size();j++){
                int sw=swaps(v.elementAt(i),v.elementAt(j));
                if(sw>2)
                    count++;
            }
        }
        System.out.println(count);
    }
    static int swaps(String a,String b){
        String d1="",d2="";
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                d1+=a.charAt(i);
                d2+=b.charAt(i);
            }
        }
        if(d1.length()>4){
            return 4;
        }
        else{
            //System.out.println(d1+" "+d2);
            if(d1.length()==4){
                int ind1=d2.indexOf(d1.charAt(0));
                int ind2=d1.indexOf(d2.charAt(0));
                if(ind1==ind2)
                    return 1;
                else return 4;
            }
            else if(d1.length()==3){
                if(d1.charAt(0)==d2.charAt(1)&&d1.charAt(1)==d2.charAt(2))
                    return 1;
                else if(d1.charAt(0)==d2.charAt(2)&&d1.charAt(1)==d2.charAt(0))
                    return 1;
                else return 4;
            }
            else if(d1.length()==2){
                if(d1.charAt(0)==d2.charAt(1))
                    return 1;
                else return 4;
            }
            else if(d1.length()==0)
                return 1;
            System.out.println("x "+d1+" "+d2);
        }
        return 4;
    }
    static void permute(int l,int r){
        if(l==r){
            String sm="";
            for(int i=0;i<str.length;i++)
                sm+=str[i];
            //v.add(sm);
            set.add(sm);
        }
        else{
            for(int i=l;i<=r;i++){
                swap(l,i);
                permute(l+1,r);
                swap(l,i);
            }
        }
    }
    static void swap(int a,int b){
        char temp=str[a];
        str[a]=str[b];
        str[b]=temp;
    }
}
