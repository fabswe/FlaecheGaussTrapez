package belegTeilC;

import java.awt.Graphics2D;
import java.util.ArrayList;
import belegTeilC.Punkt;


public abstract class Flurflaeche 
{
	protected ArrayList<Punkt> punkte = new ArrayList<Punkt>();
	public int nummer;
	void addPunkt( Punkt p )
	{
		punkte.add(p);
	}
	
	public ArrayList<Punkt>  getPunkte()
	{
		return punkte;
	}
	
	public abstract double getFlaeche();
	
	public abstract void zeichne(Graphics2D g);
}
