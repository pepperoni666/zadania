import java.util.*;
import java.io.*;

public class Rysunek{
 	public static TreeSet<Figura> figury;
 	public static BufferedReader reader;

	public static final void main(String[] args) throws Exception {
		reader = new BufferedReader(new InputStreamReader(System.in));
		figury = new TreeSet<Figura>();
		while(true){
			System.out.println("\n\"exit\" - wychodze; \"wypisz\" - wypisuje wszystkie figury\n\"przecina\" - wypisuje przecinajace sie ze soba figury;");
			System.out.print("Podaj figure po numerze: 1) Kolo; 2) Kwadrat; 3) Prostokat\n>");
			String s = reader.readLine();
			Figura f;
			if(s.equals("exit"))
				break;
			switch(s){
				case "1":
					f = podajKolo();
					break;
				case "2":
					f = podajKwadrat();
					break;
				case "3":
					f = podajProstokat();
					break;
				case "wypisz":
					System.out.println();
					for(Figura k: figury)
						System.out.println(k);
					continue;
				case "przecina":
					System.out.println();
					przecina();
					continue;
				default:
					System.out.println("Niepoprawne dane wejsciowe.");
					continue;
			}
			if(f==null)
				continue;
			try{
				if(figury.contains(f))
					throw new Exception();
			}
			catch(Exception e){
				System.out.println("Figura juz istnieje.");
				continue;
			}
			figury.add(f);
		}
		for(Figura k: figury)
			System.out.println(k);
	} 

	public static Kolo podajKolo(){
		System.out.print("Podaj: (promien, x, y)\n>");
		String s;
		try{
			s = reader.readLine();
		}
		catch(IOException e){
			return null;
		}
		String[] arr = s.split(",");
		double p, x, y;
		try{
			p = Double.parseDouble(arr[0]);
			x = Double.parseDouble(arr[1]);
			y = Double.parseDouble(arr[2]);

			if(p <= 0)
				throw new Exception();
		}
		catch(NumberFormatException e){
			System.out.println("Podano litere zamiast liczby.");
			return null;
		}
		catch(Exception e){
			System.out.println("Promien nie moze byc ujemny lub 0.");
			return null;
		}
		return new Kolo(p, x, y);
	}

	public static Kwadrat podajKwadrat(){
		System.out.print("Podaj: (bok, x, y)\n>");
		String s;
		try{
			s = reader.readLine();
		}
		catch(IOException e){
			return null;
		}
		String[] arr = s.split(",");
		double b, x, y;
		try{
			b = Double.parseDouble(arr[0]);
			x = Double.parseDouble(arr[1]);
			y = Double.parseDouble(arr[2]);

			if(b <= 0)
				throw new Exception();
		}
		catch(NumberFormatException e){
			System.out.println("Podano litere zamiast liczby.");
			return null;
		}
		catch(Exception e){
			System.out.println("Bok nie moze byc ujemny lub 0.");
			return null;
		}
		return new Kwadrat(b, x, y);
	}

	public static Prostokat podajProstokat(){
		System.out.print("Podaj: (bokA, bokB, x, y)\n>");
		String s;
		try{
			s = reader.readLine();
		}
		catch(IOException e){
			return null;
		}
		String[] arr = s.split(",");
		double a, b, x, y;
		try{
			a = Double.parseDouble(arr[0]);
			b = Double.parseDouble(arr[1]);
			x = Double.parseDouble(arr[2]);
			y = Double.parseDouble(arr[3]);

			if(a <= 0 || b <= 0)
				throw new Exception();
		}
		catch(NumberFormatException e){
			System.out.println("Podano litere zamiast liczby.");
			return null;
		}
		catch(Exception e){
			System.out.println("Boki nie moga byc ujemne lub 0.");
			return null;
		}
		return new Prostokat(a, b, x, y);
	}

	public static void przecina(){
		System.out.println();
		for(Figura x: figury){
			for(Figura y: figury){
				if(y==x)
					continue;
				if(y instanceof Kolo){
					if(x.przecina((Kolo)y)){
						if(x instanceof Kolo)
							((Kolo)x).prz.add(y);
						else if(x instanceof Kwadrat)
							((Kwadrat)x).prz.add(y);
						else if(x instanceof Prostokat)
							((Prostokat)x).prz.add(y);
					}
				}
				else if(y instanceof Kwadrat){
					if(x.przecina((Kwadrat)y)){
						if(x instanceof Kolo)
							((Kolo)x).prz.add(y);
						else if(x instanceof Kwadrat)
							((Kwadrat)x).prz.add(y);
						else if(x instanceof Prostokat)
							((Prostokat)x).prz.add(y);
					}
				}
				else if(y instanceof Prostokat){
					if(x.przecina((Prostokat)y)){
						if(x instanceof Kolo)
							((Kolo)x).prz.add(y);
						else if(x instanceof Kwadrat)
							((Kwadrat)x).prz.add(y);
						else if(x instanceof Prostokat)
							((Prostokat)x).prz.add(y);
					}
				}
			}
		}
		for(Figura x: figury){
			if(x instanceof Kolo)
				if(((Kolo)x).prz.size() == 0)
					continue;
			else if(x instanceof Kwadrat)
				if(((Kwadrat)x).prz.size() == 0)
					continue;
			else if(x instanceof Prostokat)
				if(((Prostokat)x).prz.size() == 0)
					continue;

			System.out.println(x + " przecina sie z:");
			if(x instanceof Kolo)
				for(Figura y: ((Kolo)x).prz)
					System.out.println(y);
			else if(x instanceof Kwadrat)
				for(Figura y: ((Kwadrat)x).prz)
					System.out.println(y);
			else if(x instanceof Prostokat)
				for(Figura y: ((Prostokat)x).prz)
					System.out.println(y);
			System.out.println();
		}
	}
}