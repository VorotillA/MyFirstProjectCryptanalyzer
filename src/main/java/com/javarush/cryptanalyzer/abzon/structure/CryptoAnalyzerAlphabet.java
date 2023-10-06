package com.javarush.cryptanalyzer.abzon.structure;

public class CryptoAnalyzerAlphabet {
    private static final String UPPER_CASE_ENG = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE_ENG = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE_UA = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    private static final String LOWER_CASE_UA = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
    private static final String NUMBERS = "013456789";
    private static final String SYMBOLS = "!@#$%^&*()_+-={}[]|:;\"'<>,.?/`~\\ ";
    public static final String ALPHABET_ENG = (UPPER_CASE_ENG + LOWER_CASE_ENG + NUMBERS + SYMBOLS);
    public static final String ALPHABET_UA = (UPPER_CASE_UA + LOWER_CASE_UA + NUMBERS + SYMBOLS);
}
