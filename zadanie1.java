import java.util.*;
import java.io.*;

public class zadanie1{
	public static final void main(String[] args) throws Exception{
		String imiona = "imiona.txt", nazwiska = "nazwiska.txt";
		BufferedReader reader;


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
		ArrayList<String> allNames = new ArrayList<String>(), names = new ArrayList<String>(), allSecNames = new ArrayList<String>(), SecNames = new ArrayList<String>(), pesel = new ArrayList<String>();
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(imiona)));
		while((line = reader.readLine()) != null)
			allNames.add(line);
		reader.close();

		reader = new BufferedReader(new InputStreamReader(new FileInputStream(nazwiska)));
		while((line = reader.readLine()) != null){
			allSecNames.add(line.split(" ")[1]);
		}
		reader.close();


		for(int i = 0; i < n; i++){
			int x = generator.nextInt(allNames.size()), y, z;
			while(allNames.get(x).toCharArray()[allNames.get(x).length() - 1] != 'a' || allNames.get(x).equals("Jarema"))
				x = generator.nextInt(allNames.size());
			names.add(allNames.get(x));
			x = generator.nextInt(allSecNames.size());
			SecNames.add(allSecNames.get(x));
			x = generator.nextInt(77) + 23;
			y = generator.nextInt(12) + 1;
			z = generator.nextInt(31) + 1;
			pesel.add(Integer.toString(x) + ((y<10)? ("0" + y): y) + ((z<10)? ("0" + z): z) + "12345");
		}

		BufferedWriter fwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("szpieg.txt")));

		for(int i = 0; i < n; i++){
			fwriter.write(names.get(i) + " " + SecNames.get(i) + " " + pesel.get(i));
			fwriter.newLine();
		}
		fwriter.close();
	}
}