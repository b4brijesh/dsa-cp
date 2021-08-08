package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by brijesh on 7/24/16.
 */
public class A277 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> employees=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int numLangs=Integer.parseInt(st.nextToken());
            ArrayList<Integer> langs=new ArrayList<>();
            for(int j=0;j<numLangs;j++){
                langs.add(j,Integer.parseInt(st.nextToken()));
            }
            Collections.sort(langs);
            employees.add(i,langs);
        }
        Collections.sort(employees, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> arl1, ArrayList<Integer> arl2) {
                return arl1.get(0)-arl2.get(0);
            }
        });

    }
}
