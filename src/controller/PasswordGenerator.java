package controller;

import java.util.ArrayList;
import java.util.Random;

/**
 * Author: Michael Rizzoni
 */
public class PasswordGenerator {

    static final int DEFAULT_LENGTH = 15;
    static final char[] SPECIALS = {'\\', '/', '(', ')', '?', '*', '&', '^', '%', '$', '#', '@', '!', ';', ':', '-', '+', '=', '_'};
    static final Random RANDOM = new Random();

    int length;
    boolean hasUpper;
    boolean hasSpecial;
    boolean hasNum;
    ArrayList<Character> symbols;

    public PasswordGenerator() {
        this.length = DEFAULT_LENGTH;
        this.hasUpper = true;
        this.hasSpecial = false;
        this.hasNum = true;
        this.symbols = new ArrayList<>(64);
        this.setSymbols();
    }

    public PasswordGenerator(int length, boolean hasUpper, boolean hasSpecial, boolean hasNum) {
        this.length = length;
        this.hasUpper = hasUpper;
        this.hasSpecial = hasSpecial;
        this.hasNum = hasNum;
        this.symbols = new ArrayList<>(64);
        this.setSymbols();
    }

    public String generatePassword() {

        String pass = "";

        for(int i = 0; i < this.length; i++) {
            pass += this.symbols.get(RANDOM.nextInt(this.symbols.size()));
        }

        return pass;
    }

    private void setSymbols() {
        for(int i = 97; i < 123; i++) {
            this.symbols.add((char) i);
        }

        if(this.hasUpper) {
            for(int i = 65; i < 91; i++) {
                this.symbols.add((char) i);
            }
        }

        if(this.hasSpecial) {
            for(int i = 0; i < SPECIALS.length; i++) {
                this.symbols.add(SPECIALS[i]);
            }
        }

        if(this.hasNum) {
            for(int i = 48; i < 59; i++) {
                this.symbols.add((char) i);
            }
        }

    }
    
}
