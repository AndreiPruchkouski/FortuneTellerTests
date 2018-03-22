package by.htp.logic;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import by.htp.bean.Client;
import by.htp.bean.Divination;
import by.htp.bean.Сhamomile;
import by.htp.console.Input;

public class FortuneTeller {

	private LinkedList<Сhamomile> chamomiles = new LinkedList<>();
	private Set<Client> clients = new HashSet<>();
	private Map<String, Divination> divinations = new HashMap<>();
	private String FTellerName = "Marie-Anne-Adélaïde Lenormand";

	private LocalDate today = LocalDate.now();

	public FortuneTeller() {
		initDivinations();
		initChamomoles();
	}

	public void initChamomoles() {
		Random random = new Random();
		int chamocount = random.nextInt(5 - 1 + 1) + 1; // random.nextInt(max - min + 1) + min;
		for (int i = 0; i < chamocount; i++) {
			chamomiles.add(new Сhamomile());
		}
	}

	public void initDivinations() {
		divinations.put("Work",
				new Divination(Arrays.asList("Raising is waiting", "Dismissal is waiting", "Commision is waiting")));
		divinations.put("Love",
				new Divination(Arrays.asList("Everything will be OK", "No future", "Enough of love from you")));
		divinations.put("Luck",
				new Divination(Arrays.asList("Go casino man, this day is yours", "You'll find money", "You'll fire")));
	}

	public void tellFortunes() {
		String t_clientName;
		String t_clientSName;
		String t_clientChoise;
		Input reader = new Input();

		System.out.println("Numner of chamomiles: " + getChamomiles().size());
		if (!chamomiles.isEmpty()) {
			t_clientName = reader.readFName();
			t_clientSName = reader.readSName();
			if (!сlientPresented(t_clientName, t_clientSName)) { // проверяем есть ли у нас уже такой пользователь
				addClient(t_clientName, t_clientSName);
				// тут реализация для первого захода
				t_clientChoise = reader.readChoise();
				System.out.println("Your answer: " + petalDivination(t_clientChoise) + "\n\n");
				deleteChamomiles();
			} else {
				System.out.println("Hello friend");
				if (!checkDate(t_clientName, t_clientSName, today)) { // Проверяем был ли сегодня
					// тут реализация для второго захода
					t_clientChoise = reader.readChoise();
					System.out.println("Your answer: " + petalDivination(t_clientChoise) + "\n\n");
					deleteChamomiles();
				} else {
					System.out.println("No more man\n\n");
				}
			}
		} else {
			System.out.println("Sorry. But I cannot tell fortune without chamomiles");
		}

	}
	
	public void addClient(String name, String sname) {
		clients.add(new Client(name, sname));
	}
	
	public boolean сlientPresented (String name, String sname) {
		
		return clients.contains(new Client(name, sname));
	}

	public boolean checkDate(String name, String sname, LocalDate date) {
		boolean wasToday = false;

		if (!clients.isEmpty()) {
			while (clients.iterator().hasNext()) {
				if (clients.iterator().next().getFirstName().equals(name)
						&& clients.iterator().next().getSecondName().equals(sname)
						&& clients.iterator().next().getDate().equals(date)) {
					wasToday = true;
					break;
				}
			}
		} else {
			wasToday = false;
		}

		return wasToday;
	}

	public void deleteChamomiles() {
		chamomiles.remove(chamomiles.size() - 1);

	}

	public String petalDivination(String divtype) {
		String clientDivination = "";
		int petalsCount = chamomiles.getLast().getPetals().size();
		int divinationCount = divinations.get(divtype).getPredictions().size();
		int temp = 0;

		if (petalsCount > divinationCount) {
			temp = petalsCount % divinationCount;
			clientDivination = divinations.get(divtype).getPredictions().get(temp);
		} else {
			clientDivination = divinations.get(divtype).getPredictions().get(petalsCount - 1);
		}
		return clientDivination;
	}

	public List<Сhamomile> getChamomiles() {
		return chamomiles;
	}

	public void setChamomiles(LinkedList<Сhamomile> chamomiles) {
		this.chamomiles = chamomiles;
	}

	public String getFTellerName() {
		return FTellerName;
	}

	public void setFTellerName(String fTellerName) {
		FTellerName = fTellerName;
	}

	public Map<String, Divination> getDivinations() {
		return divinations;
	}

	public void setDivinations(Map<String, Divination> divinations) {
		this.divinations = divinations;
	}

}
