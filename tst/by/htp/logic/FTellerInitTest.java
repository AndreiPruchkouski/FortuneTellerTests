package by.htp.logic;

import static org.junit.Assert.*;


import org.junit.Test;

public class FTellerInitTest {
	
	// проверяет что при запуске приложения объект класса Гадалка создан и проинициализирован правильно, 
	// а именно, у Гадалки есть необходимый(минимальный) набор ромашек (например, одна, 5, десять или сколько захочешь)

	private FortuneTeller fortuneTeller;
	private boolean chamomilesNotNull;
	
	@Test
	public void fortuneTellerObj() {
		assertNull(fortuneTeller);
		fortuneTeller = new FortuneTeller();
		assertNotNull(fortuneTeller);
	}
	
	@Test
	public void ft_chamomileCollection() {
		fortuneTeller = new FortuneTeller();
		chamomilesNotNull = !fortuneTeller.getChamomiles().isEmpty();
		assertTrue(chamomilesNotNull);
	}
	
	@Test
	public void ft_chamomileCount() {
		fortuneTeller = new FortuneTeller();
	
		assertTrue(fortuneTeller.getChamomiles().size() > 0);
	}

}
