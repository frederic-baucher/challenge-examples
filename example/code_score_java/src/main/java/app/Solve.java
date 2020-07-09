package app;

import java.util.concurrent.ThreadLocalRandom;

import io.deadlock.mission.client.Mission;
import template.Score;

public class Solve {

    public static void main(String[] args) {
        try {
            int userResult = Score.main();
            System.out.println("Current score: " + userResult);
            if (userResult > 90) {
                Logger.logSuccess();
            }
            Mission.INSTANCE.done(userResult);

        } catch (Exception e) {
            Logger.logException(e);
            Mission.INSTANCE.done(0);
            System.exit(1);
        }
    }
}
