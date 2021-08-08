package classical;

import java.util.*;
public class LASTDIG {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        int a,c,sz;
        long b;
        while(t-->0) {
            a=sc.nextInt();
            b=sc.nextLong();
            Vector<Integer> v=new Vector<Integer>();
            c=a%10;
            while(v.indexOf(c)==-1){
                v.add(c);
                c=(c*a)%10;
            }
            sz=v.size();
            if (b==0)
                System.out.println(1);
            else System.out.println(v.elementAt((int)((b - 1) % sz)));
        }
    }
}