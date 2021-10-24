package fr.gregdev.capitalesgame;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class QuizzCapitale extends Quizz implements QuizzInterface {

    private final String MESSAGE_QUESTION = "Quelle est la capitale de ce pays: %s";
    private final ArrayList<String> COUNTRIES_CAPITALES_LIST = this.getListQuizz();
    private final int COUNTRIES_CAPITALES_LIST_SIZE = COUNTRIES_CAPITALES_LIST.size();
    private int numberQuestions;
    private int score;

    public QuizzCapitale() {
	this.numberQuestions = Quizz.selectNumberQuestion();
	this.launch();
    }

    @Override
    public void launch() {
	if (this.numberQuestions <= COUNTRIES_CAPITALES_LIST_SIZE) {
	    game(this.numberQuestions);
	    Quizz.replay();
	} else {
	    JOptionPane.showMessageDialog(null, Quizz.MESSAGE_ERROR_NUMBER_QUESTION + COUNTRIES_CAPITALES_LIST_SIZE);
	    new QuizzCapitale();
	}
    }

    @Override
    public void game(int numberQuestions) {

	// random table of questions and response
	ArrayList<String> listQuizz = Quizz.getRandomTab(COUNTRIES_CAPITALES_LIST, numberQuestions);
	long startTime = System.currentTimeMillis();
	for (int i = 0; i < numberQuestions; i++) {
	    String[] tabQuestionReponse = listQuizz.get(i).split(":");
	    String response = Quizz.withoutAccent(
		    JOptionPane.showInputDialog(String.format(this.MESSAGE_QUESTION, tabQuestionReponse[0])).trim());
	    if (response.equalsIgnoreCase(Quizz.withoutAccent(tabQuestionReponse[1]))) {
		this.score++;
	    }
	}
	long endTime = System.currentTimeMillis();
	JOptionPane.showMessageDialog(null,
		String.format(Quizz.MESSAGE_SCORE, score, numberQuestions, (endTime - startTime) / 1000));
    }

    @Override
    public ArrayList<String> getListQuizz() {
	// TODO récupération de la liste à partir d'un fichier
	ArrayList<String> tab = new ArrayList<String>();
	tab.addAll(Arrays.asList("France:Paris", "Espagne:Madrid", "Portugal:Lisbonne", "Allemagne:Berlin",
		"Grèce:Athènes", "Italie:Rome", "Angleterre:Londres", "Algérie:Alger", "Japon:Tokyo",
		"Corée du sud:Séoul"));
	return tab;
    }

}
