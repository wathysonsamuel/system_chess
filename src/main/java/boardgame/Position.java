package boardgame;

/* Representa uma posição (linha, coluna) em um tabuleiro */
public class Position {

    private int row;    // linha da posição
    private int column; // coluna da posição

    // Construtor que define uma posição específica
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Getters e Setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Retorna uma representação da posição em formato de texto
    @Override
    public String toString() {
        return row + ", " + column;
    }
}

