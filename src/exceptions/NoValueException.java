package exceptions;

public class NoValueException extends RuntimeException {
    private String mensaje;

    public NoValueException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
