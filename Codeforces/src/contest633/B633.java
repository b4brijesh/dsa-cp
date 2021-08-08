package contest633;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 26-02-2016.
 */
public class B633 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int m=Integer.parseInt(br.readLine());
        int n=5*(m+1),count=0;
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=n;i>0;i--){
            int z=(int)(Math.floor(i/5)+Math.floor(i/25)+Math.floor(i/125)+Math.floor(i/625)+
                    Math.floor(i/3125)+Math.floor(i/15625)+Math.floor(i/78125)+Math.floor(i/390625));
            if(z<m)
                break;
            if(z==m){
                al.add(i);
                count++;
            }
        }
        System.out.println(count);
        Collections.sort(al);
        for(int i:al)
            System.out.print(i+" ");
    }
}
