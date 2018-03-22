package by.htp.runner;

import by.htp.logic.FortuneTeller;

public class MainApp {

	public static void main(String[] args) {
		 
		
		
		FortuneTeller fr = new FortuneTeller();
		System.out.println("Numner of chamomiles: " + fr.getChamomiles().size());
		fr.tellFortunes();
		fr.tellFortunes();
		fr.tellFortunes();
		fr.tellFortunes();
		fr.tellFortunes();
		
		System.out.println("END");

	}
	
}
