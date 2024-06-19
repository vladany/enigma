package org.example;

public class Main {
    public static void main(String[] args) {

        Enigma enigma = new Enigma();

        enigma.initRotor1();
        enigma.initRotor2();
        enigma.initRotor3();
        enigma.initReflector();
        enigma.initInput();

        System.out.println("initialization done");

        enigma.getValueForLetter('A');

    }
}
