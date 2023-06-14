package cisc181.lab_4;
//Board is similar to a chess or checker board.
import java.util.Random;
public class Board {
    private int numRow;
    private int numColumn;
    private BoardSpace[][] spaces;
    public Board(int numRow, int numColumn) {
        this.numRow = numRow;
        this.numColumn = numColumn;
        this.spaces = new BoardSpace[numRow][numColumn];
        setUpEmptyBoard();
    }
    //getNumRows() gets the current row.
    public int getNumRows() {
        return numRow;
    }
    //getNumColumns() get the current column.
    public int getNumColumns() {
        return numColumn;
    }
    //getSpaces() gets the current space.
    public BoardSpace[][] getSpaces() {
        return spaces;
    }
    //inBounds() tells whether or not the location of the current space is within the bounds of the
    //board.
    public boolean inBounds(int RowIndex, int ColumnIndex) {
        if (((RowIndex >= 0) && (RowIndex < this.numRow)) && ((ColumnIndex < this.numColumn) && (ColumnIndex >= 0))) {
            return true;
        } else {
            return false;
        }
    }
    //setUpEmptyBoard() creates a BoardSpace for each location in the spaces two dimensional array.
    //The color is set to purple.
    public void setUpEmptyBoard() {
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                BoardSpace boardspace = new BoardSpace(i, j, "purple");
                this.spaces[i][j] = boardspace;
            }
        }
    }
    //findRandomEmptySpace() generates a random row and column index, if that location on the Board is
    //empty. If not, it repeats this process until it finds an empty space.
    public BoardSpace findRandomEmptySpace() {
        boolean yes = false;
        Random rand = new Random();
        int RowIndex = rand.nextInt(this.numRow);
        int ColumnIndex = rand.nextInt(this.numColumn);
        while (!(yes)) {
            if (this.spaces[RowIndex][ColumnIndex].isEmpty()) {
                yes = true;
            }
            RowIndex = rand.nextInt(this.numRow);
            ColumnIndex = rand.nextInt(this.numColumn);
        }
        return this.spaces[RowIndex][ColumnIndex];
    }
    //toString() prints a string builder's toString() value.
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :     ");
        for(int col = 0; col < spaces[0].length; col++) {
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for(int row = 0; row < spaces.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < spaces[row].length; col++){
                boardString.append(spaces[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}