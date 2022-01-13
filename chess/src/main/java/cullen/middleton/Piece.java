package cullen.middleton;

import java.util.ArrayList;

/**
 * Abstract class representing the general behaviour of Chess Pieces.
 */
public abstract class Piece {
    protected int x, y;
    protected int c;

    /**
     * Default constructor with three initial values.
     * 
     * @param c Colour - 0 = White, 1 = Black.
     * @param x X Co-ordinate.
     * @param y Y Co-ordinate.
     */
    public Piece(int c, int x, int y) {
        this.x = x;
        this.y = y;
        this.c = c;
    }


    /**
     * Utility constructor for easy Piece Duplication.
     * 
     * @param p Existing Piece to copy attributes from.
     */
    public Piece(Piece p) {
        x = p.getX();
        y = p.getY();
        c = p.getC();
    }

    /**
     * Abstract function for the return of a list of legal moves for the Piece
     * concerned.
     * 
     * @param brd       Board object containing all Pieces and handling Piece
     *                  interaction.
     * @param testCheck Boolean to determine if moving into check is considered.
     * @return ArrayList of integers which are paired off according to x and y
     *         values for potential moves.
     */
    abstract ArrayList<Integer> legalMoves(Board brd, boolean testCheck);

    /**
     * General function for making a move. Handles standard moves and captures.
     * 
     * @param brd Board object containing all Pieces and handling Piece interaction.
     * @param x X co-ordinate.
     * @param y Y co-ordinate.
     */
    public void makeMove(Board brd, int x, int y) {
        if (brd.getPiece(x, y) != null) { // Assume Correct Colour for Capture
            brd.removePiece(x, y);
        }

        this.x = x;
        this.y = y;
    }

    /**
     * Function to check if a given move is in the set of legal moves for a Piece.
     * 
     * @param brd       Board object containing all Pieces and handling Piece
     *                  interaction.
     * @param x         X co-ordinate.
     * @param y         Y co-ordinate.
     * @param testCheck Boolean to determine if moving into check is considered.
     * @return Boolean representing the legality of the proposed move.
     */
    public boolean isLegalMove(Board brd, int x, int y, boolean testCheck) {
        ArrayList<Integer> lm = legalMoves(brd, testCheck);

        for (int i = 0; i < lm.size(); i += 2) {
            if (x == lm.get(i) && y == lm.get(i + 1)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Default getter for the x co-ordinate.
     * 
     * @return X co-ordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Default getter for the y co-ordinate.
     * 
     * @return Y co-ordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Default getter for the colour.
     * 
     * @return The Colour: 0 = White and 1 = Black.
     */
    public int getC() {
        return c;
    }

    /**
     * Default setter for x co-ordinate.
     * 
     * @param x Updated x co-ordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Default setter for y co-ordinate.
     * 
     * @param y Updated y co-ordinate.
     */
    public void setY(int y) {
        this.y = y;
    }
    
    public abstract String toString();

    /**
     * Overriden equal function for object equality test.
     * 
     * @param o Object to test equality against.
     * @return Boolean representing equality.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }


        if (!(o instanceof Piece)) {
            return false;
        }

        Piece p = (Piece) o;

        return x == p.getX() && y == p.getY() && c == p.getC();
    }

    /**
     * Function to remove moves that put the colour into check from the legal moves
     * list.
     * 
     * @param brd Board object containing all Pieces and handling Piece interaction.
     * @param lm Legal moves list.
     * @return Updated legal moves list with illegal checking moves removed.
     */
    public ArrayList<Integer> pruneMoves(Board brd, ArrayList<Integer> lm) {
        ArrayList<Integer> lmNew = new ArrayList<Integer>();
        for (int i = 0; i < lm.size(); i += 2) {
            if (!brd.testMoveCheck(this, lm.get(i), lm.get(i + 1))) {
                lmNew.add(lm.get(i));
                lmNew.add(lm.get(i + 1));
            }
        }

        return lmNew;
    }
}