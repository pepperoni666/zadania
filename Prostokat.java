public class Prostokat implements Figura{
	public Punkt punkt;
	public double bokA, bokB;
	public Prostokat(double a, double b, double x, double y){
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
}