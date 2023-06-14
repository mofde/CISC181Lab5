package cisc181.lab_4;
//Represents the game that will be developed in lab 5.
public class Game181 extends Game {
    public Game181(int numRow, int numColumn, Team player1, Team player2) {
        super(numRow, numColumn, player1, player2);
    }
    //isGameEnded happens if at least one of the teams has no more pieces are on the board.
    public boolean isGameEnded() {
        if ((this.player1.getTeamPieces().size() == 0) || (this.player2.getTeamPieces().size() == 0)) {
            return true;
        } else {
            return false;
        }
    }
    //isAWinner happens if the game has ended and only one of the teams still have pieces on the board.
    public boolean isAWinner() {
        if ((isGameEnded()) && ((this.player1.getTeamPieces().size() > 0) || (this.player2.getTeamPieces().size() > 0))) {
            return true;
        } else {
            return false;
        }
    }
    //getWinner represents the winner that still has pieces on the board after the game has ended.
    //If there is no winner, getWinner does not represent anything.
    public Team getWinner() {
        if ((isGameEnded()) && (this.player1.getTeamPieces().size() > 0)) {
            return this.player1;
        } else if ((isGameEnded() && (this.player2.getTeamPieces().size() > 0))) {
            return this.player2;
        } else {
            return null;
        }
    }
}