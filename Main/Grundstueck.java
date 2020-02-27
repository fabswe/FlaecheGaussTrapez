package belegTeilC;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class Grundstueck extends Flurflaeche
{

	double Flaeche;
	
	public double getFlaeche()
	{
		double summe = 0;
		
		int lastindex =  punkte.size()-1;
		
		for(int i = 0; i < lastindex; ++i)
		{
			summe += (punkte.get(i).x + punkte.get(i+1).x)*(punkte.get(i+1).y - punkte.get(i).y);
		}
		
		summe += (punkte.get(lastindex).x+punkte.get(0).x)*(punkte.get(0).y-punkte.get(lastindex).y);
		
		Flaeche = 0.5 * summe;
		return Flaeche;
	}

	public void zeichne(Graphics2D g)
	{
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(1.0f));
			for(int i = 0; i<punkte.size()-1; ++i)
				
			{
			int x1 = (int) punkte.get(i).x;
			int y1 = (int) punkte.get(i).y;
			int x2 = (int) punkte.get(i+1).x;
			int y2 = (int) punkte.get(i+1).y;
			g.drawLine(x1,500-y1,x2,500-y2);
			}
		
		int x1 = (int) punkte.get(punkte.size()-1).x;
		int y1 = (int) punkte.get(punkte.size()-1).y;
		int x2 = (int) punkte.get(0).x;
		int y2 = (int) punkte.get(0).y;
		g.drawLine(x1,500-y1,x2,500-y2);
		
		g.setColor(Color.blue);
		g.drawString("Grundstück:"+nummer, x1+15, 480-y2);
		g.drawString("Fläche:"+Flaeche, x1+15, 495-y2);
	
	}
	
}
