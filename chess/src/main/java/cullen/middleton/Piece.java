package cullen.middleton;

public abstract class Piece {
    protected int x, y; // Check
    protected int c;

    public Piece(int c, int x, int y) {
        this.x = x;
        this.y = y;
        this.c = c;
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

    public int getC() {
        return c;
    }

    public abstract String toString();
}