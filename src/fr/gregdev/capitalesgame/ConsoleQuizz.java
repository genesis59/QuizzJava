/**
 * Affichage du quizz en mode console
 * 
 * Fait par GregDev le 25/10/2121
 */

package fr.gregdev.capitalesgame;

import java.util.Scanner;

public class ConsoleQuizz extends Quizz {

    public ConsoleQuizz() {

	super();
    }

    @Override
    public void displayMessage(String message) {
	System.out.println(message);

    }

    @Override
    public String retrieveAnswer(String message) {

	displayMessage(message);
	Scanner keyboard = new Scanner(System.in);
	String response = keyboard.nextLine();
	return response;

    }

}
