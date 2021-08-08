package apr15Long;

import java.io.*;
import java.util.*;

public class CHEFLCM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int i, j, n, c,rem;
        long sum;
        for (i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine().trim());
            c = n;
            if (c != 1)
                sum = 1 + n;
            else
                sum = 1;
            j = 2;
            while (j < c) {
                c=n/j;
                if ((n-j*c) == 0) {
                    if (c == j)
                        sum = sum + j;
                    else
                        sum = sum + j + c;
                }
                j++;
            }
            System.out.println(sum);
        }
    }
}
