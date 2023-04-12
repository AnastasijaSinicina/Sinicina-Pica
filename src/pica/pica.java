package pica;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;
public class pica {
	static File darbvirsma = FileSystemView.getFileSystemView().getHomeDirectory();
	static String atrasanasVieta = darbvirsma.getAbsolutePath();	
	
	static String filePath = "inf.txt";
	static int izveletaisIndekss;
	static boolean EXIT=false;
	static DecimalFormat df = new DecimalFormat(".##");
	static ArrayList<Sutijums> klienti = new ArrayList<>();
	static String vards, adrese, num;
	static String veids="";
	static String izm="";
	static String dzeriens="";
	static String piedeva="";
	static String merce="";
	static String pazinojums;
	static double cena=0;
	static int piegade, lidz;
	static double picCena, dzerCena, mercCena, piedCena, piegCena;	
	
	public static void main(String[] args) {		  
		ImageIcon kart = new ImageIcon(atrasanasVieta+"\\R.png");
		do {
		String[] metodes = {"Reģistrēt jauno", "Apskatīt", "Dzest", "Aizvert programmu"};
		int izvele = JOptionPane.showOptionDialog(null, "Izvēlies darbību", "Pizza_YUMMY", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, kart, metodes, metodes[0]);		
		switch(izvele) {
		case 0: 
			saglabat(); 
		break;
		case 1: 
			izvadit(); 
		break;
		case 2:
			dzest();
		break;
		case 3: 
			aizvert(); 
		break;
		  }  	 
		}while(EXIT!=true);
	}
	private static void saglabat() {
		 klienti.clear();
	     if (klienti.size() >= 100) {
	            JOptionPane.showMessageDialog(null, "Pārāk daudz sūtījumu.");
	            return;
	        }	
		piegade = JOptionPane.showConfirmDialog(null, "Būs piegāde?", "Pizza_YUMMY", JOptionPane.YES_NO_OPTION);

		String[] veidi= {"Studentu", "Margarita","Havaju", "Kalifornijas"};
		String[] izmers = {"25cm", "30cm", "50cm"};
		String[] dzerieni = {"Coca-Cola", "Fanta", "Sprite",
				"Ābolu sula", "Tomātu sula", "Vīnogu sula",
				"Melnā kafija", "Latte"};
		String[] piedevas = {"Frī kartupeļi", "Sīpolu gredzeni", "Ķiploku maizītes"};
		String[] merces = {"Ketčups", "Majonēze", "BBQ", "Gurķu"};		
		String[] pasut = new String[200];
		cena = 0; picCena = 0; dzerCena = 0; mercCena = 0; piedCena = 0; piegCena = 0;	
		int sutSk = 0;	
		int picSk = Integer.parseInt(JOptionPane.showInputDialog
				(null,"Cik picas?", "Pizza_YUMMY", JOptionPane.QUESTION_MESSAGE));
		while(picSk!=0) {
			if(picSk>0) {
				veids = (String)JOptionPane.showInputDialog(null, "Picca:", "Pizza_YUMMY", JOptionPane.PLAIN_MESSAGE, null, veidi, veidi[0]);
				izm = (String)JOptionPane.showInputDialog(null, "Izmers:", "Pizza_YUMMY", JOptionPane.PLAIN_MESSAGE, null, izmers, izmers[0]);
				if(izm==izmers[0]) {
					picCena+=1.99+5.99;
				}
				if(izm==izmers[1]) {
					picCena+=2.99+5.99;
				}
				if(izm==izmers[2]) {
					picCena+=4.99+5.99;
				}             
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
				if(dzeriens==dzerieni[0] ||dzeriens==dzerieni[1] ||dzeriens==dzerieni[2] ) {
					dzerCena+=1.5;
				}else if(dzeriens==dzerieni[3] ||dzeriens==dzerieni[4] ||dzeriens==dzerieni[5] ) {
					dzerCena+=1.2;
				}else if(dzeriens==dzerieni[6] ||dzeriens==dzerieni[7] ) {
					dzerCena+=2;
				}
				pasut[sutSk] = dzeriens;
				sutSk++;
				dzSk--;
			}
		}
		int mercSk = Integer.parseInt(JOptionPane.showInputDialog
				(null,"Cik mērces?", "Pizza_YUMMY", JOptionPane.QUESTION_MESSAGE));
		while(mercSk!=0) {
			if(mercSk>0) {
				merce = (String)JOptionPane.showInputDialog(null, "Merces:", "Pizza_YUMMY", JOptionPane.PLAIN_MESSAGE, null, merces, merces[0]);              
				mercCena+=0.8;
				pasut[sutSk] = merce;
				sutSk++;
				mercSk--;
			}
		}
		int piedSk = Integer.parseInt(JOptionPane.showInputDialog
				(null,"Cik piedevas?", "Pizza_YUMMY", JOptionPane.QUESTION_MESSAGE));
		while(piedSk!=0) {
			if(piedSk>0) {
				piedeva = (String)JOptionPane.showInputDialog(null, "Piedevas:", "Pizza_YUMMY", JOptionPane.PLAIN_MESSAGE, null, piedevas, piedevas[0]);              
				if(piedeva==piedevas[0]) {
	            	   piedCena+=1.5;
	                  }else if(piedeva==piedevas[1]) {
	            	   piedCena=2.5;
	               }if(piedeva==piedevas[2]) {
	            	   piedCena+=4;
	               }	
				pasut[sutSk] = piedeva;
				sutSk++;
				piedSk--;
			}
		}
		if(piegade == JOptionPane.YES_OPTION) {
			piegCena+=1;
			do {
			adrese = JOptionPane.showInputDialog(null, "Adrese:");
			}while(adrese.length()<3);
			do {
			vards = JOptionPane.showInputDialog(null, "Vards:");
		   }while(adrese.length()<3);
			do {
			num = JOptionPane.showInputDialog("Tālr.:" ,"+371");
			}while(num.length()!=12);

		}else
		if(piegade == JOptionPane.NO_OPTION) {
			lidz = JOptionPane.showConfirmDialog(null, "Līdzņemšana?", "Pizza_YUMMY", JOptionPane.YES_NO_OPTION);
			if(lidz == JOptionPane.YES_OPTION) {
			vards = JOptionPane.showInputDialog(null, "Vards:");
			}else if(lidz == JOptionPane.NO_OPTION) {
				vards = JOptionPane.showInputDialog(null, "Galds:");		
				adrese = " ";
				num = " ";
			}
		}	
		ImageIcon kart2 = new ImageIcon(atrasanasVieta+"\\R (1).png");
		cena = picCena+dzerCena+mercCena+piedCena+piegCena;
		for(int i=0; i<klienti.size(); i++) {
	    cena = klienti.get(i).cena;
	    pazinojums +=klienti.get(i);
		}
		Sutijums SUT = new Sutijums(vards,adrese, num, veids, izm, dzeriens, piedeva, merce, cena, piegade, lidz);
        klienti.add(SUT);
		pazinojums = "\nKlients / galds: "+vards+"\nAdrese: "+adrese+"\nNumurs:" +num+"\n";
		for(int i=0; i<sutSk; i++) {
			pazinojums += (i+1)+". "+pasut[i]+"\n";
		}
		JOptionPane.showMessageDialog(null, pazinojums+" = "+df.format(SUT.cena)+"eiro"+"\n", "Pizza_YUMMY", JOptionPane.INFORMATION_MESSAGE);		
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(pazinojums +df.format(SUT.cena)+"\n____________\n");
            writer.close();
            JOptionPane.showMessageDialog(null,"Saglabats!", "Pizza_Yummy", JOptionPane.INFORMATION_MESSAGE, kart2);
           
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Kļūda");
            e.printStackTrace();         
        }	            
    }	
	  public static void izvadit() {	 
	    	JTextArea text = new JTextArea();
      	  JScrollPane scroll = new JScrollPane(text);
      	  scroll.setPreferredSize(new Dimension(500,400));
	        String data = "  ";	      
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(filePath));
	            String line = reader.readLine();
	            while (line != null) {
	                data += line + "\n";
	                line = reader.readLine();
	            }
	            text.append(data);
	            JOptionPane.showMessageDialog(null, scroll);
	            reader.close();
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, "Kļūda: " + e.getMessage());
	        }	      
	    }
	  private static void dzest() {
	    	String izv;
	        if (klienti.size() == 0) {
	            JOptionPane.showMessageDialog(null, "Nav neviena klienta.");	    
	        }
	        	String[] klientuVardi = new String[klienti.size()];
	        	 for (int i = 0; i < klienti.size(); i++) {
						klientuVardi[i] = klienti.get(i).vards;
				       }
	        	izv = (String)JOptionPane.showInputDialog(null,"Kuru dzest?", "Pizza_YUMMY", 
		        		JOptionPane.QUESTION_MESSAGE, null, klientuVardi, klientuVardi[0]);
		         int indekss = Arrays.asList(klientuVardi).indexOf(izv);
		       
		         klienti.remove(indekss);
	    }	        	 
   private static void aizvert() {
   ImageIcon kart3 = new ImageIcon(atrasanasVieta+"\\R (2).png");
	int rez = JOptionPane.showConfirmDialog(null, "Beigt darbu?", "Pizza_YUMMY", JOptionPane.YES_NO_OPTION);
    if (rez == JOptionPane.YES_OPTION) {
    	try {
    		FileWriter writer = new FileWriter("inf.txt");
            writer.write("");
            writer.close();
            JOptionPane.showMessageDialog(null, kart3);
         } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Kļūda");
        }
       System.exit(0); 
    	}
    }     
	 @Override
     public String toString() {
     	return pazinojums;
    }

}
