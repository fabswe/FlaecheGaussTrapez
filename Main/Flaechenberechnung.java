package belegTeilC;

import java.util.ArrayList;
import java.util.Scanner;


import javax.swing.JFrame;

public class Flaechenberechnung {


	public static void main(String[] args) 
	{
		ArrayList<Punkt> punkte = new ArrayList<Punkt>();
		
		ArrayList<Flurflaeche> flurflaechenListe = new ArrayList<Flurflaeche>();
		
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		double x = 0;
		double y = 0;
		
		String AntwortA;
		String AntwortB;
		int AnzahlG=1;
		int AnzahlS=1;

		double Gesamtflaeche = 0;
		
		System.out.println("Flächenrechner\n");
		
		System.out.println("Geben Sie alle gemessenen Punkte ein (Abbruch mit einer negativen Zahl)\n");
		
		int z=0;
		while(true) 
		{
			
			System.out.println("Geben sie den x Wert von Punkt " +z+" ein:");
			x	= sc.nextDouble();
			if(x < 0)
				break;
			System.out.println("Geben sie den y Wert von Punkt " +z+" ein:");
			y	= sc.nextDouble();
			++z;
			punkte.add(new Punkt(x,y));
		}
		
		
		do
		{
			System.out.println("Welcher Flächentyp soll hinzugefügt werden? (g = Grundstück / s = Straße)");	
			AntwortB = sc.next();
			boolean q = (AntwortB.equals("g")) || (AntwortB.equals("s")) ;
			Flurflaeche myFlurflaeche ;
			if(q)
			{
		
			if(AntwortB.equals("g"))
			{
				myFlurflaeche = new Grundstueck();
				int index = 0;
				System.out.println("Geben Sie die Indizes, der das Grundstück begrenzenden Punkte ein.(Abbruch mit einer negativen Zahl)");
				while(true)
				{
					
					index = sc.nextInt();
					if(index < 0)
						break;
					boolean r = (index >= punkte.size());
					if (r)
					{
						System.out.println("Der letzte Indize wurde nicht gefunden.\n"+" Bitte geben Sie einen Indizie zwischen 0 und "+ (punkte.size()-1) +" ein.");
						index =sc.nextInt();
						if(index < 0)
							break;
					}
					
					System.out.println("Nächster Pkt.:");
					myFlurflaeche.addPunkt(punkte.get(index));
				}
				myFlurflaeche.nummer=AnzahlG;
				flurflaechenListe.add(myFlurflaeche);
				AnzahlG++;
				
				
				
			}
			
				else if(AntwortB.equals("s"))
				{
					System.out.println("Geben Sie die Breite der Straße ein.");
					myFlurflaeche = new Strasse(sc.nextDouble());
					int index = 0;
					System.out.println("Geben Sie die Indizes, der Straßenpunkte ein.(Abbruch mit einer negativen Zahl)");
					while(true)
					{
						
						index = sc.nextInt();
						if(index < 0)
							break;
						boolean r = (index >= punkte.size());
						if (r)
						{
							System.out.println("Der letzte Indize wurde nicht gefunden.\n"+" Bitte geben Sie einen Indizie zwischen 0 und "+ (punkte.size()-1) +" ein.");
							index =sc.nextInt();
							if(index < 0)
								break;
						}
						
						System.out.println("Nächster Pkt.:");
						myFlurflaeche.addPunkt(punkte.get(index));
					}
					myFlurflaeche.nummer=AnzahlS;
					flurflaechenListe.add(myFlurflaeche);
					AnzahlS++;
			}
			
			}
			
			else
			{
				System.out.println("Bitte beim nächsten mal s oder g eingeben!");
			}	
			
			
		System.out.println("Soll eine weitere Fläche hinzugefügt werden? (j/n)");
		AntwortA= sc.next();
		}
		while(AntwortA.equals("j"));
		
		for(Flurflaeche flu : flurflaechenListe)
		{
			Gesamtflaeche += flu.getFlaeche();
		}
		System.out.println("Die Gesamtfläche beträgt:"+ Gesamtflaeche);
		
		JFrame frame = new JFrame();
		FlurflaechenPanel panel = new FlurflaechenPanel(flurflaechenListe);
		frame.setSize(600, 600);
		frame.add(panel);
		frame.setVisible(true);
		
	}

}
