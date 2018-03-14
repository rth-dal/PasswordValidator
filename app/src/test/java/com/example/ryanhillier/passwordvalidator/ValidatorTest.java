package com.example.ryanhillier.passwordvalidator;

import android.app.Activity;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorTest extends Activity {

    @Test
    public void testStage1() {
        // Rules:
        // - it is not “password” (case insensitive)
        // - it is at least 8 characters long

        assertEquals(Validator.validatePasswordS1("passWORD"), 1);
        assertEquals(Validator.validatePasswordS1("ABC"), 1);
        assertEquals(Validator.validatePasswordS1("ALongPass"), 2);
    }

    @Test
    public void testStage2() {
        // Rules:
        // 1 - it is not “password” (case insensitive)
        // 2 - it is at least 8 characters long
        // 3 - at least one special character
        // 4 - at least one digit
        // 5 - at least one upper and lower case character

        assertEquals(Validator.validatePasswordS2("CSCi"), 2);

        assertEquals(Validator.validatePasswordS2("CScI21"), 3);

        assertEquals(Validator.validatePasswordS2("BitL0nger"), 4);

        assertEquals(Validator.validatePasswordS2("soclose@12"), 4);

        assertEquals(Validator.validatePasswordS2("CSCI3110@a"), 5);
    }
}