import java.util.*;

public class Kolo implements Figura{
	public static final double PI = 3.14159265359;
	public double bok;
	public Punkt punkt;
	public String nazwa;
	public ArrayList<Figura> prz;
	public Kolo(double prom, double x, double y){
		this.nazwa = "Kolo";
		this.prz = new ArrayList<Figura>();
		this.punkt = new Punkt(x, y);
		this.bok = prom;
	}
	public double pole(){
		return PI*bok*bok;
	}
	public double obwod(){
		return 2*bok*PI;
	}

	@Override
	public int compareTo(Figura inna) {
		if(pole() == inna.pole())
	    	return 0;
	    else if(pole() > inna.pole())
	    	return 1;
	    else
	    	return -1;
	}
	@Override
	public String toString(){
		return "Kolo; obwod: " + obwod() + "; pole: " + pole() + ";";
	}

	public boolean przecinaKo(Figura x){
		if(Math.pow((Math.pow((punkt.getPozX() - x.punkt.getPozX()), 2) + Math.pow((punkt.getPozY() - x.punkt.getPozY()), 2)), 1/2) < (bok+x.bok))
			return true;
		else
			return false;
	}

	public boolean przecinaKw(Figura x){
		double ix, iy;
		ix = x.punkt.getPozX() + Math.abs(x.bok/2);
		iy = x.punkt.getPozY() + Math.abs(x.bok/2);
		if(Math.pow((Math.pow((punkt.getPozX() - ix), 2) + Math.pow((punkt.getPozY() - iy), 2)), 1/2) < (bok+(x.bok*Math.pow(2, 1/2)/2)))
			return true;
		else
			return false;
	}

	public boolean przecinaPr(Figura x){
		double ix, iy;
		ix = x.punkt.getPozX() + Math.abs(x.bokA/2);
		iy = x.punkt.getPozY() + Math.abs(x.bokB/2);
		if(Math.pow((Math.pow((punkt.getPozX() - ix), 2) + Math.pow((punkt.getPozY() - iy), 2)), 1/2) < (bok+(Math.pow((Math.pow(x.bokA, 2) + Math.pow(x.bokA, 2)), 1/2)/2)))
			return true;
		else
			return false;
	}
}