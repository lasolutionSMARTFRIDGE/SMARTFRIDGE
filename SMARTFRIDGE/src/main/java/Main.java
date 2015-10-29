import org.sintef.jarduino.comm.Serial4JArduino;

public class Main {

	public static void main(String[] args) {
		String serialPort;
        if (args.length == 1) {
            serialPort = args[0];
        } else {
            serialPort = Serial4JArduino.selectSerialPort();
        }
        
		// TODO Auto-generated method stub

	}

}
