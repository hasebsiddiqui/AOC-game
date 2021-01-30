package edu.uoc.uocleaner.model;

public class SpriteException extends Exception {

    public static String ERROR_INDEX_ROW_INCORRECT = "[ERROR] The index of row cannot be negative!!";
    public static String ERROR_INDEX_COLUMN_INCORRECT = "[ERROR] The index of column cannot be negative!!";

    public SpriteException() {
    }

    public SpriteException(String msg) {
        super(msg);
    }
}
