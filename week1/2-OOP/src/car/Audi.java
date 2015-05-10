package car;

public class Audi extends Car{
    
    Audi(String model, double mileage){
        super(model,mileage);
    }
    
    @Override
    public String toString() {
        return "Audi model:" + super.getModel() + ",mileage:" + super.getMileage();
        
    }
    
  }
