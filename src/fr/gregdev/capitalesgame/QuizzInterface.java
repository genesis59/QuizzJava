package fr.gregdev.capitalesgame;

import java.util.ArrayList;

public interface QuizzInterface {

    public void launch();

    public void game(int numberQuestions);

    public void replay();

    public int selectNumberQuestion();

    public ArrayList<String> getRandomTab();

    public ArrayList<String> getListQuizz();

}
