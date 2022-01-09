package cullen.middleton;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    enum State {
        PLAYING,
        END
    }

    public static void main(String[] args) {
        Board brd = new Board();
        int player = 0;
        Scanner sc = new Scanner(System.in);
        State s = State.PLAYING;

        while (s == State.PLAYING) {
            System.out.println(brd);
            System.out.println(player == 0 ? "W Turn": "B Turn");

            while (true) {
                String input = sc.nextLine();
                System.out.println(input);

                if (input.equals("/resign") || input.equals("/r")) {
                    // Resign
                    System.out.println(player == 0 ? "B Wins (Resignation)": "W Wins (Resignation)");
                    s = State.END;
                    break;
                } else if (input.startsWith("/help") || input.startsWith("/h")){
                    // Find Moves for Piece
                    String[] spl = input.split(" ");
                    System.out.println(Arrays.toString(spl));
                    if (spl.length == 2) {
                        if (spl[1].length() == 2) {
                            int[] tr = translateSquareRef(spl[1].toLowerCase());

                            if (tr[0] < 8 && tr[0] > -1 && tr[1] < 8 && tr[1] > -1) {
                                Piece p = brd.getPiece(tr[0], tr[1]);

                                if (p == null) {
                                    System.out.println("No Valid Piece Found");
                                } else {
                                    System.out.println("Moves for " + p + " (" + spl[1] + "): " + Arrays.toString(p.legalMoves(brd)));
                                }
                            } else {
                                System.out.println("Invalid Square Reference Value");
                            }
                        } else {
                            System.out.println("Invalid Square Reference Format: Example A2 or a2");
                        }
                    } else {
                        System.out.println("Incorrect Usage of /help: Try /help [SquareRef]");
                    }
                } else {
                    break;
                    // Move
                }

                
            }
            

            player = (player + 1) % 2;
        }

        sc.close();
    }

    private static int[] translateSquareRef(String sr) {
        int x = (int)sr.charAt(0) - 97;
        int y = (int)sr.charAt(1) - 49;

        return new int[] {x, y};
    }
}

