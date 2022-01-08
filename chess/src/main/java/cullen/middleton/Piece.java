public abstract class Piece {
    private int posx, posy;
    

    public Piece(int x, int y) {
        posx = x;
        posy = y;
    }

    abstract int[] legalMoves();

    public void makeMove(int x, int y) {
        posx = x;
        posy = y;
    }

    public boolean isLegalMove(int x, int y) {
        int[] lm = legalMoves();
        
        for (int i = 0; i < lm.length / 2; i += 2) {
            if (x == lm[i] && y == lm[i + 1]) {
                return true;
            }
        }

        return false;
    }
}