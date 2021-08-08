package gudi;

import java.util.Scanner;

/**
 * Created by Brijesh on 17-12-2015.
 */
public class factorial{
    public static void main(String[] args){
        //System.out.println(object.fact(5));
        object obj1=new object();
        obj1.fact(5);
    }
}
class object {
    public void fact(int n){
        /*Scanner sc=new Scanner(System.in);
        System.out.println("type a no.");
        int n=sc.nextInt();*/
        int f=1;
        int k;
        for(k=1;k<=n;k++)
            f=f*k;
        System.out.println("the factorial is ="+f);
        //return f;
    }
}

