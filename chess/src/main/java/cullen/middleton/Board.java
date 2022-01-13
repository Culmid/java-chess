package cullen.middleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Board class to hold all pieces and handle piece interaction.
 */
public class Board {
    private Piece[] pieces = new Piece[32];
    private Scanner sc;

    /**
     * Default Constructor
     */
    public Board() {
        this((Scanner) null);
    }

    /**
     * Implementation of Default Constructor where Scanner is initialised.
     * 
     * @param sc Scanner that has been opened on StdIn to read values for pawn promotion.
     */
    public Board(Scanner sc) {
        this.sc = sc;

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
        pieces[count++] = new Queen(1, 3, 7);

        // Kings
        pieces[count++] = new King(0, 4, 0);
        pieces[count++] = new King(1, 4, 7);
    }
    
    /**
     * Constructor to load the board state from a file.
     * 
     * @param filename The file to load the state from.
     */
    public Board(String filename) {
        loadBoard(filename);
    }


    /**
     * Default toString function where the Board is printed in a certain format.
     */
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

    /**
     * Function to retrieve a Piece object (or lack of) at the given co-ordinates.
     * 
     * @param x X co-ordinate.
     * @param y Y co-ordinate.
     * @return Piece object if a piece exists at the given point or null otherwise.
     */
    public Piece getPiece(int x, int y) {
        for (int i = 0; i < 32; i++) {
            if (pieces[i] != null && pieces[i].getX() == x && pieces[i].getY() == y) {
                return pieces[i];
            }
        }

        return null;
    }

    /**
     * Function to remove a Piece from the specified co-ordinates.
     * 
     * @param x X co-ordinate.
     * @param y Y co-ordinate.
     * @return True if a piece was removed correctly from the specified co-ordinates, false otherwise.
     */
    public boolean removePiece(int x, int y) {
        for (int i = 0; i < 32; i++) {
            if (pieces[i] != null && pieces[i].getX() == x && pieces[i].getY() == y) {
                pieces[i] = null;
                return true;
            }
        }

        return false;
    }

    /**
     * Function to relace a Piece in the board state with another Piece object.
     * This function is primarily used for promotion of Pawns.
     * 
     * @param orig The Piece currently existing on the board, to be replaced.
     * @param newP The new Piece to replace the existing one.
     */
    public void replacePiece(Piece orig, Piece newP) {
        for (int i = 0; i < 32; i++) {
            if (pieces[i] != null && pieces[i].equals(orig)) {
                pieces[i] = newP;
            }
        }
    }

    /**
     * Function to check if a given colour is in check, according to the board state.
     * 
     * @param c The colour, 0 = White and 1 = Black.
     * @return A boolean to show f the colour is in check.
     */
    public boolean inCheck(int c) {
        for (int i = 0; i < 32; i++) {
            if (pieces[i] != null && pieces[i] instanceof King && pieces[i].getC() == c) {
                for (int j = 0; j < 32; j++) {
                    if (pieces[j] != null && pieces[j].getC() != c) {
                        if (pieces[j].isLegalMove(this, pieces[i].getX(), pieces[i].getY(), false)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    /**
     * Function to test if a move will put the respective colour into check (which is illegal).
     * 
     * @param p The Piece to move.
     * @param x The target x co-ordinate.
     * @param y The target y co-ordingate.
     * @return A boolean to show if the move will result in a check.
     */
    public boolean testMoveCheck(Piece p, int x, int y) {
        Piece[] temp = new Piece[32]; // Temporary Save of Board State
        int initX = p.getX();
        int initY = p.getY();
        int moveCount = -1;

        if (p instanceof Pawn) {
            moveCount = ((Pawn)p).getMoveCount();
        }

        if (p instanceof King) {
            moveCount = ((King)p).getMoveCount();
        }

        for (int i = 0; i < 32; i++) {
            Piece pc = pieces[i];

            if (pc == null) {
                temp[i] = null; // Bit Overkill
            } else {
                if (pc instanceof Pawn) {
                    temp[i] = new Pawn((Pawn)pc);
                } else if (pc instanceof Rook) {
                    temp[i] = new Rook((Rook)pc);
                } else if (pc instanceof Knight) {
                    temp[i] = new Knight((Knight)pc);
                } else if (pc instanceof Bishop) {
                    temp[i] = new Bishop((Bishop)pc);
                } else if (pc instanceof Queen) {
                    temp[i] = new Queen((Queen)pc);
                } else {
                    temp[i] = new King((King)pc);
                }
            }
        }
        if (p instanceof Pawn) {
            ((Pawn)p).makeMove(this, x, y, false);
        } else {
            p.makeMove(this, x, y);
        }

        boolean res = inCheck(p.getC());

        pieces = temp; // Restore State

        p.setX(initX);
        p.setY(initY);

        if (p instanceof Pawn) {
            ((Pawn)p).setMoveCount(moveCount);
        }

        if (p instanceof King) {
            ((King)p).setMoveCount(moveCount);
        }

        for (int i = 0; i < 32; i++) {
            if (p.equals(pieces[i])) {
                pieces[i] = p;
                break;
            }
        }

        return res;
    }

    /**
     * Function to check for Checkmate and Stalemate.
     * 
     * @param c The colour to check for: 0 = White and 1 = Black.
     * @return Int representing the state: -1 = Neither, 0 = Stalemate, and 1 = Checkmate.
     */
    public int inCheckStaleMate(int c) {
        for (int i = 0; i < 32; i++) {
            if (pieces[i] != null && pieces[i].getC() == c && pieces[i].legalMoves(this, true).size() > 0) {
                return -1; // Neither
            }
        }

        return inCheck(c) ? 1 : 0; // Checkmate : Stalemate
    }

    /**
     * Function to export the string representation of the board to a file.
     * 
     * @param filename The file to export to.
     */
    public void exportBoard(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to load a board state from file.
     * 
     * @param filename The file to load the board from.
     */
    public void loadBoard(String filename) {
        File f = new File(filename);
        
        try {
            Scanner sc = new Scanner(f);
            
            int count = 0;
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
            e.printStackTrace();
        }
    }

    /**
     * Simple getter for the scanner.
     * 
     * @return The StdIn Scanner.
     */
    public Scanner getScanner() {
        return sc;
    }
}