package car;

public class Wolkswagen extends Car {
    
    Wolkswagen ( String model, double mileage ) {
        super( model, mileage );
    }
    
    @Override
    public String toString() {
        return "Wolkswagen model:" + super.getModel() + ",mileage:" + super.getMileage();
    }

}
