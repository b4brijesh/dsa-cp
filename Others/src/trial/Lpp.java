package trial;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class Lpp {
	
		public static void main(String[] args) throws FileNotFoundException {
	 
			Scanner sc = new Scanner(new FileReader("C:/Users/Brijesh/Desktop/ff.txt"));
	 
			int N = Integer.parseInt(sc.nextLine());
			int S =N*50;
			boolean[] isPrime = new boolean[S];
	 
			int l = 0;
			int number = 2;
	 
			for(int i=2;i<S;i++){
				isPrime[i]=true;
			}
	 
			for (int i = 2; i < S; i++) {
	 
				if(isPrime[i]){
	 
					for(int j=2;j<S/i;j++){
						isPrime[i*j]=false;
					}
					int x = totalOfDigits(i);
					if (isPrime[x]) {
						l++;
					}
				}
				if (l == N) {
					number = i;
					break;
				}
	 
			}
			System.out.println(number);
	 sc.close();
		}
	 
		private static int totalOfDigits(int i) {
			int total = 0;
			while (i / 10 != 0) {
				total = total + i % 10;
				i = i / 10;
			}
			total = total + i;
			return total;
		}

}
