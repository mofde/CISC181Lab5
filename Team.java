package cisc181.lab_4;
import java.util.ArrayList;
//Represents one player's set of game pieces.
public class Team {
    private String teamName;
    private String teamColor;
    private ArrayList<Piece> pieces;
    public Team(String teamName, String teamColor, ArrayList<Piece> pieces) {
        this.teamName = teamName;
        this.teamColor = teamColor;
        this.pieces = pieces;
    }
    //getTeamName gets the current team.
    public String getTeamName() {
        return teamName;
    }
    //getTeamColor gets the current team color.
    public String getTeamColor() {
        return teamColor;
    }
    //getTeamPieces gets the current team pieces.
    public ArrayList<Piece> getTeamPieces() {
        return pieces;
    }
    //removePieceFromTeam removes the corresponding piece attribute in the current team pieces.
    public void removePieceFromTeam(Piece piece) {
        this.pieces.remove(piece);
    }
    //addPieceToTeam adds the corresponding piece attribute in the current team pieces.
    public void addPieceToTeam(Piece piece) {
        this.pieces.add(piece);
        piece.setColor(this.teamColor);
    }
    //toString prints the team name, color and all of the team's Pieces' toString values.
    public String toString() {
        return "Team: " + this.teamName + " : " + this.teamColor + "\n" + "Pieces : " + this.pieces.toString();
    }
}