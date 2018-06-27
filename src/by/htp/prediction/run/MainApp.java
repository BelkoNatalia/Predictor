package by.htp.prediction.run;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import by.htp.prediction.entity.Client;
import by.htp.prediction.entity.FortuneTeller;

public class MainApp {

	public static void main(String[] args) {
		FortuneTeller ft = new FortuneTeller();
		Client masha = new Client("Masha");
		Client sasha = new Client("Sasha");
		
		
		
		Set<String> listPredications = new HashSet<>();

		listPredications = ft.getPredications();

		for (String predication : listPredications) {
			System.out.println(predication);
		}
		
		System.out.println("****************************");
		
		GregorianCalendar gregorianCalendarR = new GregorianCalendar();
//		gregorianCalendar.set(30, 12, 10);
		
		String testDivination = ft.getDivinationByPredication("love", sasha, gregorianCalendarR);
		System.out.println(testDivination);
		ft.removeClientFromList(sasha);
		
//		gregorianCalendarR.set(2020, 12, 10);
		
//		testDivination = ft.getDivinationByPredication("love", sasha, gregorianCalendarR);
//		ft.removeClientFromList(sasha);

//		gregorianCalendarR.set(2020, 12, 10);
//		
//		testDivination = ft.getDivinationByPredication("love", sasha, gregorianCalendarR);
		

		
//		System.out.println(testDivination);
	}

}