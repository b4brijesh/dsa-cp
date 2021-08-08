package practice;

import java.io.*;
import java.util.*;
/**
 * Created by brijesh on 8/5/16.
 */
public class MissingNumbers {
    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(br.readLine());
        int[] brr=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++)
            brr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        Arrays.sort(brr);
        ArrayList<Integer> nums=new ArrayList<>();
        ArrayList<Integer> counts=new ArrayList<>();
        ArrayList<Integer> nums2=new ArrayList<>();
        ArrayList<Integer> counts2=new ArrayList<>();
        int i,count=1;
        for(i=1;i<n;i++){
            if(arr[i]==arr[i-1])
                count++;
            else{
                nums.add(arr[i-1]);
                counts.add(count);
                count=1;
            }
        }
        nums.add(arr[i-1]);
        counts.add(count);
        count=1;
        for(i=1;i<m;i++){
            if(brr[i]==brr[i-1])
                count++;
            else{
                nums2.add(brr[i-1]);
                counts2.add(count);
                count=1;
            }
        }
        nums2.add(brr[i-1]);
        counts2.add(count);
        for(i=0;i<nums.size();i++){
            System.out.println(nums.get(i)+" "+counts.get(i));
        }
        System.out.println();
        for(i=0;i<nums2.size();i++){
            System.out.println(nums2.get(i)+" "+counts2.get(i));
        }
        int index=0;
        for(i=0;i<nums.size();i++){
            Integer num=nums.get(i);
            while(!num.equals(nums2.get(index))){
                System.out.print(nums2.get(index)+" ");
                index++;
            }
            if(!counts.get(i).equals(counts2.get(index))){
                System.out.print(nums2.get(index)+" ");
            }
            index++;
        }
        while(index<nums2.size()){
            System.out.print(nums2.get(index)+" ");
            index++;
        }
        System.out.println();
    }
}
