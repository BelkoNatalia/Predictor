package by.htp.prediction.entity;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class FortuneTeller {
	LinkedHashMap<String, Queue<String>> divinations = new LinkedHashMap<>();
	PriorityQueue<Client> clients = new PriorityQueue<Client>();
	int maxClients = 10;
	
	public FortuneTeller() {
		LinkedList<String> loveList = new LinkedList<>();
		loveList.add("Yes");
		loveList.add("No");
		loveList.add("Mayby");
		divinations.put("love", loveList);
		
		LinkedList<String> babyList = new LinkedList<>();
		babyList.add("One");
		babyList.add("Two");
		babyList.add("no baby");
		divinations.put("baby", babyList);
	}



	public Set<String> getPredications() {
		return divinations.keySet();
	}
}
