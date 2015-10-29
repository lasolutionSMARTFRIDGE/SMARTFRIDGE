import org.sintef.jarduino.comm.Serial4JArduino;

import Model.Donner;
import View.Fenetre;

public class Main {

	public static void main(String[] args) {
		String serialPort;
        if (args.length == 1) {
            serialPort = args[0];
        } else {
            serialPort = Serial4JArduino.selectSerialPort();
        }
        
        Donner donner = new Donner(serialPort);
        Fenetre fenetre = new Fenetre(donner);
		// TODO Auto-generated method stub

	}

}
