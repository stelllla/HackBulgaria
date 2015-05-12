package problem2;

public class ServiceNotAvailableAtTheMomentException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ServiceNotAvailableAtTheMomentException() {
        super();

    }

    public ServiceNotAvailableAtTheMomentException(String arg0, Throwable arg1) {
        super(arg0, arg1);

    }

    public ServiceNotAvailableAtTheMomentException(String arg0) {
        super(arg0);

    }

    public ServiceNotAvailableAtTheMomentException(Throwable arg0) {
        super(arg0);
    }

    public String getMessage() {
        String error = " The Service is not available at the moment.Please wait and check your connection";
        return error;
    }

}
