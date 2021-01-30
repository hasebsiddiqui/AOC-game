package edu.uoc.uocleaner.model;

public enum Symbol {
    DUSTBALL('@', "dustball.png"),
    DUMPSTER('D', "dumpster.png"),
    VACUUM('V', "huocver.png"),
    DIRT('·', "dirt.png"),
    WALL('#', ""),
    CORRIDOR(' ', "");

    private char ascii;
    private String image;

    private Symbol(char ascii, String image) {
        this.ascii = ascii;
        this.image = image;
    }

    public static Symbol getName(char ascii) {
        if (ascii == '@') {
            return DUSTBALL;
        }
        if (ascii == 'D') {
            return DUMPSTER;
        }
        if (ascii == 'V') {
            return VACUUM;
        }
        if (ascii == '·') {
            return DIRT;
        }
        if (ascii == '#') {
            return WALL;
        }
        if (ascii == ' ') {
            return CORRIDOR;
        }
        return null;
    }

    public char getAscii() {
        return ascii;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "" + ascii;
    }

}
