package classical;

import java.io.*;
import java.util.*;

public class NSTEPS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i,x,y;
        for(i=1;i<=cases;i++){
            st=new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            if(x==0 && y==0)
                System.out.println(0);
            else if(x==y){
                if(x%2==0)
                    System.out.println(x*2);
                else
                    System.out.println((x*2)-1);
            }
            else if((x-2)==y){
                if(x%2==0)
                    System.out.println((x*2)-2);
                else
                    System.out.println((x*2)-3);
            }
            else
                System.out.println("No Number");
        }
    }
}
