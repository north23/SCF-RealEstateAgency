package exceptions;

@SuppressWarnings("serial")
public class CorruptedFileException extends Exception {
    public CorruptedFileException() {
        super("File is corrupted");
    }

    public CorruptedFileException(String message) {
        super(message);
    }
}