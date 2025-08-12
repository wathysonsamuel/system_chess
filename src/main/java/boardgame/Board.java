package boardgame;

// Representa o tabuleiro do jogo genérico (pode ser xadrez ou outro jogo de tabuleiro)
public class Board {

    private int rows; // número de linhas do tabuleiro
    private int columns; // número de colunas do tabuleiro
    private Piece[][] pieces; // matriz que representa o tabuleiro com suas peças

    // Construtor que inicializa o tabuleiro com as dimensões fornecidas
    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns]; // cria a matriz de peças vazia
    }

    // Getters e Setters das dimensões do tabuleiro
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // Retorna a peça presente em uma posição específica da matriz (linha, coluna)
    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    // Sobrecarga: retorna a peça presente na posição informada via objeto Position
    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    // Coloca uma peça em uma posição do tabuleiro
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position; // atualiza a posição da peça (acesso possível porque está no mesmo pacote)
    }

    // Método auxiliar do metodo abaixo
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    // verifica se a posição existe
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    // vê se a posição no tabuleiro é nula e retorna se tem peça
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
