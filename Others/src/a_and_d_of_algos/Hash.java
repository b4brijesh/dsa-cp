package a_and_d_of_algos;

import java.io.*;
import java.util.*;

class Hash{
    public Hashtable d = new Hashtable();
    public final int N = 1000000;
    public long[] a = new long[N];
    public int count = 0;
    Hash() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E://Downloads/algo1-programming_prob-2sum.txt"));
        String str;
        int k = 0;
        // store all numbers in an array as well as hash them into a hash table
        while((str = br.readLine()) != null){
            a[k] = Long.parseLong(str);
            d.put(a[k],a[k]);
            k++;
        }
        br.close();
    }
    public void find(int sum){
        if(sum%1000==0)
            System.out.println(sum);
        // for each element "ele" in the array
        for (int i=0; i<a.length; i++){
            // if (sum-ele) is present in the hash table, you have found a match
            if(d.containsKey(sum - a[i]) && a[i] != (sum - a[i])) {count++; break;}
        }
    }
    public static void main(String[] args) throws IOException {
        Hash h = new Hash();
        for (int i=-10000; i<=10000; i++) h.find(i);
        System.out.println(h.count);
    }
}