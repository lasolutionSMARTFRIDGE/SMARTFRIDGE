package Model;

import org.sintef.jarduino.JArduino;

public class Donner extends JArduino {
	Interface_Model model;

	public Donner(String serialPort) {
		super(serialPort);
		
	}
	
	public int[] GetTemperatures(){
		int tab[] = null;
		
		return tab;
	}

	@Override
	protected void loop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setup() {
		// TODO Auto-generated method stub
		
	}
}