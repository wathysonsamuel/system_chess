package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ChessMatch chessmatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();                                // limpa a tela
                UI.printBoard(chessmatch.getPieces());           // mostra o tabuleiro atual
                System.out.println();
                System.out.print("Source: ");                    // pede posição de origem
                ChessPosition source = UI.readChessPosition(sc); // lê e valida entrada

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessmatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");                    // pede posição de destino
                ChessPosition target = UI.readChessPosition(sc); // lê e valida entrada

                ChessPiece capturedPiece = chessmatch.performChessMove(source, target); // executa o movimento
            }
            catch (ChessException e) {                           // erro de regra (ex: origem vazia, movimento inválido)
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e) {                   // erro de entrada (ex: digitar "z9")
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }  

}
