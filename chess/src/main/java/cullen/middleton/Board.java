package cullen.middleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
        pieces[count++] = new Rook(0, 7, 0);

        pieces[count++] = new Rook(1, 0, 7);
        pieces[count++] = new Rook(1, 7, 7);

        // Knights
        pieces[count++] = new Knight(0, 1, 0);
        pieces[count++] = new Knight(0, 6, 0);

        pieces[count++] = new Knight(1, 1, 7);
        pieces[count++] = new Knight(1, 6, 7);

        // Bishops
        pieces[count++] = new Bishop(0, 2, 0);
        pieces[count++] = new Bishop(0, 5, 0);
        
        pieces[count++] = new Bishop(1, 2, 7);
        pieces[count++] = new Bishop(1, 5, 7);

        // Queens
        pieces[count++] = new Queen(0, 3, 0);
        pieces[count++] = new Queen(1, 4, 7);

        // Kings
        pieces[count++] = new King(0, 4, 0);
        pieces[count++] = new King(1, 3, 7);
    }

    public Board(String filename) {
        loadBoard(filename);
    }


    public String toString() {
        String[] brd = new String[8];
        
        // Init Board
        for (int i = 0; i < 8; i++) {
            brd[i] = "* * * * * * * *\n";
        }

        // Add Pieces
        for (int i = 0; i < 32; i++) {
            if (pieces[i] != null) {
                int x = pieces[i].getX();
                int y = pieces[i].getY();

                brd[y] = brd[y].substring(0, 2 * x) + pieces[i].toString() + brd[y].substring(2 * x + 1);
            }
        }

        // Build String
        String out = "";
        for (int i = 7; i > -1; i--) {
            out += brd[i];
        }

        return out.strip();
    }


    public Piece getPiece(int x, int y) {
        for (int i = 0; i < 32; i++) {
            if (pieces[i] != null && pieces[i].getX() == x && pieces[i].getY() == y) {
                return pieces[i];
            }
        }

        return null;
    }

    public void exportBoard(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(toString());
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void loadBoard(String filename) {
        File f = new File(filename);
        
        try {
            Scanner sc = new Scanner(f);
            
            int count = 0;
            // TODO: Catch for Incorrect Format
            for (int i = 7; i > -1; i--) {
                String[] spl = sc.nextLine().split(" ");

                for (int j = 0; j < 8; j++) {
                    switch (spl[j]) {
                        case "\u2659":
                            pieces[count++] = new Pawn(0, j, i);
                            break;
                        case "\u265F":
                            pieces[count++] = new Pawn(1, j, i);
                            break;
                        case "\u2656":
                            pieces[count++] = new Rook(0, j, i);
                            break;
                        case "\u265C":
                            pieces[count++] = new Rook(1, j, i);
                            break;
                        case "\u2658":
                            pieces[count++] = new Knight(0, j, i);
                            break;
                        case "\u265E":
                            pieces[count++] = new Knight(1, j, i);
                            break;
                        case "\u2657":
                            pieces[count++] = new Bishop(0, j, i);
                            break;
                        case "\u265D":
                            pieces[count++] = new Bishop(1, j, i);
                            break;
                        case "\u2655":
                            pieces[count++] = new Queen(0, j, i);
                            break;
                        case "\u265B":
                            pieces[count++] = new Queen(1, j, i);
                            break;
                        case "\u2654":
                            pieces[count++] = new King(0, j, i);
                            break;
                        case "\u265A":
                            pieces[count++] = new King(1, j, i);
                            break;
                        default:
                            break;
                    }
                }
            }

            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}