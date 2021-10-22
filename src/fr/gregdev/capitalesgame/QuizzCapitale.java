package fr.gregdev.capitalesgame;

import java.util.ArrayList;
import java.util.Arrays;

public class QuizzCapitale {

	private ArrayList<String> countriesCapitalesList;
	private int numberQuestions;

	public QuizzCapitale(int numberQuestions) {
		this.countriesCapitalesList = createTabCountryCapitales();
		if (numberQuestions <= this.countriesCapitalesList.size()) {
			this.numberQuestions = numberQuestions;
		} else {
			throw new IllegalArgumentException(
					"Le nombre de question ne peut dépasser " + this.countriesCapitalesList.size());
		}
	}

	private static ArrayList<String> createTabCountryCapitales() {

		ArrayList<String> tab = new ArrayList<String>();
		tab.addAll(Arrays.asList("France:Paris", "Espagne:Madrid", "Portugal:Lisbonne", "Allemagne:Berlin",
				"Grèce:Athènes", "Italie:Rome"));
		return tab;
	}

	public ArrayList<String> getRandomTabCountryCapitales() {

		ArrayList<String> tabRandom = new ArrayList<String>();
		ArrayList<String> tabList = this.countriesCapitalesList;

		for (int i = 0; i < this.numberQuestions; i++) {
			int random = (int) (Math.random() * (tabList.size() - 1));
			tabRandom.add(tabList.get(random));
			tabList.remove(tabList.get(random));

		}

		return tabRandom;
	}

	public ArrayList<String> getCountriesCapitalesList() {
		return countriesCapitalesList;
	}

}
