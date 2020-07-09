package app;

import template.Score;

public class Run {

    public static void main(String[] args) {
        try {
            Logger.log("Current score: " + Score.main());
        } catch (Exception e) {
            Logger.logException(e);
        }
    }
}
