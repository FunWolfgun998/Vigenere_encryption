package org.example;

import static java.lang.IO.println;
import static java.lang.IO.readln;

public class Main {

    static void main(){
        int keysize;
        while (true) {
            try {
                keysize = Integer.parseInt(readln("Insert key size: ").trim());
                if (keysize > 0) {
                    break;
                }
                println("Error: key size must be bigger than 0");
            } catch (NumberFormatException e) {
                println("Error: invalid input, try putting a positive number (5, 9, 10...)");
            }
        }
        int[] key = getKey(keysize);
        boolean encrypt;

        while (true) {
            String input = readln("Want to encrypt (E) or decrypt (D) the messagge? ").trim().toUpperCase();

            if ("E".equals(input)) {
                encrypt = true;
                break;
            } else if ("D".equals(input)) {
                encrypt = false;
                break;
            }

            println("Invalid input");
        }
        String message = readln("Insert message: ");
        String output ="";
        if (encrypt) {
            output = Vigenere.encrypt(key,message);
        } else {
            output = Vigenere.decrypt(key,message);
        }
        println(output);
    }

    static public int[] getKey(int keySize){
        int[] key = new int [keySize];
        for(int i = 0; i < keySize; i++) {
            Integer keyValue;
            while (true) {
                try {
                    keyValue = Integer.parseInt(readln("Insert key value: ").trim());
                    if (keyValue != null) {
                        key[i]=keyValue;
                        break;
                    }
                } catch (NumberFormatException e) {
                    println("Invalid input, try putting a number (5, -9, 10...)");
                }
            }
        }
        return (key);
    }
}

