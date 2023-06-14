package cisc181.lab_4;
//Gives a game piece the ability to recruit.
public interface Recruiter {
    public abstract void recruit(int BoardRowIndex, int BoardColumnIndex, int PieceRowIndex, int PieceColumnIndex);
}
