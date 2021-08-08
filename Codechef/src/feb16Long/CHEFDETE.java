package feb16Long;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by Brijesh on 05-02-2016.
 */
public class CHEFDETE {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n+1];
        //Vector<Integer> v=new Vector<>();
        int[] ar2=new int[n+1];
        for(int i=0;i<=n;i++)
            ar2[i]=i;
        st=new StringTokenizer(br.readLine());
        for (int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            //v.removeElement(arr[i]);
            ar2[arr[i]]=-1;
        }
        for(int i=0;i<=n;i++)
            if(ar2[i]!=-1)
                System.out.print(ar2[i]+" ");
        /*for(int i=0;i<v.size();i++)
            System.out.print(v.elementAt(i)+" ");*/
    }
}
