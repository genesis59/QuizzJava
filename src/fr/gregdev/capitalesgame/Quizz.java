package fr.gregdev.capitalesgame;

import java.text.Normalizer;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Quizz {

    protected static final String MESSAGE_REPLAY = "Voulez vous rejouez ? O/N ";
    protected static final String MESSAGE_SCORE = "Votre score est de %s/%s\n";
    protected static final String MESSAGE_QUESTION = "Quelle est la capitale de ce pays: %s";
    protected static final String MESSAGE_CHOICE_GAME = "Choisissez un jeu dans la liste suivante: ";
    protected static final String MESSAGE_CHOICE_NUMBER_QUESTION = "Choisissez le nombre de questions pour le quizz.";
    protected static final String MESSAGE_ERROR_NUMBER_QUESTION = "Le nombre de question ne peut dépasser ";
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

	default:
	    JOptionPane.showMessageDialog(null, MESSAGE_ERROR_GAME);
	    break;
	}
    }

    private static String selectGame() {
	return JOptionPane.showInputDialog(MESSAGE_CHOICE_GAME + GAME_LIST);
    }

    public static String withoutAccent(String s) {
	String strTemp = Normalizer.normalize(s, Normalizer.Form.NFD);
	Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	return pattern.matcher(strTemp).replaceAll("");
    }

}
