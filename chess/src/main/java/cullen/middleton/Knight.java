package cullen.middleton;

import java.util.ArrayList;

/**
 * Subclasss of Piece representing the Knight Piece.
 */
public class Knight extends Piece {

    /**
     * Default constructor with three initial values.
     * 
     * @param c Colour - 0 = White, 1 = Black.
     * @param x X Co-ordinate.
     * @param y Y Co-ordinate.
     */
    public Knight(int c, int x, int y) {
        super(c, x, y);
    }

    /**
     * Utility constructor for easy Piece Duplication.
     * 
     * @param k Existing Piece to copy attributes from.
     */
    public Knight(Knight k) {
        super(k);
    }
    
    /**
     * Function to return a list of legal moves for a Knight.
     * 
     * @param brd       Board object containing all Pieces and handling Piece interaction.
     * @param testCheck Boolean to determine if moving into check is considered.
     * @return ArrayList of integers which are paired off according to x and y
     *         values for potential moves.
     */
    public ArrayList<Integer> legalMoves(Board brd, boolean testCheck) {
        ArrayList<Integer> lm = new ArrayList<Integer>();

        int[][] changes = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

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

        if (testCheck) {
            lm = pruneMoves(brd, lm);
        }
        
        return lm;
    }

    /**
     * Default toString function with unicode for Knights.
     */
    public String toString() {
        return c == 0 ? "\u2658" : "\u265E";
    }
}