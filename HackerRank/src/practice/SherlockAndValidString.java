package practice;

/**
 * Created by Brijesh on 01-08-2016.
 */
import java.io.*;
import java.util.*;

public class SherlockAndValidString {

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s=br.readLine();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        ArrayList<Integer> counts=new ArrayList<>();
        int count=1;
        for(int i=1;i<sorted.length();i++){
            if(sorted.charAt(i)==sorted.charAt(i-1))
                count++;
            else {
                counts.add(count);
                count=1;
            }
        }
        counts.add(count);
        Collections.sort(counts);
        for(int i=0;i<counts.size();i++)
            System.out.print(counts.get(i)+" ");
        System.out.println();
        boolean poss=true;
        if(counts.size()>1 && counts.get(0)==1 && counts.get(1)!=1){
            for(int i=2;i<counts.size();i++){
                if(counts.get(i)!=counts.get(i-1)){
                    poss=false;
                    System.out.println("3NO");
                    return;
                }
            }
            if(poss) System.out.println("YES");
            return;
        }
        for(int i=1;i<counts.size()-1;i++){
            if(counts.get(i)!=counts.get(i-1)){
                System.out.println(counts.get(i)+" "+counts.get(i-1));
                System.out.println(counts.get(i)==counts.get(i-1));
                System.out.println(counts.get(i).equals(counts.get(i-1)));
                System.out.println((Integer)4000==(Integer)4000);
                poss=false;
                System.out.println("2NO");
                break;
            }
        }
        if(poss){
            if(counts.size()<=1)
                System.out.println("YES");
            else {
                int count1=counts.get(counts.size()-1);
                int count2=counts.get(counts.size()-2);
                if((count1-count2)>1)
                    System.out.println("1NO");
                else
                    System.out.println("YES");
            }
        }
    }
}