package edu.uoc.uocleaner.model;

public class DumpsterException extends Exception {
    public static String ERROR_LOAD_NEGATIVE_VALUE = "[ERROR] Load cannot be negative!!";

    public DumpsterException() {
    }

    public DumpsterException(String msg) {
        super(msg);
    }
}
