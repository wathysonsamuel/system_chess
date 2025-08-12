package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board; // o tabuleiro do jogo de xadrez

    // Construtor: inicializa a partida com um tabuleiro 8x8 (padrão do xadrez)
    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup(); // configura a posição inicial das peças
    }

    // Retorna uma matriz com as peças do tabuleiro convertidas para ChessPiece
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j); // faz casting para ChessPiece
            }
        }
        return mat;
    }

    // Coloca as peças iniciais no tabuleiro
    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1)); // adiciona uma torre branca na posição (2,1)
    }
}

