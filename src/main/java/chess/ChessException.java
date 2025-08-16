package chess;

import boardgame.BoardException;

/* Criada para detectar exceções nos jogos de xadrez, como movimentar peça de forma errada */
public class ChessException extends BoardException {
    private static final long serialVersionUID = 1L;

    public ChessException(String msg) {
        super(msg);
    }
}
