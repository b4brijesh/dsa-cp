package contest570;

import java.io.*;
import java.util.*;
public class C570 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        char[] str=br.readLine().trim().toCharArray();
        int i,count=0,begin=0;
        boolean started=false;
        for(i=0;i<n;i++){
            if(!started && str[i]=='.'){
                started=true;
                begin=i;
            }
            else if(started && str[i]!='.'){
                started=false;
                count+=i-begin-1;
            }
            else if(started && i==n-1)
                count+=i-begin;
        }
        //System.out.println(count);
        for(i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int index=Integer.parseInt(st.nextToken())-1;
            char ch=st.nextToken().trim().charAt(0);
            if(ch!='.' && str[index]=='.'){
                if(index==0 && index+1<n){
                    if(str[index+1]=='.')
                        count--;
                }
                else if(index==n-1 && index-1>=0){
                    if(str[index-1]=='.')
                        count--;
                }
                else if(index-1>=0 && index+1<n && (str[index-1]=='.' || str[index+1]=='.')){
                    if(str[index-1]=='.' && str[index+1]=='.')
                        count-=2;
                    else
                        count--;
                }
                str[index]=ch;
            }
            if(ch=='.' && str[index]!='.'){
                if(index==0 && index+1<n){
                    if(str[index+1]=='.')
                        count++;
                }
                else if(index==n-1 && index-1>=0){
                    if(str[index-1]=='.')
                        count++;
                }
                else if(index-1>=0 && index+1<n && (str[index-1]=='.' || str[index+1]=='.')){
                    if(str[index-1]=='.' && str[index+1]=='.')
                        count+=2;
                    else
                        count++;
                }
                str[index]=ch;
            }
            System.out.println(count);
        }
    }
}
