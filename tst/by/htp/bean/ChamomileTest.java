package by.htp.bean;

import static org.junit.Assert.*;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

import by.htp.bean.Сhamomile;

public class ChamomileTest {
	
	// проверяет что для гадания досталась правильная ромашка (с необходимым количеством лепестком)
	
	private Сhamomile temp;
	private int range;
	private int petals;
	
	@Before
	public void init() {
		temp = new Сhamomile();
		Random random = new Random();
		range = random.nextInt(10 - 1 + 1) + 1;
	}
	
	@Test
	public void petalsCheck() {
		
		petals = temp.getPetalsCount();
		assertTrue("Error, random is too high", petals >= range);
		
	}

}
