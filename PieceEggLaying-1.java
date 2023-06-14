package cisc181.lab_4;
//PieceEggLaying represents a game piece that can lay an egg.
public abstract class PieceEggLaying extends Piece {
    protected int numEggs;
    final public static int MAX_EGGS = 2;
    public PieceEggLaying(String symbol, String color, int numEggs) {
        super(symbol, color);
        this.numEggs = numEggs;
    }
    public PieceEggLaying(String symbol) {
        this(symbol, "", 0);
    }
    //getNumEggs gets the current number of eggs.
    public int getNumEggs() {
        return this.numEggs;
    }
    //speak() makes a piece that can lay eggs speak.
    public abstract void speak();
    //validPath() makes a piece that can lay eggs move to any number of spaces and/or how many
    //spaces it can move.
    public abstract boolean validPath(int PieceRowIndex, int PieceColumnIndex, int BoardRowIndex, int BoardColumnIndex);
    //layEgg() makes a piece that can lay eggs be able to lay eggs.
    public abstract PieceEggLaying layEgg();
    //incrementNumEggs() sets the corresponding numEggs attribute to numEggs + 1.
    public void incrementNumEggs() {
        this.numEggs = this.numEggs + 1;
    }
    public static void main(String[] args) {

    }
}