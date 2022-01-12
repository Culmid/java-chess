package cullen.middleton;

import java.util.ArrayList;
import java.util.Scanner;

public class Pawn extends Piece {

    int moveCount = 0;

    public Pawn(int c, int x, int y) {
        super(c, x, y);
    }

    public Pawn(Pawn p) {
        super(p);

        moveCount = p.getMoveCount();
    }
    
    public ArrayList<Integer> legalMoves(Board brd, boolean testCheck) {
        ArrayList<Integer> lm = new ArrayList<Integer>();
        int poty = c == 0 ? y + 1 : y - 1;

        if (poty < 8 && poty > -1) {
            // Normal Move
            Piece p = brd.getPiece(x, poty);

            if (p == null) {
                lm.add(x);
                lm.add(poty);
            }

            
            for (int i = -1; i < 2; i += 2) {
                // Normal Capture
                p = brd.getPiece(x + i, poty); // No Check for x in Bounds
                
                if (p != null && p.getC() != c) {
                    lm.add(x + i);
                    lm.add(poty);
                }

                // En Passant - Dodge
                p = brd.getPiece(x + i, y);

                if (p != null && p.getC() != c && p instanceof Pawn && ((Pawn)p).getMoveCount() == 1) {
                    lm.add(x + i);
                    lm.add(poty);
                }
            }

            // First Move, TODO: Check for something in Between
            if (moveCount == 0) {
                poty = c == 0 ? y + 2 : y - 2;
                p = brd.getPiece(x, poty);
                
                if (poty < 8 && poty > -1 && p == null) {
                    lm.add(x);
                    lm.add(poty);
                }
            }
        }

        if (testCheck) {
            lm = pruneMoves(brd, lm);
        }

        return lm;
    }

    public void makeMove(Board brd, int x, int y) {
        makeMove(brd, x, y, true);
    }

    public void makeMove(Board brd, int x, int y, boolean allowPromotion) {
        // En Passant Removal
        if (Math.abs(x - this.x) == 1 && Math.abs(y - this.y) == 1 && brd.getPiece(x, y) == null) {
            brd.removePiece(x, this.y);
            // System.out.println("Wow...En Passant...Someone Knows Chess ;)");
        }

        super.makeMove(brd, x, y);

        moveCount++;

        // Promotion
        if (allowPromotion) {
            if (c == 0 && y == 7 || c == 1 && y == 0) {
                System.out.println("Enter Piece for Promotion: Q/q for Queen, B/b for Bishop, K/k for Knight, R/r for Rook.");
                Piece p = null;
                Scanner sc = brd.getScanner();

                while (p == null) {
                    String s = sc.nextLine().split(" ")[0].toLowerCase(); // Dodgy

                    switch (s) {
                        case "r":
                            p = new Rook(c, x, y);
                            break;
                        case "k":
                            p = new Knight(c, x, y);
                            break;
                        case "b":
                            p = new Bishop(c, x, y);
                            break;
                        case "q":
                            p = new Queen(c, x, y);
                            break;
                    
                        default:
                            System.out.println("Invalid Piece Selection");
                            break;
                    }
                }

                sc = new Scanner(System.in); // Gives Close to Perfect Behaviour - Not Ideal

                brd.replacePiece(this, p);
            }
        }
    }

    public String toString() {
        return c == 0 ? "\u2659" : "\u265F"; 
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}