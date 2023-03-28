package pica;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class pica {
	static int izveletaisIndekss;
	static ArrayList<Sutijums> klienti = new ArrayList<Sutijums>();
	
	public static void main(String[] args) {
		metodes();

	}
	public static void metodes() {
		String[] metodes = {"Reģistrēt jauno", "Apskatīt", "Aizvert programmu"};
		int izvele = JOptionPane.showOptionDialog(null, "Izvēlies darbību", "Pizza_YUMMY", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, metodes, metodes[0]);
		izveletaisIndekss = Arrays.asList(klienti).indexOf(izvele);
		
		switch(izvele) {
		case 0: 
			saglabat(); 
		break;
		case 1: 
			izvadit(); 
		break;
		case 2: 
			aizvert(); 
		break;
		default:
			metodes();
			break;	
		}
	}
	private static void saglabat() {
		
	}
   private static void izvadit() {
		
	}
   private static void aizvert() {
	
}

}
