package pica;

public class Sutijums extends pica{
	String vards, adrese, num;
	String veids="", izm="", dzeriens="", piedeva="", merce="";
	double cena=0;
	int piegade, lidz;
	 
	public Sutijums(String vards, String adrese,String num, 
			 String veids, String izm,String dzeriens, 
			String piedeva,String merce, double cena, int piegade, int lidz) {
		
		this.vards = vards;
		this.adrese = adrese;
		this.num = num;
		this.izm = izm;
		this.dzeriens = dzeriens;
		this.piedeva = piedeva;
		this.merce = merce;
		this.cena = cena;
		this.piegade = piegade;
		this.lidz = lidz;
		
	}

}
