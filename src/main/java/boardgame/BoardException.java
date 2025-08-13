package boardgame;


/* detectar exceções no tabuleiro, ex:tentar colocar peça fora do tabuleiro */
public class BoardException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BoardException(String msg) {
        super(msg);
    }



}
