public class Punkt{
	private double pozycjaX, pozycjaY;
	public double getPozX(){ return this.pozycjaX;}
	public double getPozY(){ return this.pozycjaY;}
	public void setPozX(double poz) { this.pozycjaX = poz;}
	public void setPozY(double poz) { this.pozycjaY = poz;}
	public Punkt(double x, double y){
		this.pozycjaX = x;
		this.pozycjaY = y;
	}
}