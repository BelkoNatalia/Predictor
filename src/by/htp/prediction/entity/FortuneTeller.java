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
		loveList.add("No");
		loveList.add("Yes");
		loveList.add("Mayby");
		loveList.add("No-1");
		loveList.add("Yes-1");
		loveList.add("Mayby-1");
		divinations.put("love", loveList);

		Queue<String> babyList = new LinkedList<>();
		babyList.add("One");
		babyList.add("Two");
		babyList.add("no baby");
		babyList.add("One-1");
		babyList.add("Two-1");
		babyList.add("no baby-1");
		divinations.put("baby", babyList);
	}

	public GregorianCalendar getGregorianCalendar() {
		return gregorianCalendar;
	}

	public void setGregorianCalendar(GregorianCalendar gregorianCalendar) {
		this.gregorianCalendar = gregorianCalendar;
	}

	public Set<String> getPredications() {
		return divinations.keySet();
	}

	public String getDivinationByPredication(String predication, Client client, GregorianCalendar gregorianCalendar) {
		int week = gregorianCalendar.get(Calendar.WEEK_OF_YEAR);
		int day = gregorianCalendar.get(Calendar.DATE);

		int currentWeek = this.gregorianCalendar.get(Calendar.WEEK_OF_YEAR);
		int currentDay = this.gregorianCalendar.get(Calendar.DATE);

		if (day == currentDay) {
			count = count + 1;
		} else {
			count = 0;
		}

		if (count == maxClients) {
			clients.add(client);
			return client.getName() + " was added in wait list!";
		}

		if (currentWeek == week) {
			if (!clients.contains(client)) {
				Queue<String> list = divinations.get(predication);
				Queue<String> listCopy = new LinkedList<>(list);

				Integer sizeList = listCopy.size();
				int randomNumber = ((int) (Math.random() * sizeList)) - 1;
				for (int i = 0; i < randomNumber; i++) {
					listCopy.poll();
				}
				String result = listCopy.peek();
				return result;
			} else {
				clients.add(client);
				return client.getName() + "there is in wait list!";
			}
		} else {
			clients.clear();

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
	}
}
