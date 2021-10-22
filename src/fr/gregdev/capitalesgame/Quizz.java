package fr.gregdev.capitalesgame;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Quizz {
	private int score;

	public void quizzCapitales(int numberQuestions) {
		Scanner clavier = new Scanner(System.in);
		QuizzCapitale quizzCapitale = new QuizzCapitale(numberQuestions);
		ArrayList<String> listQuizz = quizzCapitale.getRandomTabCountryCapitales();
		for (int i = 0; i < numberQuestions; i++) {

			String[] tabQuestionReponse = listQuizz.get(i).split(":");
			System.out.printf("Quelle est la capitale du pays suivant: %s\n", tabQuestionReponse[0]);
			String response = sansAccent(clavier.nextLine().trim());
			System.out.println();
			if (response.equalsIgnoreCase(sansAccent(tabQuestionReponse[1]))) {
				this.score++;
			}

		}
		System.out.printf("Votre score es de %s/%s", score, numberQuestions);
		clavier.close();
	}

	public int getScore() {
		return score;
	}

	public static String sansAccent(String s) {

		String strTemp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(strTemp).replaceAll("");
	}

}
