package cullen.middleton;

import java.util.ArrayList;
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

            int c = brd.inCheckStaleMate(player);
            if (c == 1) {
                System.out.println((player + 1) % 2 == 0 ? "W" : "B" + " Wins (Checkmate)");
                break;
            } else if (c == 0) {
                System.out.println("Draw (Stalemate)");
                break;
            }

            if (brd.inCheck(player)) {
                System.out.println("CHECK -> Watch Out! Your King is Under Attack!");
            }

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
                                    System.out.println("Moves for " + p + " (" + spl[1] + "): " + Arrays.toString(legalMovesToSR(p.legalMoves(brd, true))));
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
                    // Move
                    String[] spl = input.split(" ");
                    System.out.println(Arrays.toString(spl));

                    if (spl.length == 2) {
                        if (spl[1].length() == 2) {
                            int[] tr = translateSquareRef(spl[0].toLowerCase());
                            int[] tr1 = translateSquareRef(spl[1].toLowerCase());

                            if (tr[0] < 8 && tr[0] > -1 && tr[1] < 8 && tr[1] > -1) {
                                Piece p = brd.getPiece(tr[0], tr[1]);

                                if (p == null || p.getC() != player) {
                                    System.out.println("No Valid Piece Found at Starting Point");
                                } else {
                                    if (p.isLegalMove(brd, tr1[0], tr1[1], true)) {
                                        p.makeMove(brd, tr1[0], tr1[1]);
                                        break;
                                    } else {
                                        System.out.println("Move is NOT LEGAl for Selected Piece");
                                    }
                                }
                            } else {
                                System.out.println("Invalid Square Reference Value");
                            }
                        } else {
                            System.out.println("Invalid Square Reference Format: Example A2 or a2");
                        }
                    } else {
                        System.out.println("Move Expected: Example -> e4 e5");
                    }  
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

    private static String[] legalMovesToSR(ArrayList<Integer> lm) {
        String[] sr = new String[lm.size() / 2]; // Assume Even

        for (int i = 0; i < lm.size(); i += 2) {
            sr[i / 2] = (char)(lm.get(i) + 97) + "" + String.valueOf(lm.get(i + 1) + 1);
        }

        return sr;
    }
}

