package controller;

import java.util.ArrayList;
import java.util.Random;

public class PasswordGenerator {

    final int DEFAULT_LENGTH = 15;
    final char[] SPECIALS = {'\\', '/', '(', ')', '?', '*', '&', '^', '%', '$', '#', '@', '!', ';', ':', '-', '+', '=', '_'};
    final Random RANDOM = new Random();

    int length;
    boolean hasUpper;
    boolean hasSpecial;
    boolean hasNum;
    ArrayList<Character> symbols;

    public PasswordGenerator() {
        this.length = 10;
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
            pass += this.symbols.get(this.RANDOM.nextInt(this.symbols.size()));
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
            for(int i = 0; i < this.SPECIALS.length; i++) {
                this.symbols.add(this.SPECIALS[i]);
            }
        }

        if(this.hasNum) {
            for(int i = 48; i < 59; i++) {
                this.symbols.add((char) i);
            }
        }

    }

}
