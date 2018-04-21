public class Kwadrat extends FiguraForemna{
	public double pole(){
		return bok*bok;
	}
	public double obwod(){
		return 4*bok;
	}
	public Kwadrat(double b, double x, double y){
		prz = new ArrayList<Figura>();
		this.punkt = new Punkt(x, y);
		this.bok = b;
		this.nazwa = "Kwadrat";
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
		return nazwa + "; obwod: " + obwod() + "; pole: " + pole() + ";";
	}

	public boolean przecinaKo(Figura x){
		double ix, iy;
		ix = punkt.getPozX() + Math.abs(bok/2);
		iy = punkt.getPozY() + Math.abs(bok/2);
		if(Math.pow((Math.pow((x.punkt.getPozX() - ix), 2) + Math.pow((x.punkt.getPozY() - iy), 2)), 1/2) < (x.bok+(bok*Math.pow(2, 1/2)/2)))
			return true;
		else
			return false;
	}

	public boolean przecinaKw(Figura x){
		double ix, iy, kx, ky;
		ix = punkt.getPozX() + Math.abs(bok/2);
		iy = punkt.getPozY() + Math.abs(bok/2);
		kx = x.punkt.getPozX() + Math.abs(x.bok/2);
		ky = x.punkt.getPozY() + Math.abs(x.bok/2);
		if(Math.pow((Math.pow((kx - ix), 2) + Math.pow((ky - iy), 2)), 1/2) < ((x.bok*Math.pow(2, 1/2)/2)+(bok*Math.pow(2, 1/2)/2)))
			return true;
		else
			return false;
	}

	public boolean przecinaPr(Figura x){
		double ix, iy, kx, ky;
		ix = x.punkt.getPozX() + Math.abs(x.bokA/2);
		iy = x.punkt.getPozY() + Math.abs(x.bokB/2);
		kx = punkt.getPozX() + Math.abs(bok/2);
		ky = punkt.getPozY() + Math.abs(bok/2);
		if(Math.pow((Math.pow((kx - ix), 2) + Math.pow((ky - iy), 2)), 1/2) < ((bok*Math.pow(2, 1/2)/2)+(Math.pow((Math.pow(x.bokA, 2) + Math.pow(x.bokA, 2)), 1/2)/2)))
			return true;
		else
			return false;
	}
}