package com.hva.lcs.util;

import java.util.Random;

public class RandomUtil {
    
    public static String getRandomLengthString(char letter) {
        int length = new Random().nextInt(5);
        String result = "";
        for (int i = 0; i < length; i++) {
            result += letter;
        }
        return result;
    }
    
}
