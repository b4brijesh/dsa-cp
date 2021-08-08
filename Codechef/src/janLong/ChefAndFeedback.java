package janLong;
import java.io.*;
import java.util.*;
public class ChefAndFeedback {
	public static void main(String[] args) throws IOException {
		//BufferedReader bf=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in.txt"));
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(bf.readLine());
		String num,feedB;
		StringTokenizer st;
		int len,j,i;
		for(j=1;j<=cases;j++) {
			feedB="Bad";
			st=new StringTokenizer(bf.readLine());
			num=st.nextToken().toString();
			len=num.length();
			for(i=0;i<(len-2);i++) {
				if((num.charAt(i)==num.charAt(i+2)) && (num.charAt(i)!=num.charAt(i+1))) {
					feedB="Good";
					break;
				}
			}
			System.out.println(feedB);
		}
		bf.close();
	}
}
