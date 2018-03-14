package com.example.ryanhillier.passwordvalidator;

import android.app.Activity;

import java.util.regex.Pattern;

public class Validator extends Activity {

    public static int validatePasswordS1(String password) {
        //Initialize count
        int count= 0;

        // check if string is not password
        if (!password.equalsIgnoreCase("PASSWORD")) {
            count++;
        }

        // Check if string is atleast 8 character long
        if (password.length() >= 8) {
            count++;
        }

        return count;
    }

    public static int validatePasswordS2(String password) {
        int count = 0;

        // Checks if first stage was passed
        count += validatePasswordS1(password);

        // check if string contains at-least one special character
        if (password.indexOf('!') != -1 || password.indexOf('@') != -1
                || password.indexOf('#') != -1 || password.indexOf('&') != -1
                || password.indexOf('*') != -1) {
            count++;
        }

        // Check if string has atleast one digit
        if (Pattern.compile("[0-9]").matcher(password).find()) {
            count++;
        }

        // Check if string has both upper and lower case characters
        if (Pattern.compile("[a-z]").matcher(password).find() && Pattern.compile("[A-Z]").matcher(password).find() ) {
            count++;
        }

        return count;
    }
}





