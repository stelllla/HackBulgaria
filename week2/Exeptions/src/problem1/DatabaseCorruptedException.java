package problem1;
public class DatabaseCorruptedException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public DatabaseCorruptedException() {
        super();
        
    }

    public DatabaseCorruptedException(String arg0, Throwable arg1) {
        super(arg0, arg1);
       
    }

    public DatabaseCorruptedException(Throwable arg0) {
        super(arg0);
    }

    
}
