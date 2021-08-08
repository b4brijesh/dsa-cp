package moodys16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by brijesh on 10/2/16.
 */
public class Q3 {
    static double e_07=0.0000001;
    static int e09$7=1000000007;
    static final String[] EMPTY_ARRAY = new String[0];
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/A-large.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-small-practice.in"));
        //BufferedReader br = new BufferedReader(new FileReader("/home/brijesh/Downloads/C-large-practice.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            StringBuffer sbf=new StringBuffer(br.readLine().trim());
            boolean valid=true;
            for(int j=0;j<sbf.length();j++){
                if(sbf.charAt(j)=='*'){
                    if(j-1<0 || sbf.charAt(j-1)=='*'){
                        valid=false;break;
                    }
                    if(j+1>sbf.length()-1){
                        valid=false;break;
                    }
                    if(sbf.charAt(j+1)=='*'){
                        j++;
                        if(j+1>sbf.length()-1){
                            valid=false;break;
                        }
                        if(sbf.charAt(j+1)=='*'){
                            valid=false;break;
                        }
                    }
                }
            }
            if(!valid){
                System.out.println("Syntax Error");
                continue;
            }
            ArrayList<String> arr=new ArrayList<>();
            String str="";
            for(int j=0;j<sbf.length();j++){
                if(sbf.charAt(j)!='*')
                    str+=sbf.charAt(j);
                else {
                    arr.add(str);
                    if(sbf.charAt(j+1)=='*'){
                        j++;
                        arr.add("^");
                    } else arr.add("*");
                    str="";
                }
            }
            arr.add(str);
            //System.out.println(arr.toString());
            for(int j=0;j<arr.size();j++){
                if(arr.get(j).equals("^")){
                    long a=Long.parseLong(arr.get(j-1))%e09$7;
                    long b=Long.parseLong(arr.get(j+1));
                    long val=(exp_by_squaring(a,b)%e09$7);
                    arr.remove(j-1);
                    arr.remove(j-1);
                    arr.remove(j-1);
                    arr.add(j-1,String.valueOf(val));
                    j--;
                }
            }
            //System.out.println(arr.toString());
            for(int j=0;j<arr.size();j++){
                if(arr.get(j).equals("*")){
                    long a=Long.parseLong(arr.get(j-1))%e09$7;
                    long b=Long.parseLong(arr.get(j+1))%e09$7;
                    long val=(a*b)%e09$7;
                    arr.remove(j-1);
                    arr.remove(j-1);
                    arr.remove(j-1);
                    arr.add(j-1,String.valueOf(val));
                    j--;
                }
            }
            System.out.println(Long.parseLong(arr.get(0))%e09$7);
        }
    }

    private static long exp_by_squaring(long a, long b) {
        a=a%e09$7;
        if(b==0) return 1;
        long y=1;
        while(b>1) {
            if(b%2==0) a=(a*a)%e09$7;
            else {y=(y*a)%e09$7;a=(a*a)%e09$7;}
            b/=2;
        }
        return (y*a)%e09$7;
    }
}
