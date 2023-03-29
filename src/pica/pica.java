package pica;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class pica {
	static int izveletaisIndekss;
	static ArrayList<Sutijums> klienti = new ArrayList<Sutijums>();
	static String vards, adrese, num;
	static String veids="";
	static String izm="";
	static String dzeriens="";
	static String piedeva="";
	static String merce="";
	double cena=0;
	static int piegade, lidz;
	 
	
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
		piegade = JOptionPane.showConfirmDialog(null, "Būs piegāde?", "Pizza_YUMMY", JOptionPane.YES_NO_OPTION);
		lidz = JOptionPane.showConfirmDialog(null, "Līdzņemšana?", "Pizza_YUMMY", JOptionPane.YES_NO_OPTION);

		String[] veidi= {"Studentu", "Margarita","Havaju", "Kalifornijas"};
		String[] izmers = {"25cm", "30cm", "50cm"};
		String[] dzerieni = {"Coca-Cola", "Fanta", "Sprite",
				"Ābolu sula", "Tomātu sula", "Vīnogu sula"};
		String[] piedevas = {"Frī kartupeļi", "Sīpolu gredzeni", "Ķiploku maizītes"};
		String[] merces = {"Ketčups", "Majonēze", "BBQ", "Gurķu"};
		
		String[] pasut = new String[20];
		int sutSk = 0;
		
		
		
		int picSk = Integer.parseInt(JOptionPane.showInputDialog
				(null,"Cik picas?", "Pizza_YUMMY", JOptionPane.QUESTION_MESSAGE));
		while(picSk!=0) {
			if(picSk>0) {
				veids = (String)JOptionPane.showInputDialog(null, "Picca:", "Pizza_YUMMY", JOptionPane.PLAIN_MESSAGE, null, veidi, veidi[0]);
				izm = (String)JOptionPane.showInputDialog(null, "Izmers:", "Pizza_YUMMY", JOptionPane.PLAIN_MESSAGE, null, izmers, izmers[0]);
               
				pasut[sutSk] = veids +" "+izm;
				sutSk++;
				picSk--;
			}
		}
		
		int dzSk = Integer.parseInt(JOptionPane.showInputDialog
				(null,"Cik dzērienu?", "Pizza_YUMMY", JOptionPane.QUESTION_MESSAGE));
		while(dzSk!=0) {
			if(dzSk>0) {
				dzeriens = (String)JOptionPane.showInputDialog(null, "Dzeriens:", "Pizza_YUMMY", JOptionPane.PLAIN_MESSAGE, null, dzerieni, dzerieni[0]);              
				pasut[sutSk] = dzeriens;
				sutSk++;
				dzSk--;
			}
		}
		int mercSk = Integer.parseInt(JOptionPane.showInputDialog
				(null,"Cik dzērienu?", "Pizza_YUMMY", JOptionPane.QUESTION_MESSAGE));
		while(mercSk!=0) {
			if(mercSk>0) {
				merce = (String)JOptionPane.showInputDialog(null, "Dzeriens:", "Pizza_YUMMY", JOptionPane.PLAIN_MESSAGE, null, merces, merces[0]);              
				pasut[sutSk] = dzeriens;
				sutSk++;
				mercSk--;
			}
		}
		int piedSk = Integer.parseInt(JOptionPane.showInputDialog
				(null,"Cik dzērienu?", "Pizza_YUMMY", JOptionPane.QUESTION_MESSAGE));
		while(piedSk!=0) {
			if(piedSk>0) {
				piedeva = (String)JOptionPane.showInputDialog(null, "Dzeriens:", "Pizza_YUMMY", JOptionPane.PLAIN_MESSAGE, null, piedevas, piedevas[0]);              
				pasut[sutSk] = dzeriens;
				sutSk++;
				piedSk--;
			}
		}
		if(piegade == JOptionPane.YES_OPTION) {
			do {
			adrese = JOptionPane.showInputDialog(null, "Adrese:");
			}while(adrese.length()<3);
			do {
			vards = JOptionPane.showInputDialog(null, "Vards:");
		   }while(adrese.length()<3);
			do {
			num = JOptionPane.showInputDialog(null, "Tālr.:");
			}while(num.length()!=8);

		}
		if(piegade == JOptionPane.NO_OPTION) {
			if(lidz == JOptionPane.YES_OPTION) {
			vards = JOptionPane.showInputDialog(null, "Vards:");
			}else if(lidz == JOptionPane.NO_OPTION) {
				vards = JOptionPane.showInputDialog(null, "Galds:");
			}
		}
		
		
		
		
	}
   private static void izvadit() {
		
	}
   private static void aizvert() {
	
}

}
