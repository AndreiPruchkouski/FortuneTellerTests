package by.htp.bean;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import by.htp.logic.FortuneTeller;

public class ClientTest {
	
	// проверяет что один клиент не гадал больше двух раз в сутки
	// клиент в принципе получил предсказание

	//common data
	private FortuneTeller fortuneTeller = new FortuneTeller();
	//1st test data
	private String divType = "Love";
	private String result;
	//2nd test data
	private String fname = "Jack";
	private String sname = "Daniel’s";
	private String fname_new = "Alon";
	private String sname_new = "Mask";
	private LocalDate day = LocalDate.now();
	private boolean wasFortuned;

	@Test
	public void divinationRecieved() {
		assertNull(result);
		result = fortuneTeller.petalDivination(divType);
		assertNotNull(result);
	}
	
	@Test
	public void alreadyFortuned() {
		fortuneTeller.addClient(fname, sname); // Add new client
		wasFortuned = fortuneTeller.checkDate(fname, sname, day);
		assertTrue("This client is new", wasFortuned);
	}
	
	@Test
	public void alreadyFortunedNegative() {
		//negative check if client is new for fortune teller
		wasFortuned = fortuneTeller.checkDate(fname_new, sname_new, day);
		assertFalse(wasFortuned);
	}

}
