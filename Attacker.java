package cisc181.lab_4;
//Gives a game piece the ability to attack.
public interface Attacker {
    public abstract void attack(int BoardRowIndex, int BoardColumnIndex, int PieceRowIndex, int PieceColumnIndex);
}
