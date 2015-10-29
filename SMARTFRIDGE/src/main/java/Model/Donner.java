package Model;

import org.sintef.jarduino.AnalogPin;
import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.PWMPin;

public class Donner extends JArduino {
	public AnalogPin SortieTempModule = AnalogPin.A_0;
	public AnalogPin SortieTempInterieur = AnalogPin.A_1;
	public AnalogPin SortieTempExterieur = AnalogPin.A_2;
	PWMPin SortieCommande = PWMPin.PWM_PIN_3;
	int sensorvalue = 0;
	int sensorvalue1 = 0;
	int sensorvalue2 = 0;
	int resultat = 0;
	int resultat1 = 0;
	int resultat2 = 0;
	public Donner(String serialPort) {
		super(serialPort);		
	}
		
	public AnalogPin getSortieTempModule() {
		return SortieTempModule;
	}

	public void setSortieTempModule(AnalogPin sortieTempModule) {
		SortieTempModule = sortieTempModule;
	}

	public AnalogPin getSortieTempInterieur() {
		return SortieTempInterieur;
	}

	public void setSortieTempInterieur(AnalogPin sortieTempInterieur) {
		SortieTempInterieur = sortieTempInterieur;
	}

	public AnalogPin getSortieTempExterieur() {
		return SortieTempExterieur;
	}

	public void setSortieTempExterieur(AnalogPin sortieTempExterieur) {
		SortieTempExterieur = sortieTempExterieur;
	}

	public PWMPin getSortieCommande() {
		
		return SortieCommande;
	}
	
	public void setSortieCommande(PWMPin sortieCommande){
		SortieCommande = sortieCommande;
	}


	public void setCommande(byte value) {
		this.analogWrite(this.getSortieCommande(), value);
	}

	public int[] getTemperatures(){
		sensorvalue = analogRead(SortieTempModule);
		System.out.println(analogRead(SortieTempModule));
		resultat = (5* sensorvalue *100)/1024 ;		
		System.out.println(resultat+"°C");
		
		//a l'interieur du frigo 
		sensorvalue1 = analogRead(SortieTempInterieur);
		System.out.println(analogRead(SortieTempInterieur));
		resultat1 = (5 * sensorvalue1 * 100)/1024;
		System.out.println(resultat1+"°C1");
		
		//a l'exterieur du frigo
		sensorvalue2 = analogRead(SortieTempExterieur);
		System.out.println(analogRead(SortieTempExterieur));
		resultat2 = (5 * sensorvalue2 * 100)/1024;
		System.out.println(resultat2+"°C2");
		
		int tab[] = new int[3];
		tab[0] = resultat;
		tab[1] = resultat1;
		tab[2] = resultat2;
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