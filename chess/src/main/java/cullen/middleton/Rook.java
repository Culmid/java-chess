package cullen.middleton;

import java.util.ArrayList;

/**
 * Subclasss of Piece representing the Rook Piece.
 */
public class Rook extends Piece {

    /**
     * Default constructor with three initial values.
     * 
     * @param c Colour - 0 = White, 1 = Black.
     * @param x X Co-ordinate.
     * @param y Y Co-ordinate.
     */
    public Rook(int c, int x, int y) {
        super(c, x, y);
    }
    
    /**
     * Utility constructor for easy Piece Duplication.
     * 
     * @param r Existing Piece to copy attributes from.
     */
    public Rook(Rook r) {
        super(r);
    }

    /**
     * Function to return a list of legal moves for a Rook.
     * 
     * @param brd       Board object containing all Pieces and handling Piece interaction.
     * @param testCheck Boolean to determine if moving into check is considered.
     * @return ArrayList of integers which are paired off according to x and y
     *         values for potential moves.
     */
    public ArrayList<Integer> legalMoves(Board brd, boolean testCheck) {
        ArrayList<Integer> lm = new ArrayList<Integer>();

        // Up
        int poty = y + 1;
        while (poty < 8) {
            Piece p = brd.getPiece(x, poty);

            if (p != null && p.getC() == c) {
                break;
            }

            lm.add(x);
            lm.add(poty++);

            if (p != null) {
                break;
            }
        }

        // Down
        poty = y - 1;
        while (poty > -1) {
            Piece p = brd.getPiece(x, poty);

            if (p != null && p.getC() == c) {
                break;
            }

            lm.add(x);
            lm.add(poty--);

            if (p != null) {
                break;
            }
        }

        // Right
        int potx = x - 1;
        while (potx > -1) {
            Piece p = brd.getPiece(potx, y);

            if (p != null && p.getC() == c) {
                break;
            }

            lm.add(potx--);
            lm.add(y);

            if (p != null) {
                break;
            }
        }

        // Left
        potx = x + 1;
        while (potx < 8) {
            Piece p = brd.getPiece(potx, y);

            if (p != null && p.getC() == c) {
                break;
            }

            lm.add(potx++);
            lm.add(y);

            if (p != null) {
                break;
            }
        }

        if (testCheck) {
            lm = pruneMoves(brd, lm);
        }

        return lm;
    }

    /**
     * Default toString function with unicode for Rooks.
     */
    public String toString() {
        return c == 0 ? "\u2656" : "\u265C";
    }
}