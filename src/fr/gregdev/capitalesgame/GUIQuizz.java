/**
 * Affichage du quizz en mode graphique
 * 
 * Fait par GregDev le 25/10/2121
 */

package fr.gregdev.capitalesgame;

import javax.swing.JOptionPane;

public class GUIQuizz extends Quizz {

    public GUIQuizz() {
	super();
    }

    @Override
    public void displayMessage(String message) {
	JOptionPane.showMessageDialog(null, message);

    }

    @Override
    public String retrieveAnswer(String message) {
	return JOptionPane.showInputDialog(message);
    }

}
