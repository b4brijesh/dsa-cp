package classical;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.Scanner;
//import java.util.StringTokenizer;

/**
 * Created by Brijesh on 28-02-2016.
 */
public class ALIEN {
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        //StringTokenizer st;
        //int t=Integer.parseInt(br.readLine());
        int t=sc.nextInt();
        for(int i=1;i<=t;i++){
            //st=new StringTokenizer(br.readLine());
            //int n=Integer.parseInt(st.nextToken());
            int n=sc.nextInt();
            //int max=Integer.parseInt(st.nextToken());
            int max=sc.nextInt();
            //st=new StringTokenizer(br.readLine());
            int[] arr=new int[n];
            for(int j=0;j<n;j++)
                arr[j]=sc.nextInt();
                //arr[j]=Integer.parseInt(st.nextToken());
            int x=0,y=0,sum=0,max_st=0,min_p=0,stat=0;
            while(y<n){
                sum+=arr[y];
                stat++;
                if(sum>max){
                    if((stat-1)>max_st){
                        max_st=stat-1;
                        min_p=sum-arr[y];
                    }
                    if((stat-1)==max_st && min_p>(sum-arr[y])){
                        min_p=sum-arr[y];
                    }
                }
                while(sum>max){
                    sum-=arr[x];
                    x++;
                    stat--;
                }
                y++;
            }
            System.out.println(min_p+" "+max_st);
        }
    }
}
