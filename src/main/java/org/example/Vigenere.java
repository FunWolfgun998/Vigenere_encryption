package org.example;

public class Vigenere {
    public static String encrypt(int[] key, String message){
        if (key == null || key.length == 0 || message == null) {
            return "";
        }
        int k= 0;
        char[] originalMessagge = message.toCharArray();
        char[] encryptedMessage = new char[originalMessagge.length];
        for (int i = 0; i<originalMessagge.length; i++) {
            char letter = originalMessagge[i];
            if(letter<32||letter>126){
                encryptedMessage[i] = letter;
                continue;
            }
            char encryptedLetter = (char) (32 + ((letter - 32 + key[k++%key.length]) % 95));
            encryptedMessage[i] = encryptedLetter;
        }
        return encryptedMessage.toString();
    }
    public static String decrypt(int[] key, String message){
        if (key == null || key.length == 0 || message == null) {
            return "";
        }
        int k= 0;
        char[] originalMessagge = message.toCharArray();
        char[] decryptedMessage = new char[originalMessagge.length];
        for (int i = 0; i<originalMessagge.length; i++) {
            char letter = originalMessagge[i];
            if(letter<32||letter>126){
                decryptedMessage[i] = letter;
                continue;
            }
            char dencryptedLetter =(char) (32 + Math.floorMod(letter - 32 - key[k % key.length], 95));
            decryptedMessage[i] = dencryptedLetter;
        }
        return decryptedMessage.toString();
    }
}
