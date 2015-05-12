package problem4;

public class NullKeyValueException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NullKeyValueException() {
        super();

    }

    public NullKeyValueException(String arg0, Throwable arg1) {
        super(arg0, arg1);

    }

    public NullKeyValueException(Throwable arg0) {
        super(arg0);

    }
    
    public String getMessage() {
        return "Null-Keys or Null-Values are not allowed!";
    }

}
