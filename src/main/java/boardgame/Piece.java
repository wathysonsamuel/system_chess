package boardgame;

// Representa uma peça genérica do tabuleiro (pode ser especializada depois, como torre, cavalo etc.)
public class Piece {

    protected Position position; // posição atual da peça no tabuleiro
    private Board board; // referência ao tabuleiro onde a peça está

    // Construtor recebe o tabuleiro ao qual a peça pertence
    public Piece(Board board) {
        this.board = board;
        position = null; // a posição inicial é nula até que seja colocada no tabuleiro
    }

    // Retorna o tabuleiro onde a peça está
    protected Board getBoard() {
        return board;
    }
}
