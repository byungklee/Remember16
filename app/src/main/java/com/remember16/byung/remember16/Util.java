package com.remember16.byung.remember16;

import java.util.Random;

/**
 * Created by byung on 12/19/14.
 */
public class Util {
    private static Random random = new Random();
    public static int getRandomInt(int i) {
        return random.nextInt(i);
    }

    public static String getRandomOperator() {
        int choice = random.nextInt(4);
        if(choice == 0) {
            return "+";
        } else if(choice == 1) {
            return "-";
        } else if(choice == 2) {
            return "*";
        } else
            return "/";
    }
}
