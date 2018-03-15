import java.util.*;
import java.io.*;

public class zadanie1{
	public static final void main(String[] args) throws Exception{
		String imiona = "imiona.txt", nazwiska = "nazwiska.txt";
		BufferedReader reader;
		BufferedWriter fwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("szpieg.txt")));


		System.out.print("Podaj n: ");
		reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		while(n<1 || n >100){
			System.out.print("n musi byc w zakresie 1-100: ");
			n = Integer.parseInt(reader.readLine());
		}
		reader.close();


		Random generator = new Random();
		String line;
		ArrayList<String> allNames = new ArrayList<String>(), names = new ArrayList<String>();
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(imiona)));
		while((line = reader.readLine()) != null)
			allNames.add(line);
		reader.close();


		for(int i = 0; i < n; i++){
			int x = generator.nextInt(allNames.size());
			names.add(allNames.get(x));
		}
	}
}