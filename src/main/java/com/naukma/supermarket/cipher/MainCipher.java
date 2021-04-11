package com.naukma.supermarket.cipher;

public class MainCipher {

    // a123 f123
    private final static String PASSWORD = "f123";
    private final static String SECRETKEY = "fifi!fifi!!";

    public static String encryptMessage() {

        String encryptedString = AES.encrypt(PASSWORD, SECRETKEY);
        System.out.println("Original unique message is: " + PASSWORD);
        System.out.println("Encrypted unique message is: " + encryptedString);

        return encryptedString;

    }

    public static String decryptMessage() {

        String passwordToDecrypt = encryptMessage();
        String decryptedString = AES.decrypt(passwordToDecrypt, SECRETKEY);
        System.out.println("Decrypted unique message is: " + decryptedString);

        return decryptedString;

    }


    public static void main(String[] args) {
        encryptMessage();
        decryptMessage();
    }
}
