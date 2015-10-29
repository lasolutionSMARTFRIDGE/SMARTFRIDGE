package Model;

import org.sintef.jarduino.AnalogPin;
import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.PWMPin;

public class Donner extends JArduino {
	AnalogPin SortieTempModule = AnalogPin.A_0;
	AnalogPin SortieTempInterieur = AnalogPin.A_0;
	AnalogPin SortieTempExterieur = AnalogPin.A_0;
	PWMPin SortieCommande = PWMPin.PWM_PIN_3;
	
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
		int tab[] = new int[3];
		tab[0] = this.analogRead(this.getSortieTempInterieur());
		tab[1] = this.analogRead(this.getSortieTempModule());
		tab[2] = this.analogRead(this.getSortieTempExterieur());
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