package cisc181.lab_4;
import java.util.ArrayList;
import java.util.Collections;
//Represents a game.
public abstract class Game {
    protected Board board;
    protected Team player1;
    protected Team player2;
    protected String turn;
    //sets up both Team pieces randomly on the board.
    private void initializeGameBoard(int numRow, int numColumn) {
        this.board = new Board(numRow, numColumn);
        int i;
        for (i = 0; i < player1.getTeamPieces().size(); i++) {
            BoardSpace boardspace1 = this.board.findRandomEmptySpace();
            ArrayList<Piece> player1pieces = this.player1.getTeamPieces();
            boardspace1.setPiece(player1pieces.get(i));
        }
        for (i = 0; i < player2.getTeamPieces().size(); i++) {
            BoardSpace boardSpace2 = this.board.findRandomEmptySpace();
            ArrayList<Piece> player2pieces = this.player1.getTeamPieces();
            boardSpace2.setPiece(player2pieces.get(i));
        }
    }
    public Game(int numRow, int numColumn, Team player1, Team player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.turn = "player1";
        initializeGameBoard(numRow, numColumn);
    }
    //getBoard gets the current board.
    public Board getBoard() {
        return board;
    }
    //getCurrentTeam gets the current team.
    public Team getCurrentTeam() {
        if (this.turn == "player1") {
            return this.player1;
        } else {
            return this.player2;
        }
    }
    //getOpponentTeam gets the current opposing team.
    public Team getOpponentTeam() {
        if (this.turn == "player1") {
            return this.player2;
        } else {
            return this.player1;
        }
    }
    //isTurn gets the current team's current turn.
    public boolean isTurn(Team team) {
        if ((team == this.player1) && (this.turn == "player1")) {
            return true;
        } else if ((team == this.player2) && (this.turn == "player2")) {
            return true;
        } else {
            return false;
        }
    }
    //changeTurn sets the corresponding turn attribute to the opposite team.
    public void changeTurn() {
        if (this.turn == "player1") {
            this.turn = "player2";
        } else {
            this.turn = "player1";
        }
    }
    //isAWinner mentions if there is a winner.
    public abstract boolean isAWinner();
    //getWinner gets the winning team.
    public abstract Team getWinner();
    //isGameEnded mentions if the game ended.
    public abstract boolean isGameEnded();
    //toString prints the game.
    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n" + getBoard().toString())
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n" + getBoard().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamName() + "'s turn\n");
        return retString.toString();
    }
}