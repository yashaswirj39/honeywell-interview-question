package rest.designpattern.tanksim.randomGenerator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandom {
    public static long generateRandom() {
        Random rand = new Random();
        //return ThreadLocalRandom.current().nextInt();
        return rand.nextInt(50000);
    }
}
