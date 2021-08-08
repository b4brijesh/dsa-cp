package apac17B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by Brijesh on 28-08-2016.
 */
public class SherlockAndWatsonGymSecrets {
    public static void main (String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("C://Users/Brijesh/Documents/SCC.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("F://A-small-attempt0.in"));
        //BufferedReader br = new BufferedReader(new FileReader("F://A-large.in"));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            int N=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());
            ArrayList<Integer> list1=new ArrayList<>();
            ArrayList<Integer> list2=new ArrayList<>();
            int j=1,power=(int)Math.pow(j,A),old=0;
            while(j<=N && power!=old){
                list1.add(power);
                //System.out.print(power+" ");
                old=power;
                j++;
                power=(int)Math.pow(j,A);
            }
            j=1;power=(int)Math.pow(j,B);old=0;
            while(j<=N && power!=old){
                list2.add(power);
                //System.out.print(power+" ");
                old=power;
                j++;
                power=(int)Math.pow(j,B);
            }
            long sum=0;
            for(int k=0;k<list1.size();k++){
                int num1=list1.get(k);
                //System.out.print(num1+" ");
                int s=1;
                for(int r=K;;r=K*(++s)){
                    int num2=r-num1;
                    //System.out.println(num2);
                    if(num2>0){
                        int index=Collections.binarySearch(list2,num2);
                        if((-index-1)==list2.size())
                            break;
                        if(index>=0 && list2.get(index).equals(num2) && index!=k)
                            sum++;
                    }
                    //System.out.println("s="+sum);
                    sum=sum%1000000007;
                }
                sum=sum%1000000007;
            }
            System.out.println("Case #"+i+": "+sum);
        }
    }
}
