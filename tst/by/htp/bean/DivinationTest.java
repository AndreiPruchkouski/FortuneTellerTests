package by.htp.bean;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import by.htp.logic.FortuneTeller;


public class DivinationTest {
	
	// Проверяет что предсказание соответствует типу запрашиваемого гадания

	private FortuneTeller fortuneTeller;
	private String divinationType = "Work"; 
	private String divination;
	private String divinationIncorrect = "Lambada";
	private boolean isHere;
	
	
	@Before
	public void init() {
		fortuneTeller = new FortuneTeller(); // init FortuneTeller obj
		divination = fortuneTeller.petalDivination(divinationType); // get divination text
	}

	@Test
	public void typeVsDivination() {
		isHere = fortuneTeller.getDivinations().get(divinationType).getPredictions().contains(divination);
		assertTrue("This value is not from here", isHere);
		isHere = fortuneTeller.getDivinations().get(divinationType).getPredictions().contains(divinationIncorrect);
		assertFalse("This value is not from here", isHere);
	}

}
