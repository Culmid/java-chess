package cullen.middleton;

import java.util.ArrayList;

/**
 * Subclass of Piece representing the King Piece.
 */
public class King extends Piece {

    private int moveCount = 0;

    /**
     * Default constructor with three initial values.
     * 
     * @param c Colour - 0 = White, 1 = Black.
     * @param x X Co-ordinate.
     * @param y Y Co-ordinate.
     */
    public King(int c, int x, int y) {
        super(c, x, y);
    }

    /**
     * Utility constructor for easy Piece Duplication.
     * 
     * @param k Existing Piece to copy attributes from.
     */
    public King(King k) {
        super(k);

        moveCount = k.getMoveCount();
    }
    
    /**
     * Function to return a list of legal moves for a King.
     * 
     * @param brd       Board object containing all Pieces and handling Piece interaction.
     * @param testCheck Boolean to determine if moving into check is considered.
     * @return ArrayList of integers which are paired off according to x and y
     *         values for potential moves.
     */
    public ArrayList<Integer> legalMoves(Board brd, boolean testCheck) {
        ArrayList<Integer> lm = new ArrayList<Integer>();

        int[][] changes = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

        for (int i = 0; i < 8; i++) {
            int potx = x + changes[i][0];
            int poty = y + changes[i][1];
            
            if (potx > -1 && potx < 8 && poty > -1 && poty < 8) {
                Piece p = brd.getPiece(potx, poty);

                if (p != null && p.getC() != c || p == null) {
                    lm.add(potx);
                    lm.add(poty);
                }
            }
        }

        if (moveCount == 0) {
            // King Side
            boolean flag = true;
            for (int i = 1; i < 3; i++) {
                if (brd.getPiece(x + i, y) != null) {
                    flag = false;
                    break;
                }
            }

            if (flag && brd.getPiece(x + 3, y) instanceof Rook && brd.getPiece(x + 3, y).getC() == c) {
                lm.add(x + 2);
                lm.add(y);
            }

            // Queen Side
            flag = true;
            for (int i = 1; i < 4; i++) {
                if (brd.getPiece(x - i, y) != null) {
                    flag = false;
                    break;
                }
            }

            if (flag && brd.getPiece(x - 4, y) instanceof Rook && brd.getPiece(x - 4, y).getC() == c) {
                lm.add(x - 2);
                lm.add(y);
            }
        }

        if (testCheck) {
            lm = pruneMoves(brd, lm);
        }

        return lm;
    }

    /**
     * King specific move making function to allow for castling and King state.
     * 
     * @param brd Board object containing all Pieces and handling Piece interaction.
     * @param x X co-ordinate.
     * @param y Y co-ordinate.
     */
    public void makeMove(Board brd, int x, int y) {
        // Castling - Assume Legal and Rook in Place
        if (x - this.x == 2) { // King Side
            brd.getPiece(x + 1, y).makeMove(brd, this.x + 1, y);
        }
        if (x - this.x == -2) { // Queen Side
            brd.getPiece(x - 2, y).makeMove(brd, this.x - 1, y);
        }

        super.makeMove(brd, x, y);
        moveCount++;
    }

    /**
     * Default toString function with unicode for Kings.
     */
    public String toString() {
        return c == 0 ? "\u2654" : "\u265A";
    }

    /**
     * Default getter for moveCount.
     * 
     * @return moveCount.
     */
    public int getMoveCount() {
        return moveCount;
    }

    /**
     * Default setter for moveCount.
     * 
     * @param moveCount Updated moveCount.
     */
    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}