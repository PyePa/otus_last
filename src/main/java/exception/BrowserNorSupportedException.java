package exception;

public class BrowserNorSupportedException extends Exception{
    public BrowserNorSupportedException(String browserName) {

        super(String.format("Браузер %s не поддерживается",browserName));
    }
}