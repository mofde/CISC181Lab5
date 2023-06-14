package cisc181.lab_4;
//BoardSpace has a color, row index and column index of where it is in the board and can hold a game
//piece
public class BoardSpace {
    private int row;
    private int column;
    private String color;
    private boolean empty;
    private Piece piece;
    public BoardSpace(int row, int column, String color) {
        this.row = row;
        this.column = column;
        this.color = color;
        this.empty = true;
        this.piece = null;
    }
    //getRow() gets the current row.
    public int getRow() {
        return row;
    }
    //getColumn() gets the current column.
    public int getColumn() {
        return column;
    }
    //getPiece() gets the current piece.
    public Piece getPiece() {
        return piece;
    }
    //getSpaceColor() gets the current space color.
    public String getSpaceColor() {
        return color;
    }
    //isEmpty() gets the current true or false statement about empty.
    public boolean isEmpty() {
        return empty;
    }
    //setPiece() sets the corresponding piece attribute to the piece value passed to the method and
    //updates the corresponding empty attribute to false.
    public void setPiece(Piece piece) {
        this.piece = piece;
        this.empty = false;
    }
    //removePiece() represents a piece that needs to be removed and sets the corresponding piece
    // attribute to null and updates the corresponding empty attribute to true.
    public Piece removePiece() {
        Piece removedPiece = this.piece;
        this.piece = null;
        this.empty = true;
        return removedPiece;
    }
    //toString() prints "-----" if there is no piece on the current space or prints the piece's
    //toString() value if there is a piece on the current space.
    public String toString() {
        if (this.empty) {
            return "------";
        }
        return this.piece.toString();
    }
}
