// CARLOS MACÍAS GIL


package paint;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.PointerInfo;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Paint extends JPanel {

	private int x1, y1, x2, y2;
	private String[] figuras={"Línea", "Rectángulo", "Óvalo"};
	private String[] colores={"Negro", "Azul", "Rojo", "Verde", "Amarillo", "Rosa", "Naranja","Blanco"};
	private Color[] colors= {Color.black, Color.blue, Color.red, Color.green, Color.yellow, Color.pink, Color.orange, Color.white};
	private Figura f;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint window = new Paint();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		f.pintar(g);
		
	}
	/**
	 * Create the application.
	 */
	public Paint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame("Java Paint");
		
		Fondo fondo =new Fondo();
		frame.getContentPane().add(fondo);
		fondo.setBounds(0, 26, 868, 437);
		
		JLabel lblCoordenadas = new JLabel("Coordenadas del ratón: X:--, Y:--"); 
		// le pongo un texto para que cuando se inice el programa no aparezca sin texto
		lblCoordenadas.setBounds(0, 465, 305, 15);
		frame.getContentPane().add(lblCoordenadas);
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/icono.jpg")); // PONER ICONO A LA APP 
		frame.setBounds(100, 100, 868, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 868, 27);
		frame.getContentPane().add(menuBar);
		
		JButton btnDeshacer = new JButton("Deshacer");
		btnDeshacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondo.deshacer();
			}
		});
		menuBar.add(btnDeshacer);
		
		JButton btnRehacer = new JButton("Rehacer");
		btnRehacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondo.rehacer();
			}
		});
		menuBar.add(btnRehacer);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				fondo.borrarTodo();
			}
		});
		menuBar.add(btnLimpiar);
		
		JComboBox comboBoxColor = new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(colores));
		menuBar.add(comboBoxColor);
		
		JComboBox comboFigura = new JComboBox();
		comboFigura.setModel(new DefaultComboBoxModel(figuras));
		menuBar.add(comboFigura);
		
		JCheckBox chckbxRelleno = new JCheckBox("Relleno");
		menuBar.add(chckbxRelleno);
		
		JPanel panel = new JPanel();
		
		panel.setBounds(0, 26, 868, 437);
		frame.getContentPane().add(panel);
		
		
		
		
	
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent evt) {
			
				//MOSTRAR LAS COORDENADAS EN LA ETIQUETA 
				lblCoordenadas.setText(String.format("Coordenadas del ratón: X:"+evt.getX()+", Y:"+evt.getY()));
					
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				lblCoordenadas.setText(String.format("Coordenadas del ratón: X:"+e.getX()+", Y:"+e.getY()));
				f.setX2(e.getX());
				f.setY2(e.getY());
				fondo.trazo(f);
				
			}
		});
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
	
				
				switch(comboFigura.getSelectedIndex()) {
				
				case 0:
					 f = new Linea(e.getX(),e.getY(),e.getX(),e.getY(),colors[comboBoxColor.getSelectedIndex()]);
					break;
					
				case 1: 
					f = new Rectangulo(e.getX(),e.getY(),e.getX(),e.getY(),colors[comboBoxColor.getSelectedIndex()],chckbxRelleno.isSelected());
					break;
					
				case 2:
					f = new Ovalo(e.getX(),e.getY(),e.getX(),e.getY(),colors[comboBoxColor.getSelectedIndex()],chckbxRelleno.isSelected());
					break;
			

				}
             
			}
			
			@Override
            public void mouseReleased(MouseEvent e) {
               f.setX2(e.getX());
               f.setY2(e.getY());
               fondo.agregarFigura(f);
              
            }
		
		});
		
		
		
		

		
		
		
		
	}
	
	
}

	
