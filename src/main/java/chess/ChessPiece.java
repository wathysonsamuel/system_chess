package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

// Representa uma peça específica do jogo de xadrez (com cor)
public abstract class ChessPiece extends Piece {

    private Color color; // cor da peça (preto ou branco)

    // Construtor: define o tabuleiro e a cor da peça
    public ChessPiece(Board board, Color color) {
        super(board); // chama o construtor da classe Piece
        this.color = color;
    }

    // Retorna a cor da peça
    public Color getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position position) { // se tiver peça de oponente, para o movimento
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color; // verificando se a peça é adversária pela cor
    }
}
