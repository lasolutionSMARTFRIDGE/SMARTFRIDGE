package View;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JPanel;

import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.sintef.jarduino.AnalogPin;

import com.sun.glass.events.WindowEvent;

import Model.Donner;

import org.jfree.data.xy.*;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;

public class Fenetre extends JFrame{
    TimeSeries tExterieur = new TimeSeries("température exterieur",Millisecond.class);
    TimeSeries tInterrieur = new TimeSeries("température interrieur",Millisecond.class);
    TimeSeries tModule = new TimeSeries("température module",Millisecond.class);
    TimeSeriesCollection dataset = new TimeSeriesCollection();
    int i = 0;
    float resultat3;
	float resultat2,resultat;
    Model.Donner donnee;
    Label label_2;
    Label label_3;
    Label label_4;
    Donner donner;
    
    
	public Fenetre(Donner donner) {
		this.donner = donner;
		this.setSize(850, 700);
		this.setTitle("SmartFridge");
		this.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
		
		getContentPane().setLayout(null);
		
		TextField textField = new TextField();
		textField.setBounds(106, 61, 168, 31);
		getContentPane().add(textField);
		
		Button button = new Button("Valider consigne");
		button.setBounds(316, 61, 105, 31);
		getContentPane().add(button);
		
		Label label = new Label("condensation");
		label.setBackground(Color.GREEN);
		label.setBounds(647, 30, 137, 50);
		getContentPane().add(label);
		
		Label label_1 = new Label("porte ferme");
		label_1.setBackground(Color.GREEN);
		label_1.setBounds(647, 85, 137, 50);
		getContentPane().add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 158, 810, 448);
		getContentPane().add(panel);
		
		label_2 = new Label("Temp interieur");
		label_2.setBounds(20, 102, 124, 50);
		getContentPane().add(label_2);
		
		label_3 = new Label("Temp module");
		label_3.setBounds(240, 102, 124, 50);
		getContentPane().add(label_3);
		
		label_4 = new Label("Temp exterieur");
		label_4.setBounds(463, 98, 124, 54);
		getContentPane().add(label_4);
		
		this.setResizable(false);
        

        dataset.addSeries(tExterieur);
        dataset.addSeries(tInterrieur);
        dataset.addSeries(tModule);
        
        
        JFreeChart jfrey = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(jfrey);
        panel.add(chartPanel);
        
        
        
        this.setVisible(true);
        
        for (int i = 0; i < 100; i++) {

        	Update();
        	System.out.println("coucou");
		}
	}
	
	private JFreeChart createChart(final XYDataset dataset){
		final JFreeChart result = ChartFactory.createTimeSeriesChart("Graphique Dynamique", "Temps", "Temperature", dataset, true, true, false);
	
		final XYPlot plot = result.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(60000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 200.0); 
        return result;
	}
	public void Update(){
		
		resultat3 = this.donner.getTemperatures()[2];
		resultat2 = donner.getTemperatures()[1];
		resultat = donner.getTemperatures()[0];
		
		int i1 = 0, i2 = 0;
		i1 =i1+2;
		i2 =i2+3;
		
		this.tExterieur.addOrUpdate(new Millisecond(), resultat3);
		this.tInterrieur.addOrUpdate(new Millisecond(), resultat2);
		this.tModule.addOrUpdate(new Millisecond(),resultat);
		
		label_2.setText(resultat+"");
		label_3.setText(resultat2+"");
		label_4.setText(resultat3+"");
		
	}
	
}