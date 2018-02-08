package pl.ultimo.qdoc.services.qdocack.domain.exceptions;

import javax.naming.OperationNotSupportedException;

/**
 * @author Anna
 */
public class IllegalOperationException extends OperationNotSupportedException {
    public IllegalOperationException(String s) {
        super(s);
    }
}
