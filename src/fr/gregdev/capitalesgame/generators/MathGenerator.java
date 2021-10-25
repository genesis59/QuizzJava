/**
 * Générateur du quizz math
 * 
 * Fait par GregDev le 25/10/2121
 */

package fr.gregdev.capitalesgame.generators;

import java.util.ArrayList;
import java.util.Arrays;

import fr.gregdev.capitalesgame.Quizz;

public class MathGenerator extends Generator {

    public static final int MAX_SIZE = 10;

    /**
     * constructeur
     * 
     * @param numberQuestions
     */
    public MathGenerator(Quizz myQuizz, int numberQuestions) {
	super(myQuizz, numberQuestions);
    }

    /**
     * Retourne la liste complète des questions/réponses du quizz math
     */
    @Override
    public ArrayList<String> getListQuizz() {

	// TODO récupération de la liste à partir d'un fichier
	ArrayList<String> tab = new ArrayList<String>();
	tab.addAll(Arrays.asList("1+1:2", "3*4:12", "8+8:16", "8*8:64", "25+25:50", "14-8:6", "12-2:10", "20*10:200",
		"35+35:70", "12/6:2"));
	return tab;
    }

}
