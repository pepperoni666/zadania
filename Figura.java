public interface Figura extends Comparable<Figura>{
	public double pole();
	public double obwod();
	public boolean przecina(Kolo x);
	public boolean przecina(Kwadrat x);
	public boolean przecina(Prostokat x);
}