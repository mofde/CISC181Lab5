package cisc181.lab_4;
//Represents a game piece.
public abstract class Piece {
    protected String symbol;
    protected String color;
    protected boolean hidden;
    public Piece(String symbol, String color) {
        this.symbol = symbol;
        this.color = color;
        this.hidden = false;
    }
    public Piece(String symbol) {
        this(symbol, "");
    }
    //getSymbol gets the current symbol.
    public String getSymbol() {
        return symbol;
    }
    //getColor gets the current color.
    public String getColor() {
        return color;
    }
    //setColor sets the corresponding color attribute to the color value passed to the method.
    public void setColor(String color) {
        this.color = color;
    }
    //isHidden gets the current true or false statement about Hidden.
    public boolean isHidden() {
        return hidden;
    }
    //setHidden sets the corresponding Hidden attribute to the Hidden value passed to the method.
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    //toString prints the first character of the string, followed by a dash and then the symbol.
    public String toString() {
        return color.charAt(0) + "-" + symbol;
    }
    //speak() makes a game piece say something.
    public abstract void speak();
    //validPath() makes a game piece move to any number of spaces and/or how many spaces it can
    // move.
    public abstract boolean validPath(int PieceRowIndex, int PieceColumnIndex, int LocationRowIndex, int LocationColumnIndex);
}