package problem5;
public class ImmutableClassExeption extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ImmutableClassExeption() {
        super();
        
    }

    public ImmutableClassExeption(String message, Throwable cause) {
        super(message, cause);
        
    }

    public ImmutableClassExeption(Throwable cause) {
        super(cause);
        
    }
    
    public ImmutableClassExeption(String message) {
        super(message);
       
    }
    
    public String getMessage() {
        return "You can`t change immutable class!";
    }
    

}
