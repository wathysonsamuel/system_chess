package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
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

    // Executa um movimento no tabuleiro
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();   // origem em coordenadas da matriz
        Position target = targetPosition.toPosition();   // destino em coordenadas da matriz
        validateSourcePosition(source);                  // verifica se existe peça na origem
        Piece capturedPiece = makeMove(source, target);  // executa o movimento e captura se houver
        return (ChessPiece) capturedPiece;               // retorna a peça capturada (ou null)
    }

    // Remove da origem, captura no destino (se existir) e move a peça
    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }

    // Garante que existe peça na posição de origem
    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
    }

    /* posso iniciar setup com posição de xadrez e não de matriz,  */
    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }
    // Coloca as peças iniciais no tabuleiro
    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}

