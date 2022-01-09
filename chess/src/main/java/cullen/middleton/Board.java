package cullen.middleton;

import java.util.Arrays;

public class Board {
    private Piece[] pieces = new Piece[32];

    // TODO: Add Board Flip
    public Board() {
        // Pawns
        for (int i = 0; i < 8; i++) {
            pieces[i] = new Pawn(0, i, 1);
            pieces[8 + i] = new Pawn(1, i, 6);
        }

        int count = 16;

        // Rooks
        pieces[count++] = new Rook(0, 0, 0);
        pieces[count++] = new Rook(1, 0, 7);
        pieces[count++] = new Rook(0, 7, 0);
        pieces[count++] = new Rook(1, 7, 7);

        // Knights
        pieces[count++] = new Knight(0, 1, 0);
        pieces[count++] = new Knight(1, 1, 7);
        pieces[count++] = new Knight(0, 6, 0);
        pieces[count++] = new Knight(1, 6, 7);

        // Bishops
        pieces[count++] = new Bishop(0, 2, 0);
        pieces[count++] = new Bishop(1, 2, 7);
        pieces[count++] = new Bishop(0, 5, 0);
        pieces[count++] = new Bishop(1, 5, 7);

        // Queens
        pieces[count++] = new Queen(0, 3, 0);
        pieces[count++] = new Queen(1, 4, 7);

        // Kings
        pieces[count++] = new King(0, 4, 0);
        pieces[count++] = new King(1, 3, 7);
    }


    public String toString() {
        String[] brd = new String[8];
        
        for (int i = 0; i < 8; i++) {
            brd[i] = "********\n";
        }

        // TODO: Factor Duplication Out
        // Add Pieces
        for (int i = 0; i < 32; i++) {
            if (pieces[i] != null) {
                int x = pieces[i].getX();
                int y = pieces[i].getY();
                String p = pieces[i].toString();

                if (pieces[i].getColour() == 1) {
                    p = p.toUpperCase();
                }
                
                brd[y] = brd[y].substring(0, x) + p + brd[y].substring(x + 1);
            }
        }

        String out = "";

        for (int i = 7; i > -1; i--) {
            out += brd[i];
        }

        return out.strip();
    }


    public Piece getPiece(int x, int y) {
        for (int i = 0; i < 32; i++) {
            if (pieces[i].getX() == x && pieces[i].getY() == y) {
                return pieces[i];
            }
        }

        return null;
    }
}