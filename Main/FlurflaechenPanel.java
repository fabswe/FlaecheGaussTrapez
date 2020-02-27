package belegTeilC;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class FlurflaechenPanel extends JPanel 
{
	
	private static final long serialVersionUID = 1L;
	protected ArrayList<Flurflaeche> flurflaechen = new ArrayList<Flurflaeche>();
	
	FlurflaechenPanel(ArrayList<Flurflaeche> flurflaechen)
	{
		this.flurflaechen = flurflaechen;
	}
	
	
	void addFlurflaeche( Flurflaeche f )
	{
		flurflaechen.add(f);
	}
	
	public ArrayList<Flurflaeche>  getFlurflaeche()
	{
		return flurflaechen;
	}
	
	
	protected void paintComponent(Graphics gr) 
	{ 
		Graphics2D g = (Graphics2D) gr;
		
		for(Flurflaeche flu : flurflaechen)
		{
			flu.zeichne(g);
		}
	}
}