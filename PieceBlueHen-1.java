package cisc181.lab_4;
//A blue hen piece represents a game piece type.
public class PieceBlueHen extends PieceEggLaying {
    private int numAttacked;
    private boolean fly;
    public PieceBlueHen(String symbol, String color, int numEggs, int numAttacked){
        super(symbol, color, numEggs);
        this.numAttacked = numAttacked;
        updateFly();
    }
    public PieceBlueHen(String symbol){
        this(symbol,"",0,0);
    }
    //getNumAttacked() gets the current number of pieces attacked.
    public int getNumAttacked() {
        return this.numAttacked;
    }
    //speak() makes a blue hen piece say "Go UD!".
    public void speak(){
        System.out.println("Go UD!");
    }
    //canFly() gets the current true or false statement about fly.
    public boolean canFly ()  {
        return this.fly;
    }
    //incrementNumEggs() sets the corresponding attribute numEggs to numEggs + 1 and updates the fly
    //attribute.
    public void incrementNumEggs( ){
        this.numEggs++;
        updateFly();
    }
    //incrementNumAttacked() sets the corresponding attribute numAttacked to numAttacked + 1 and
    //updates the fly attribute.
    public void incrementNumAttacked( ){
        this.numAttacked++;
        updateFly();
    }
    //validPath() makes a blue hen piece move one space left, right, up or down if it cannot fly and
    //move to any empty space on the board if it can.
    public boolean validPath(int PieceRowIndex, int PieceColumnIndex, int BoardRowIndex, int BoardColumnIndex){
        System.out.println("If can't fly -> can move one space left, or right, or up, or down.\n" +
                "If can fly -> can move to any empty space on board.");
        BoardSpace boardspace = new BoardSpace(BoardRowIndex, BoardColumnIndex, "purple");
        if ((canFly()) && (boardspace.isEmpty())) {
            return true;
        } else if ((!canFly()) && (Math.abs(BoardRowIndex - PieceRowIndex) == 1) && (Math.abs(BoardColumnIndex - PieceColumnIndex) > 0)){
            return false;
        } else if ((!canFly()) && (Math.abs(BoardRowIndex - PieceRowIndex) == 1)) {
            return true;
        } else if ((!canFly()) && (Math.abs(BoardColumnIndex - PieceColumnIndex) == 1)) {
            return true;
        } else {
            return false;
        }
    }
    //attack() makes a blue hen piece attack with claws and removes other piece(s) from the game and
    //updates the number of pieces attacked.
    public void attack(int BoardRowIndex, int BoardColumnIndex, int PieceRowIndex, int PieceColumnIndex) {
        this.incrementNumAttacked();
        speak();
        System.out.println("Attacks with claws – other piece removed from game.");
    }
    //layEgg represents a new blue hen piece and
    //makes a blue hen piece lay eggs if the current number of eggs has not met the maximum number
    //of eggs.
    public PieceBlueHen layEgg(){
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // creates a new piece that has the same number of eggs laid and attacked pieces
            // as this piece
            return new PieceBlueHen(this.symbol,this.color,this.numEggs,this.numAttacked);
        }
        else{
            return null;
        }
    }
    //updateFly() may change the corresponding fly attribute to true or false depending on the fact
    //that blue hen piece has laid less than the maximum number of eggs or no pieces got attacked.
    private void updateFly( ) {
        if (this.numEggs < MAX_EGGS) {
            this.fly = true;
        } else if (this.numAttacked == 0) {
            this.fly = true;
        } else {
            this.fly = false;
        }
    }
}