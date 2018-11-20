package controller;

import model.ApiManager;
import model.PairWords;
import view.*;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private Window window;
    private ApiManager apiManager = new ApiManager();
    ArrayList<PairWords> listCollection;
    private int amountWordInDay;
    private int amountPercent;
    private int amountWords;
    private String language;

    public Controller(int amountWordInDay, int amountPercent) {
        this.amountWordInDay = amountWordInDay;
        this.amountPercent = amountPercent;
    }

    public int getAmountWords() {
        return amountWords;
    }

    public void addWordToList(PairWords pairWords) {
        listCollection.add(pairWords);
    }

    public void changeScene(String parentWindow) {
        window.setScene(parentWindow);
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public String translate(String text) {
        try {
            return apiManager.translate(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Exception";
    }

    public void setLanguage(String lang) {
        language = lang;
    }

    public void generateListForTrainning() {

    }
}