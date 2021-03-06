package by.htp.prediction.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class FortuneTeller {
	private LinkedHashMap<String, Queue<String>> divinations = new LinkedHashMap<>();
	private PriorityQueue<Client> clients = new PriorityQueue<Client>();


	private int maxClients = 10;
	private int count = 0;
	private GregorianCalendar gregorianCalendar = new GregorianCalendar();

	public FortuneTeller() {
		Queue<String> loveList = new LinkedList<>();
		loveList.add("You fall in love with you boss");
		loveList.add("You find a love in the journey");
		loveList.add("Your neighbor is in love with you ");
		loveList.add("If you dress yellow shoes tomorrow you will meet your love ");
		loveList.add("Love only on Wednesdays");
		loveList.add("Fall in love and marry");
		divinations.put("love", loveList);

		Queue<String> babyList = new LinkedList<>();
		babyList.add("Baby girl");
		babyList.add("Baby boy");
		babyList.add("Twins");
		babyList.add("You will have 18 children ");
		babyList.add("One boy and five girls");
		babyList.add("One boy and one girl");
		divinations.put("baby", babyList);
	}

	public GregorianCalendar getGregorianCalendar() {
		return gregorianCalendar;
	}

	public void setGregorianCalendar(GregorianCalendar gregorianCalendar) {
		this.gregorianCalendar = gregorianCalendar;
	}

	public Set<String> getPredications() {
		Set<String> keys = divinations.keySet();
		return keys;
	}

	public String getDivinationByPredication(String predication, Client client, GregorianCalendar gregorianCalendarRequest) {
		int weekRequest = gregorianCalendarRequest.get(Calendar.WEEK_OF_YEAR);
		int dayRequest = gregorianCalendarRequest.get(Calendar.DATE);

		int currentWeek = this.gregorianCalendar.get(Calendar.WEEK_OF_YEAR);
		int currentDay = this.gregorianCalendar.get(Calendar.DATE);

		if (dayRequest == currentDay) {
			count = count + 1;
		} else {
			count = 0;
		}

		if (count == maxClients) {
			clients.add(client);
			return client.getName() + " was added in wait list!";
		}

		if (currentWeek == weekRequest) {
			if (!clients.contains(client)) {
				String result = doPredication(predication);
				clients.add(client);
				return result;
			} else {
				return client.getName() + ", you are in the wait list!";
			}
		} else {
			clients.clear();
			
			String result = doPredication(predication);
			clients.add(client);
			return result;
		}
	}
	
	public String doPredication(String predication) {
		Queue<String> list = divinations.get(predication);
		Queue<String> listCopy = new LinkedList<>(list);
		Integer sizeList = listCopy.size();
		int randomNumber = ((int) (Math.random() * sizeList)) - 1;
		for (int i = 0; i < randomNumber; i++) {
			listCopy.poll();
		}
		String result = listCopy.peek();
		return result;
	}
	
	public PriorityQueue<Client> getClients() {
		return clients;
	}
	
	public boolean removeClientFromList(Client client) {
		boolean removeResult = clients.remove(client);
		return removeResult;
	}
	
}
