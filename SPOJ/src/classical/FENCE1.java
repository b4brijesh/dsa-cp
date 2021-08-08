package classical;

import java.io.*;
public class FENCE1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l=Integer.parseInt(br.readLine());
        while(l>0) {
            System.out.printf("%.2f", ((double)(l * l) / 6.2832));
            System.out.println();
            l=Integer.parseInt(br.readLine());
        }
    }
}
