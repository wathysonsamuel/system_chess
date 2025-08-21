package boardgame;

// Representa uma peça genérica do tabuleiro (pode ser especializada depois, como torre, cavalo etc.)
public abstract class Piece {

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

    // Cada peça concreta(torre, bisco, cavalo) precisa implementar sua lógica de movimento
    public abstract boolean[][] possibleMoves();

    // Verifica se a peça pode se mover para uma posição especifica
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    // Verifica se existe pelo menos um movimento possível para a peça
    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i< mat.length; i++) {
            for (int j = 0; j< mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
