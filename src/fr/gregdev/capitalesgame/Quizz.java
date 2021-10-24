package fr.gregdev.capitalesgame;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Quizz {

    protected static final String MESSAGE_REPLAY = "Voulez vous rejouez ? O/N\n Changer de quizz ? C";
    protected static final String MESSAGE_SCORE = "Votre score est de %s/%s\nVotre temps de réponse est de %d s";
    protected static final String MESSAGE_CHOICE_GAME = "Choisissez un jeu dans la liste suivante: ";
    protected static final String MESSAGE_CHOICE_NUMBER_QUESTION = "Choisissez le nombre de questions pour le quizz.";
    protected static final String MESSAGE_ERROR_NUMBER_QUESTION = "Le nombre de questions ne peut dépasser ";
    protected static final String MESSAGE_ERROR_GAME = "Désolé ce jeu n'existe pas";
    protected static final String MESSAGE_FINAL = "À bientôt";

    public static final String GAME_LIST = "(capitale - math)";

    public void launch() {
	Quizz.launchGame(Quizz.selectGame());
    }

    private static void launchGame(String game) {
	switch (game) {
	case "capitale":
	    new QuizzCapitale();
	    break;
	case "math":
	    new QuizzMath();
	    break;

	default:
	    JOptionPane.showMessageDialog(null, MESSAGE_ERROR_GAME);
	    Quizz.launchGame(Quizz.selectGame());
	    break;
	}
    }

    private static String selectGame() {
	return JOptionPane.showInputDialog(MESSAGE_CHOICE_GAME + GAME_LIST);
    }

    public static void replay() {
	String replay = JOptionPane.showInputDialog(null, Quizz.MESSAGE_REPLAY);
	if (replay.equalsIgnoreCase("O")) {
	    new QuizzMath();
	} else if (replay.equalsIgnoreCase("C")) {
	    new Quizz().launch();
	} else if (replay.equalsIgnoreCase("N")) {
	    JOptionPane.showMessageDialog(null, Quizz.MESSAGE_FINAL);
	} else {
	    Quizz.replay();
	}
    }

    public static ArrayList<String> getRandomTab(ArrayList<String> arrayList, int numberQuestions) {

	ArrayList<String> tabRandom = new ArrayList<String>();
	ArrayList<String> tabList = arrayList;

	for (int i = 0; i < numberQuestions; i++) {
	    int random = (int) (Math.random() * (tabList.size() - 1));
	    tabRandom.add(tabList.get(random));
	    tabList.remove(tabList.get(random));
	}
	return tabRandom;
    }

    public static int selectNumberQuestion() {
	return Integer.parseInt(JOptionPane.showInputDialog(MESSAGE_CHOICE_NUMBER_QUESTION));
    }

    public static String withoutAccent(String s) {
	String strTemp = Normalizer.normalize(s, Normalizer.Form.NFD);
	Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	return pattern.matcher(strTemp).replaceAll("");
    }

}
