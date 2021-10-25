/**
 * Générateur mère
 * 
 * Fait par GregDev le 25/10/2121
 */

package fr.gregdev.capitalesgame.generators;

import java.util.ArrayList;

import fr.gregdev.capitalesgame.Quizz;
import fr.gregdev.capitalesgame.utils.SpecialFormat;

public abstract class Generator {

    private int numberQuestions;
    private int score;
    private final String MESSAGE_QUESTION = "Quelle est la capitale de ce pays: %s";
    private Quizz myQuizz;

    protected static final String MESSAGE_SCORE = "Votre score est de %s/%s\nVotre temps de réponse est de %d s";
    protected static final String MESSAGE_BAD_ANSWER = "Perdu! La bonne réponse est : ";
    protected static final String MESSAGE_GOOD_ANSWER = "Bravo! c'est la bonne réponse";
    protected static final String MESSAGE_ERROR_NUMBER_QUESTION = "Le nombre de questions ne peut dépasser ";

    /**
     * constructeur
     * 
     * @param numberQuestions
     */
    public Generator(Quizz myQuizz, int numberQuestions) {
	this.myQuizz = myQuizz;
	this.numberQuestions = numberQuestions;
	start(this.numberQuestions);
    }

    /**
     * Retourne la liste complète des questions/réponses du quizz demandé
     */
    public abstract ArrayList<String> getListQuizz();

    /**
     * process du quizz lors des réponses de l'utilisateur
     * 
     * @param numberQuestions
     */
    public void start(int numberQuestions) {

	ArrayList<String> listQuizz = this.getRandomTab(this.getListQuizz(), numberQuestions);
	long startTime = System.currentTimeMillis();
	askQuestions(numberQuestions, listQuizz);
	long endTime = System.currentTimeMillis();
	this.myQuizz.displayMessage(String.format(MESSAGE_SCORE, score, numberQuestions, (endTime - startTime) / 1000));
    }

    /**
     * prépare les questions/réponses et vérifie la véracité de la réponse
     * utilisateur
     * 
     * @param numberQuestions
     * @param listQuizz
     */
    private void askQuestions(int numberQuestions, ArrayList<String> listQuizz) {

	for (int i = 0; i < numberQuestions; i++) {
	    String[] tabQuestionReponse = listQuizz.get(i).split(":");
	    String response = SpecialFormat.withoutAccent(
		    this.myQuizz.retrieveAnswer(String.format(this.MESSAGE_QUESTION, tabQuestionReponse[0])).trim());
	    if (response.equalsIgnoreCase(SpecialFormat.withoutAccent(tabQuestionReponse[1]))) {
		this.myQuizz.displayMessage(MESSAGE_GOOD_ANSWER);
		this.score++;
	    } else {
		this.myQuizz.displayMessage(MESSAGE_BAD_ANSWER + tabQuestionReponse[1]);
	    }
	}
    }

    /**
     * Génère le tableau de questions réponses aléatoire
     * 
     * @param arrayList
     * @param numberQuestions
     * @return
     */
    private ArrayList<String> getRandomTab(ArrayList<String> arrayList, int numberQuestions) {

	ArrayList<String> tabRandom = new ArrayList<String>();
	ArrayList<String> tabList = arrayList;

	for (int i = 0; i < numberQuestions; i++) {
	    int random = (int) (Math.random() * (tabList.size() - 1));
	    tabRandom.add(tabList.get(random));
	    tabList.remove(tabList.get(random));
	}
	return tabRandom;
    }

}
