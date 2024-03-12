// CARLOS MACÍAS GIL
package paint;

import java.awt.Color;
import java.awt.Graphics;

abstract class FiguraCerrada extends Figura{

	private boolean relleno;
	
	public FiguraCerrada() {
		
	}
	
	public FiguraCerrada(int x1, int y1, int x2, int y2, Color color, boolean relleno) {
		super(x1, y1, x2, y2, color);
		this.relleno=relleno;    
	}
	
	/////////////////////////////////////////////////////////////////////
	
	 public boolean isRelleno() {
		return relleno;
	}

	public void setRelleno(boolean relleno) {
		this.relleno = relleno;
	}
	
	
	public int getAltura(){
	        return Math.abs(getY1()-getY2());
	}
	    
	  
	public int getAncho(){
	        return Math.abs(getX1()-getX2());
	}
	
	
	public int getArribaIzqX(){
	        return Math.min(getX1(),getX2());
	}
	
	    
	public int getArribaIzqY(){
	        return Math.min(getY1(),getY2());
	}
	    
	  
	 
	  

	public abstract void pintar(Graphics g);

	
}
