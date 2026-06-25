package com.example.navigation.util;

import java.util.concurrent.ThreadLocalRandom;

public class UserUtil {
    public static String generateAccount(String front) {
        int suffix = ThreadLocalRandom.current().nextInt(0, 100000);
        return front + String.format("%05d", suffix);
    }
}
