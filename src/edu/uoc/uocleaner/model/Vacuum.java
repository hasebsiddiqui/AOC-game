package edu.uoc.uocleaner.model;

public class Vacuum extends Sprite implements Movable {
    private int MAX_CAPACITY;
    private int capacity;
    private Sprite under;
    
    public Vacuum(int row, int column, int MAX_CAPACITY) throws SpriteException, VacuumException {
        super(row, column, Symbol.VACUUM);
        if (MAX_CAPACITY <= 0) {
            throw new VacuumException(VacuumException.ERROR_MAX_CAPACITY_VALUE);
        } else {
            this.MAX_CAPACITY = MAX_CAPACITY;
        }
        setCapacity(0);
        setUnder(new Corridor(row, column));
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void incCapacity(int inc) throws VacuumException {
        if (inc < 0) {
            throw new VacuumException(VacuumException.ERROR_INC_CAPACITY_NEGATIVE_VALUE);
        } else if (this.capacity + inc > MAX_CAPACITY) {
            throw new VacuumException(VacuumException.ERROR_OVERFLOW_MAX_CAPACITY);
        } else {
            this.capacity += inc;
        }
    }
    
    private void setCapacity(int capacity) throws VacuumException {
        if (capacity < 0) {
            throw new VacuumException(VacuumException.ERROR_CAPACITY_NEGATIVE_VALUE);
        } else if (capacity > MAX_CAPACITY) {
            throw new VacuumException(VacuumException.ERROR_OVERFLOW_MAX_CAPACITY);
        } else {
            this.capacity = capacity;
        }
    }
    
    public void empty() throws VacuumException {
        setCapacity(0);
    }
    
    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }
    
    @Override
    public void moveTo(int row, int column) throws SpriteException {
        setRow(row);
        setColumn(column);
    }
    
    public Sprite getUnder() {
        return under;
    }
    
    public void setUnder(Sprite under) {
        this.under = under;
    }
}
