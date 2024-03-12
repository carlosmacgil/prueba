// CARLOS MACÍAS GIL
package paint;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Fondo extends JPanel {
	
	private ArrayList<Figura> nuevaFigura;
	private Figura figura;
	
	private int contFig=0;
	
	public boolean deshacer;

	public Fondo() {
		nuevaFigura=new ArrayList<>();
	}

	
	public void agregarFigura(Figura f) {
		if (deshacer) {
			for (int i =nuevaFigura.size()-1;i>= contFig; i--) {
				nuevaFigura.remove(i);
			}
			deshacer=false;
		}
		
		
		nuevaFigura.add(f);
		figura=null;
		repaint();
		contFig++;
		
	}

	public void borrarTodo() {
		nuevaFigura.clear();
	
		repaint();
		contFig=0;
	}
	
	
	public void trazo(Figura f) { // esto es para que se vea el trazo a la vez q se dibuja
		figura=f;
		repaint();
	}
	
	
	

	public void deshacer() {
			
		if (contFig>0) {
			contFig--;
			repaint();
			deshacer=true;
			}
		}
		
	
	
	public void rehacer() {
		
		if (contFig<nuevaFigura.size()) {
		contFig++;
		repaint();
		}
		
		
	}
	
	
	
	// dejar esto abajo del todo que si no no va :(
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);		
		for (int i=0; i<contFig; i++) {
			nuevaFigura.get(i).pintar(g);

		}
		
//		for (Figura figuraActual: nuevaFigura) {
//			g.setColor(figuraActual.getColor());
//			figuraActual.pintar(g);
//		}
		if (figura!=null) {
			figura.pintar(g);
		}
	}
	
	
	

}
