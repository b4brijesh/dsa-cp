package may16Long;

import java.io.*;
import java.util.*;

/**
 * Created by Brijesh on 08-05-2016.
 */
public class CHBALLS {
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st;
        System.out.println(1);
        System.out.println("5 1 1 3 3 5");
        System.out.println("5 2 2 4 4 5");
        //int input=br.read();
        int input=sc.nextInt();
        if(input==0){
            System.out.println(2);
            System.out.println(5);
        }
        else if (input==2){
            System.out.println();
            System.out.println(1);
            System.out.println("2 1 1");
            System.out.println("2 3 3");
            //int inp=br.read();
            int inp=sc.nextInt();
            if(inp==2){
                System.out.println(2);
                System.out.println(1);
            }
            else if(inp==-2){
                System.out.println(2);
                System.out.println(3);
            }
            else System.out.println(3/0);
        }
        else if (input==-2){
            System.out.println();
            System.out.println(1);
            System.out.println("2 2 2");
            System.out.println("2 4 4");
            //int inp2=br.read();
            int inp2=sc.nextInt();
            if(inp2==2){
                System.out.println(2);
                System.out.println(2);
            }
            else if(inp2==-2){
                System.out.println(2);
                System.out.println(4);
            }
            else System.out.println(3/0);
        }
        else System.out.println(3/0);
    }
}
