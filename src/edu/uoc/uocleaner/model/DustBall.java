package edu.uoc.uocleaner.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DustBall extends Dirt implements Movable {
    public DustBall(int row, int column) throws SpriteException {
        super(row, column, Symbol.DUSTBALL, 5);
    }
    
    @Override
    public void moveTo(int row, int column) throws SpriteException {
        setRow(row);
        setColumn(column);       
    }
    
    public List<int[]> moveRandomly(Level level) {
        ArrayList<int[]> list = new ArrayList<>();
        int row = getRow();
        int column = getColumn();
        
        if (validMove(level, row, column - SPEED)) {
            int[] arr = {row, column - SPEED};
            list.add(arr);
        }
        
        if (validMove(level, row, column + SPEED)) {
            int[] arr = {row, column + SPEED};
            list.add(arr);
        }
        
        if (validMove(level, row - SPEED, column)) {
            int[] arr = {row - SPEED, column};
            list.add(arr);
        }
        
        if (validMove(level, row + SPEED, column)) {
            int[] arr = {row + SPEED, column};
            list.add(arr);
        }
        
        if (Math.random() >= 0.75 && list.size() > 0) {
            Random rd = new Random();
            int[] move = list.get(rd.nextInt(list.size()));
            try {
                level.setCell(new Dirt(row, column));
                moveTo(move[0], move[1]);
                level.setCell(this);
            } catch (Exception e) {
            	e.printStackTrace();
            }
            
        }
        return list;
    }
    
    private boolean validMove(Level level, int row, int column) {
        if (row >= level.getNumRows() || column >= level.getNumColumns()) {
            return false;
        }
        Symbol symbol = level.getCell(row, column).getSymbol();
        
        if (symbol == Symbol.WALL) {
            return false;
        }
        if (symbol == Symbol.VACUUM) {
            return false;
        }
        if (symbol == Symbol.DUSTBALL) {
            return false;
        }
        if (symbol == Symbol.DUMPSTER) {
            return false;
        }
        return true;
    }
}
