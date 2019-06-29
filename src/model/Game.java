package model;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.Screen;


public class Game{

	public static final boolean	verbose	= false;
	public static final boolean	debug	= true;

	public static int	MAX_X;
	public static int	MAX_Y;

	public static void main(String[] args){
		if(debug){
			new Game(30, 30);
			return;
		}
		JTextField field_width = new JTextField(3);
		JTextField field_height = new JTextField(3);
		JPanel input = new JPanel();
		input.setLayout(new BoxLayout(input, BoxLayout.PAGE_AXIS));
		input.add(new JLabel("Ingrese:"));
		input.add(new JLabel("ancho: "));
		input.add(field_width);
		input.add(new JLabel("alto: "));
		input.add(field_height);
		int width = 5, height = 5;
		JOptionPane.showMessageDialog(null, input, "Simulador de Vida Salvaje", JOptionPane.INFORMATION_MESSAGE);
		while(true){
			try{
				width = Integer.parseInt(field_width.getText());
				height = Integer.parseInt(field_height.getText());
				break;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, input, "Simulador de Vida Salvaje", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		width = (width < 10) ? 10 : width;
		height = (height < 10) ? 10 : height;
		// Singleton -> private constructor
		new Game(width, height);
		//Timeout reloj = new Timeout(minutos, segundos);
	}

	//TODO CHANGE TO PRIVATE
	public Game(int width, int height){
		MAX_Y = width;
		MAX_X = height;
		if(debug) new State("full_test");
		else
			new State();
		new Screen(width, height);
		new Updater();
	}

	public static void error(Object message){
		System.err.print(message.toString());
	}

	public static void log(Object message){
		System.out.println(message.toString());
	}

}
