package chess;

/* Criada para detectar exceções nos jogos de xadrez, como movimentar peça de forma errada */
public class ChessException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ChessException(String msg) {
        super(msg);
    }
}
