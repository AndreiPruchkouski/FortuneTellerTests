package by.htp.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Сhamomile {

	private List<Petal> petals = new ArrayList<>();
	private int petalsCount;
	
	
	public List<Petal> getPetals() {
		return petals;
	}


	public void setPetals(List<Petal> petals) {
		this.petals = petals;
	}


	public int getPetalsCount() {
		return petalsCount;
	}


	public Сhamomile() {
		super();
		newPetals();
	}


	public void newPetals() {
		Random random = new Random();
		petalsCount = random.nextInt(10 - 1 + 1) + 1; // random.nextInt(max - min + 1) + min;
		
		for (int i = 0; i < petalsCount; i++) {
			petals.add(new Petal("White"));
		} 
	}
	
	
}
