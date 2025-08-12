package chess;

import boardgame.Board;
import boardgame.Piece;

// Representa uma peça específica do jogo de xadrez (com cor)
public class ChessPiece extends Piece {

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
}
