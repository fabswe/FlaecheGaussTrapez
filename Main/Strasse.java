package belegTeilC;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class Strasse extends Flurflaeche{
	private double breite;
	double flaeche = 0;
	
	public Strasse(double breite) 
	{
		this.breite = breite;
	}
	
	
	public double getBreite()
	{
		return breite;
	}
	
	public double getFlaeche()
	{
	
		for(int i = 0; i < punkte.size()-1; ++i)
		{
			double xs1 = punkte.get(i).x;
			double xs2 = punkte.get(i+1).x;
			double ys1 = punkte.get(i).y;
			double ys2 = punkte.get(i+1).y;
			flaeche += breite* Math.sqrt((xs2-xs1)*(xs2-xs1)+(ys2-ys1)*(ys2-ys1));
		}
		
		return flaeche;
	}
	public void zeichne(Graphics2D g){
		long b=Math.round(breite);
		g.setStroke(new BasicStroke(1.0f*b));
		g.setColor(Color.gray);
		for(int i = 0; i<punkte.size()-1; ++i){
			int x1 = (int) punkte.get(i).x;
			int y1 = (int) punkte.get(i).y;
			int x2 = (int) punkte.get(i+1).x;
			int y2 = (int) punkte.get(i+1).y;
			g.drawLine(x1,500-y1,x2,500-y2);
		
		}
		g.setColor(Color.red);
		g.drawString("Straße: "+nummer,(int)punkte.get(0).x+5,480-(int)punkte.get(0).y);
		g.drawString("Fläche: "+flaeche,(int)punkte.get(0).x+5,495-(int)punkte.get(0).y);
	}

}
