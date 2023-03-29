package pica;

public class Sutijums extends pica{
	String vards, adrese, num, gNum;
	String veids="", izm="", dzeriens="", piedeva="", merce="";
	double cena=0;
	int piegade;
	 
	public Sutijums(String vards, String adrese,String num, 
			String gNum, String veids, String izm,String dzeriens, 
			String piedeva,String merce, double cena, int piegade) {
		
		this.vards = vards;
		this.adrese = adrese;
		this.num = num;
		this.gNum = gNum;
		this.izm = izm;
		this.dzeriens = dzeriens;
		this.piedeva = piedeva;
		this.merce = merce;
		this.cena = cena;
		this.piegade = piegade;
		
	}

}
