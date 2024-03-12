// CARLOS MACÍAS GIL
package paint;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo extends FiguraCerrada {

	public Rectangulo() {
		
	}

	public Rectangulo(int x1, int y1, int x2, int y2, Color color, boolean relleno) {
		super (x1, y1, x2, y2, color, relleno);
	}
	

	
	public void pintar( Graphics g )
    {
        g.setColor(getColor() );
        if (isRelleno()) 
            g.fillRect( getArribaIzqX(), getArribaIzqY(), getAncho(), getAltura() ); 
        else
            g.drawRect( getArribaIzqX(), getArribaIzqY(), getAncho(), getAltura() );
        
    }
}