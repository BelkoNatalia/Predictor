package by.htp.prediction.run;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import by.htp.prediction.entity.FortuneTeller;

public class MainApp {

	public static void main(String[] args) {
		FortuneTeller ft = new FortuneTeller();
		Set<String> listPredications = new HashSet<>();

		listPredications = ft.getPredications();

		for(String predication: listPredications) {
			System.out.println(predication);
		}

	}

}