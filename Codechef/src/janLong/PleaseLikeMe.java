package janLong;
import java.io.*;
import java.util.*;
public class PleaseLikeMe {
	public static void main(String[] args) throws Exception {
		//BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in2.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		int l,d,s,c,dayEnd;
		for(int i=1;i<=cases;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			l=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			s=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			dayEnd=s;
			for(int j=1;j<d;j++) {
				if(dayEnd>l)
					break;
				else
					dayEnd=dayEnd+(dayEnd*c);
			}
			if(dayEnd<l)
				System.out.println("DEAD AND ROTTING");
			else
				System.out.println("ALIVE AND KICKING");
		}
		br.close();
	}
}
