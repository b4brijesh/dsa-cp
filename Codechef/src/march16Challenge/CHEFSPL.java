package march16Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 07-03-2016.
 */
public class CHEFSPL {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner br=new Scanner(System.in);
        StringTokenizer st;
        int d=Integer.parseInt(br.readLine().trim());
        //int d=br.nextInt();
        String s1,s2;
        char[] c1,c2;
        int flag,ind1,ind2,count1,count2;
        for(int i=1;i<=d;i++){
            //String s=br.next().trim();
            String s=br.readLine().trim();
            if(s.length()==1){
                System.out.println("NO");
                continue;
            }
            if(s.length()%2==0){
                s1=s.substring(0,s.length()/2);
                s2=s.substring(s.length()/2,s.length());
                c1=s1.toCharArray();
                c2=s2.toCharArray();
                flag=0;
                for(int j=0;j<c1.length;j++){
                    if(c1[j]!=c2[j]){
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                    System.out.println("NO");
                else System.out.println("YES");
                /*if(s1.equals(s2))
                    System.out.println("YES");
                else System.out.println("NO");*/
            }
            else {
                s1=s.substring(0,s.length()/2);
                s2=s.substring(s.length()/2+1,s.length());
                c1=s1.toCharArray();
                c2=s2.toCharArray();
                flag=0;
                for(int j=0;j<c1.length;j++){
                    if(c1[j]!=c2[j]){
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    System.out.println("YES");
                    continue;
                }
                /*if(s1.equals(s2)){
                    System.out.println("YES");
                    continue;
                }*/
                s1=s.substring(0,s.length()/2+1);
                c1=s1.toCharArray();
                ind1=0;count1=0;count2=0;ind2=0;
                for(int j=0;j<c1.length;j++){
                    if(c1[j]==c2[ind1])
                        ind1++;
                    else {
                        count1++;
                        continue;
                    }
                }
                if(count1==1){
                    System.out.println("YES");
                    continue;
                }
                s1=s.substring(0,s.length()/2);
                s2=s.substring(s.length()/2,s.length());
                c1=s1.toCharArray();
                c2=s2.toCharArray();
                for(int j=0;j<c2.length;j++){
                    if(c1[ind2]==c2[j])
                        ind2++;
                    else {
                        count2++;
                        continue;
                    }
                }
                if(count2==1){
                    System.out.println("YES");
                    continue;
                }
                System.out.println("NO");
            }
        }
    }
}
