/**
 * Gère le déroulement des quizz en fonction d'un mode d'affichage défini
 * Quizz mère
 * 
 * Fait par GregDev le 25/10/2121
 */

package fr.gregdev.capitalesgame;

import fr.gregdev.capitalesgame.generators.CapitaleGenerator;
import fr.gregdev.capitalesgame.generators.MathGenerator;

public abstract class Quizz {

    // TODO variable à transformer
    public static final String GAME_LIST = "(capitale - math)";
    private String game;
    private int numberQuestions;
    private Quizz myQuizz;
    private int maxSizeQuizz;

    protected static final String MESSAGE_REPLAY = "Voulez vous rejouez ? O/N\n Changer de quizz ? C";
    protected static final String MESSAGE_CHOICE_GAME = "Choisissez un jeu dans la liste suivante: ";
    protected static final String MESSAGE_CHOICE_NUMBER_QUESTION = "Choisissez le nombre de questions pour le quizz.";
    protected static final String MESSAGE_ERROR_CHOICE_NUMBER_QUESTION = "le nombre de questions doit être un entier.";
    protected static final String MESSAGE_ERROR_NUMBER_QUESTION = "Le nombre de questions ne peut dépasser ";
    protected static final String MESSAGE_ERROR_GAME = "Désolé ce jeu n'existe pas";
    protected static final String MESSAGE_FINAL = "À bientôt";

    /**
     * constructeur
     */
    public Quizz() {
	this.myQuizz = this;
	this.game = this.selectGame();
	this.numberQuestions = this.selectNumberQuestion();
	this.launchGame(game);
    }

    /**
     * affiche en mode console ou fenêtre
     */
    public abstract void displayMessage(String message);

    /**
     * affiche en mode console ou fenêtre et récupère un réponse utilisateur
     */
    public abstract String retrieveAnswer(String Message);

    /**
     * Choix du quizz
     * 
     * @return
     */
    private String selectGame() {
	String response = this.retrieveAnswer(MESSAGE_CHOICE_GAME + GAME_LIST);
	if (response.equalsIgnoreCase("capitale")) {
	    this.maxSizeQuizz = CapitaleGenerator.MAX_SIZE;
	    return response;
	} else if (response.equalsIgnoreCase("math")) {
	    this.maxSizeQuizz = MathGenerator.MAX_SIZE;
	    return response;
	} else {
	    displayMessage(MESSAGE_ERROR_GAME);
	    return this.selectGame();
	}
    }

    /**
     * Choix du nombre de questions
     * 
     * @return
     */
    private int selectNumberQuestion() {
	try {
	    int userChoice = Integer.parseInt(this.retrieveAnswer(MESSAGE_CHOICE_NUMBER_QUESTION));
	    if (userChoice <= this.maxSizeQuizz) {
		return userChoice;
	    } else {
		displayMessage(MESSAGE_ERROR_NUMBER_QUESTION + this.maxSizeQuizz);
		return this.selectNumberQuestion();
	    }
	} catch (Exception e) {
	    displayMessage(MESSAGE_ERROR_CHOICE_NUMBER_QUESTION);
	    return this.selectNumberQuestion();
	}

    }

    /**
     * Lance l'instance du quizz demandé TODO Méthode à modifier
     * 
     * @param game
     */
    private void launchGame(String game) {

	switch (game) {
	case "capitale":
	    new CapitaleGenerator(this.myQuizz, this.numberQuestions);
	    break;
	case "math":
	    new MathGenerator(this.myQuizz, this.numberQuestions);
	    break;
	}
	this.replay();
    }

    /**
     * Demande si oui ou non le joueur veut continuer ou si il veut changer de quizz
     * TODO Méthode à modifier
     */
    private void replay() {

	char replay = this.retrieveAnswer(MESSAGE_REPLAY).toLowerCase().charAt(0);
	if (replay == 'o') {
	    if (game.equals("math")) {
		new MathGenerator(myQuizz, this.numberQuestions);
	    } else if (game.equals("capitale")) {
		new CapitaleGenerator(myQuizz, this.numberQuestions);
	    }
	    replay();
	} else if (replay == 'c') {
	    myQuizz.WhatAmI();
	} else if (replay == 'n') {
	    displayMessage(MESSAGE_FINAL);
	} else {
	    this.replay();
	}
    }

    public Quizz WhatAmI() {
	if (this instanceof GUIQuizz) {
	    return new GUIQuizz();
	} else {
	    return new ConsoleQuizz();
	}
    }

}
