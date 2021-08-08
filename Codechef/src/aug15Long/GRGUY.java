package aug15Long;

import java.io.*;
public class GRGUY {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int i,j,k;
        for(i=1;i<=t;i++){
            boolean flag[]={true,true};
            String l1=br.readLine().trim();
            String l2=br.readLine().trim();
            String l3,l4,temp;
            int len=l1.length();
            int count=0;
            l3=l1;
            l4=l2;
            int arr[]=new int[2];
            for(k=1;k<=2;k++){
                count=0;
                for (j = 0; j < len; j++) {
                    if (l3.charAt(j) != '.') {
                        if (l4.charAt(j) != '.' && l4.charAt((j + 1) < len ? (j + 1) : (len - 1)) != '.') {
                            flag[k-1] = false;
                            break;
                        } else {
                            count++;
                            temp = l3;
                            l3 = l4;
                            l4 = temp;
                        }
                    }
                }
                arr[k-1]=count;
                l3=l2;
                l4=l1;
            }
            if(l1.charAt(0)=='#' && l2.charAt(0)=='#'){
                System.out.println("No");
            }
            else if(flag[0]==false && flag[1]==false)
                System.out.println("No");
            else {
                System.out.println("Yes");
                System.out.println(Math.min(arr[0],arr[1]));
            }
        }
    }
}
