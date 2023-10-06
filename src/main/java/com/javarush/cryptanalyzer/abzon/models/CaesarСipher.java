package com.javarush.cryptanalyzer.abzon.models;

import com.javarush.cryptanalyzer.abzon.structure.CryptoAnalyzerAlphabet;

public class CaesarСipher {
    private int key = 3;

    public CaesarСipher(int key) {
        this.key = key;
    }

    public CaesarСipher() {

    }

    public String encrypt(String textFoCrypt) {
        String result = "";
        for (int i = 0; i < textFoCrypt.length(); i++) {
            //получение текущего символа в тексте для шифрования
            char currentSymbol = textFoCrypt.charAt(i);
            // получение индекса символа с алфавита со здвигом в ключ
            int cryptoIndex = CryptoAnalyzerAlphabet.ALPHABET_UA.indexOf(currentSymbol) + this.key;
            // проверка что бы не было выхода за приделы алфавита
            if (cryptoIndex >= CryptoAnalyzerAlphabet.ALPHABET_UA.length()) {
                // если выход есть смещаемся на начало алфавита
                result += CryptoAnalyzerAlphabet.ALPHABET_UA.charAt(cryptoIndex - CryptoAnalyzerAlphabet.ALPHABET_UA.length());
            } else {
                //если выхода нет получаем символ со смещением
                result += CryptoAnalyzerAlphabet.ALPHABET_UA.charAt(cryptoIndex);
            }
        }
        return result;
    }

    public String decrypt(String decodingTextFoCrypt) {
        String result = "";
        for (int i = 0; i < decodingTextFoCrypt.length(); i++) {
            //получение текущего символа в тексте для шифрования
            char currentSymbol = decodingTextFoCrypt.charAt(i);
            // получение индекса символа с алфавита с обратным здвигом в ключ
            int cryptoIndex = CryptoAnalyzerAlphabet.ALPHABET_UA.indexOf(currentSymbol) - this.key;
            // проверка что бы не было выхода за приделы алфавита
            if (cryptoIndex < 0) {
                // если выход есть смещаемся на начало алфавита
                result += CryptoAnalyzerAlphabet.ALPHABET_UA.charAt(cryptoIndex + CryptoAnalyzerAlphabet.ALPHABET_UA.length());
            } else {
                //если выхода нет получаем символ со смещением
                result += CryptoAnalyzerAlphabet.ALPHABET_UA.charAt(cryptoIndex);
            }
        }
        return result;
    }

    public int getKey() {
        return this.key;
    }

    public String bruteForce(String text) {
        String result = "";
        String endl = System.getProperty("line.separator");
        for (int i = 1; i <= CryptoAnalyzerAlphabet.ALPHABET_UA.length(); i++) {
            this.key = i;
            result += (" key " + i + " " + this.decrypt(text) + endl);
        }
        this.key = 3;
        return result;

    }
}
