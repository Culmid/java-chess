package cullen.middleton;

public abstract class Piece {
    protected int x, y; // Check
    protected int colour;

    public Piece(int c, int x, int y) {
        this.x = x;
        this.y = y;
        this.colour = c;
    }

    abstract int[] legalMoves(Board brd);

    public void makeMove(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isLegalMove(Board brd, int x, int y) {
        int[] lm = legalMoves(brd);
        
        for (int i = 0; i < lm.length / 2; i += 2) {
            if (x == lm[i] && y == lm[i + 1]) {
                return true;
            }
        }

        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColour() {
        return colour;
    }

    public abstract String toString();
}