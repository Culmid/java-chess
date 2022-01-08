package cullen.middleton;

import java.util.Arrays;

public class Board {
    private Piece[] wPieces = new Piece[16];
    private Piece[] bPieces = new Piece[16];

    // TODO: Add Board Flip
    public Board() {
        // Pawns
        for (int i = 0; i < 8; i++) {
            wPieces[i] = new Pawn(i, 1);
            bPieces[i] = new Pawn(i, 6);
        }

        int count = 8;

        // Rooks
        wPieces[count] = new Rook(0, 0);
        bPieces[count] = new Rook(0, 7);
        count++;
        
        wPieces[count] = new Rook(7, 0);
        bPieces[count] = new Rook(7, 7);
        count++;

        // Knights
        wPieces[count] = new Knight(1, 0);
        bPieces[count] = new Knight(1, 7);
        count++;
        
        wPieces[count] = new Knight(6, 0);
        bPieces[count] = new Knight(6, 7);
        count++;

        // Bishops
        wPieces[count] = new Bishop(2, 0);
        bPieces[count] = new Bishop(2, 7);
        count++;

        wPieces[count] = new Bishop(5, 0);
        bPieces[count] = new Bishop(5, 7);
        count++;

        // Queens
        wPieces[count] = new Queen(3, 0);
        bPieces[count] = new Queen(4, 7);
        count++;

        // Kings
        wPieces[count] = new King(4, 0);
        bPieces[count] = new King(3, 7);
    }


    public String toString() {
        String[] brd = new String[8];
        
        for (int i = 0; i < 8; i++) {
            brd[i] = "********\n";
        }

        // TODO: Factor Duplication Out
        // Add Pieces
        for (int i = 0; i < 16; i++) {
            // W Pieces
            if (wPieces[i] != null) {
                int x = wPieces[i].getX();
                int y = wPieces[i].getY();

                brd[y] = brd[y].substring(0, x) + wPieces[i].toString() + brd[y].substring(x + 1);
            }

            // B Pieces
            if (bPieces[i] != null) {
                int x = bPieces[i].getX();
                int y = bPieces[i].getY();

                brd[y] = brd[y].substring(0, x) + bPieces[i].toString().toUpperCase() + brd[y].substring(x + 1);
            }
        }

        String out = "";

        for (int i = 7; i > -1; i--) {
            out += brd[i];
        }

        return out;
    }
}