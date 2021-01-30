package edu.uoc.uocleaner.model;

public class Sprite {
    private int row;
    private int column;
    private Symbol symbol;

    protected Sprite(int row, int column, Symbol symbol) throws SpriteException {
        setRow(row);
        setColumn(column);
        setSymbol(symbol);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) throws SpriteException {
        if (row < 0) {
            throw new SpriteException(SpriteException.ERROR_INDEX_ROW_INCORRECT);
        } else {
            this.row = row;
        }
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) throws SpriteException {
        if (column < 0) {
            throw new SpriteException(SpriteException.ERROR_INDEX_COLUMN_INCORRECT);
        } else {
            this.column = column;
        }
    }

    public Symbol getSymbol() {
        return symbol;
    }

    private void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final Sprite other = (Sprite) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.symbol != other.symbol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return symbol.toString();

    }

}
