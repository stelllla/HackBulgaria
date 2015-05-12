package problem2;

public class Service {

    boolean isActive;
    
    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    Service(boolean isActive) {
        this.isActive = isActive;
    }

    public void useService() throws ServiceNotAvailableAtTheMomentException {

        if (! getActive()) {
            throw new ServiceNotAvailableAtTheMomentException();
        }

    }
    public static void main(String[] args) {
        Service service = new Service(false);
        
        try {
            service.useService();
        } catch (ServiceNotAvailableAtTheMomentException e) {
            System.out.println(e.getMessage());
            
        }
    }

}
