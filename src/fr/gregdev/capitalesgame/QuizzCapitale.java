package fr.gregdev.capitalesgame;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class QuizzCapitale extends Quizz implements QuizzInterface {

    private final ArrayList<String> COUNTRIES_CAPITALES_LIST = this.getListQuizz();
    private final int COUNTRIES_CAPITALES_LIST_SIZE = COUNTRIES_CAPITALES_LIST.size();
    private int numberQuestions;
    private int score;

    public QuizzCapitale() {
	this.numberQuestions = this.selectNumberQuestion();
	this.launch();
    }

    @Override
    public void launch() {
	if (this.numberQuestions <= COUNTRIES_CAPITALES_LIST_SIZE) {
	    game(this.numberQuestions);
	    replay();
	} else {
	    JOptionPane.showMessageDialog(null, Quizz.MESSAGE_ERROR_NUMBER_QUESTION + COUNTRIES_CAPITALES_LIST_SIZE);
	    new QuizzCapitale();
	}
    }

    @Override
    public void game(int numberQuestions) {

	// random table of questions and response
	ArrayList<String> listQuizz = this.getRandomTab();

	for (int i = 0; i < numberQuestions; i++) {
	    String[] tabQuestionReponse = listQuizz.get(i).split(":");
	    String response = Quizz.withoutAccent(
		    JOptionPane.showInputDialog(String.format(Quizz.MESSAGE_QUESTION, tabQuestionReponse[0])).trim());
	    if (response.equalsIgnoreCase(Quizz.withoutAccent(tabQuestionReponse[1]))) {
		this.score++;
	    }
	}
	JOptionPane.showMessageDialog(null, String.format(Quizz.MESSAGE_SCORE, score, numberQuestions));
    }

    @Override
    public void replay() {

	String replay = JOptionPane.showInputDialog(null, Quizz.MESSAGE_REPLAY);
	if (replay.equalsIgnoreCase("O")) {
	    new QuizzCapitale();
	} else {
	    JOptionPane.showMessageDialog(null, Quizz.MESSAGE_FINAL);

	}
    }

    @Override
    public int selectNumberQuestion() {
	return Integer.parseInt(JOptionPane.showInputDialog(MESSAGE_CHOICE_NUMBER_QUESTION));
    }

    @Override
    public ArrayList<String> getListQuizz() {
	// TODO r�cup�ration de la liste � partir d'un fichier
	ArrayList<String> tab = new ArrayList<String>();
	tab.addAll(Arrays.asList("France:Paris", "Espagne:Madrid", "Portugal:Lisbonne", "Allemagne:Berlin",
		"Gr�ce:Ath�nes", "Italie:Rome", "Angleterre:Londres", "Alg�rie:Alger", "Japon:Tokyo",
		"Cor�e du sud:S�oul"));
	return tab;
    }

    @Override
    public ArrayList<String> getRandomTab() {

	ArrayList<String> tabRandom = new ArrayList<String>();
	ArrayList<String> tabList = COUNTRIES_CAPITALES_LIST;

	for (int i = 0; i < this.numberQuestions; i++) {
	    int random = (int) (Math.random() * (tabList.size() - 1));
	    tabRandom.add(tabList.get(random));
	    tabList.remove(tabList.get(random));
	}
	return tabRandom;
    }

}
