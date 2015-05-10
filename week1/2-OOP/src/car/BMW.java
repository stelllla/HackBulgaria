package car;

public class BMW extends Car{
    
    BMW(String model,double mileage){
        super(model,mileage);
    }

    @Override
    public String toString() {
          return "BMW model:" + super.getModel() + ",mileage:" + super.getMileage();
    }

}
