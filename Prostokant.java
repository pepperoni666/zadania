import java.util.*;

public class Prostokat implements Figura{
	public Punkt punkt;
	public double bokA, bokB;
	public String nazwa;
	public ArrayList<Figura> prz;
	public Prostokat(double a, double b, double x, double y){
		this.nazwa = "Prostokat";
		this.prz = new ArrayList<Figura>();
		this.punkt = new Punkt(x, y);
		this.bokA = a;
		this.bokB = b;
	}

	public double pole(){
		return bokA*bokB;
	}
	public double obwod(){
		return (2*bokA + 2*bokB);
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
		return "Prostokat; obwod: " + obwod() + "; pole: " + pole() + ";";
	}

	public boolean przecinaKo(Figura x){
		double ix, iy;
		ix = punkt.getPozX() + Math.abs(bokA/2);
		iy = punkt.getPozY() + Math.abs(bokB/2);
		if(Math.pow((Math.pow((x.punkt.getPozX() - ix), 2) + Math.pow((x.punkt.getPozY() - iy), 2)), 1/2) < (x.bok+(Math.pow((Math.pow(bokA, 2) + pow(bokA, 2)), 1/2)/2)))
			return true;
		else
			return false;
	}

	public boolean przecinaKw(Figura x){
		double ix, iy, kx, ky;
		ix = punkt.getPozX() + Math.abs(bokA/2);
		iy = punkt.getPozY() + Math.abs(bokB/2);
		kx = x.punkt.getPozX() + Math.abs(x.bok/2);
		ky = x.punkt.getPozY() + Math.abs(x.bok/2);
		if(Math.pow((Math.pow((kx - ix), 2) + Math.pow((ky - iy), 2)), 1/2) < ((x.bok*Math.pow(2, 1/2)/2)+(Math.pow((Math.pow(bokA, 2) + Math.pow(bokA, 2)), 1/2)/2)))
			return true;
		else
			return false;
	}

	public boolean przecinaPr(Figura x){
		double ix, iy, kx, ky;
		ix = punkt.getPozX() + Math.abs(bokA/2);
		iy = punkt.getPozY() + Math.abs(bokB/2);
		kx = x.punkt.getPozX() + Math.abs(x.bokA/2);
		ky = x.punkt.getPozY() + Math.abs(x.bokB/2);
		if(Math.pow((Math.pow((kx - ix), 2) + Math.pow((ky - iy), 2)), 1/2) < ((Math.pow((Math.pow(x.bokA, 2) + Math.pow(x.bokA, 2)), 1/2)/2)+(Math.pow((Math.pow(bokA, 2) + Math.pow(bokA, 2)), 1/2)/2)))
			return true;
		else
			return false;
	}
}