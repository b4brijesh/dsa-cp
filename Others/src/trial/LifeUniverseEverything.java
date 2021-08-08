package trial;
import java.io.*;
public class LifeUniverseEverything {
	public static void main(String args[]) throws Exception{
		//BufferedReader br=new BufferedReader(new FileReader("C:/Users/Brijesh/Desktop/in.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input=br.readLine())!=null){
			int num=Integer.parseInt(input);
			if(num==42)
				break;
			else
				System.out.println(num);
		}
		br.close();
	}

}
