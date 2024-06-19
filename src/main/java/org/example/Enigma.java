package org.example;

import java.util.HashMap;
import java.util.Map;

public class Enigma {

    private Map<Character, Character> rotor1 = new HashMap<>();

    private Map<Character, Character> rotor2 = new HashMap<>();

    private Map<Character, Character> rotor3 = new HashMap<>();

    private Map<Character, Character> reflector = new HashMap<>();

    private Map<Character, Character> input = new HashMap<>();

    /**
     * rotor3  Map [ K ] - [ X ]
     **/

    String alphabetRotor3 = "IJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGH";
    String keyRotor3 = "AJDKSIRUXBLHWTMCQGUNPYFVOEAJDKSIRUXBLHWTMCQGZNPYFVOE";

    public void initRotor3() {
        for (int i = 0; i < 26; i++) {
            rotor3.put(alphabetRotor3.charAt(i), keyRotor3.charAt(i));
        }
    }

    /**
     * rotor2 Map [ C ] - [ D ]
     **/

    String alphabet2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String keyRotor2 = "NTOWYHJXUSPAIBRCJEKMFLGDQVZNTOWYHXUSPAIBRCJEKMFLGDQVZ";

    public void initRotor2() {
        for (int i = 0; i < 26; i++) {
            rotor2.put(alphabet2.charAt(i), keyRotor2.charAt(i));
        }
    }

    /**
     * rotor2 Map [ C ] - [ D ]
     **/

    String alphabetREF =  "MNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKL";
    String keyReflector = "ABCDEFGDIJKGMKMIEBFTCVVJATABCDEFGDIJKGMKMIEBFTCVVJAT";

    public void initRotor1() {
        for (int i = 0; i < 26; i++) {
            rotor1.put(alphabetREF.charAt(i), keyReflector.charAt(i));
        }
    }

    public void initReflector() {
        for (int i = 0; i < 26; i++) {
            reflector.put(alphabetREF.charAt(i), keyReflector.charAt(i));
        }
    }


    /**
     * input
     **/

    String inputChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String rotor3Input = "XVZNYEIWGAKMUSQOBDFHJLCPRTXVZNYEIWGAKMUSQOBDFHJLCPRT";

    public void initInput() {
        for (int i = 0; i < 26; i++) {
            input.put(inputChars.charAt(i), rotor3Input.charAt(i));
        }
    }

    public char getValueForLetter(char letter) {
        char inputKey = input.get(letter);
        System.out.println("erstes : " + letter + " sein paar " + inputKey);

        char rotor3Key = rotor3.get(inputKey);
        System.out.println("root 3  : " + inputKey + " sein paar " + rotor3Key);

        char rotor2Key = rotor2.get(rotor3Key);
        System.out.println("root 2 : " + rotor3Key + " sein paar " + rotor2Key);

        char rotor1KeyRefl = rotor1.get(rotor2Key);
        System.out.println("root 1: " + rotor2Key + " sein paar " + rotor1KeyRefl);

        char reflBackwards = reflector.get(rotor1KeyRefl);

        System.out.println("reflector: " + rotor1KeyRefl + " sein paar " + reflBackwards);

        return rotor1KeyRefl;
    }
}
