package fr.gregdev.capitalesgame;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class QuizzMath extends Quizz implements QuizzInterface {

    private final String MESSAGE_QUESTION = "Quelle est le résultat de cette opération: %s";
    private final ArrayList<String> MATH_LIST = this.getListQuizz();
    private final int MATH_LIST_SIZE = MATH_LIST.size();
    private int numberQuestions;
    private int score;

    public QuizzMath() {
	this.numberQuestions = Quizz.selectNumberQuestion();
	this.launch();
    }

    @Override
    public void launch() {
	if (this.numberQuestions <= MATH_LIST_SIZE) {
	    game(this.numberQuestions);
	    Quizz.replay();
	} else {
	    JOptionPane.showMessageDialog(null, Quizz.MESSAGE_ERROR_NUMBER_QUESTION + MATH_LIST_SIZE);
	    new QuizzMath();
	}
    }

    @Override
    public void game(int numberQuestions) {
	// random table of questions and response
	ArrayList<String> listQuizz = Quizz.getRandomTab(MATH_LIST, numberQuestions);

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
	// TODO Mettre la methode dans la classe mere
	ArrayList<String> tab = new ArrayList<String>();
	tab.addAll(Arrays.asList("1+1:2", "3*4:12", "8+8:16", "8*8:64", "25+25:50", "14-8:6", "12-2:10", "20*10:200",
		"35+35:70", "12/6:2"));
	return tab;
    }

}
