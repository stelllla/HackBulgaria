package car;

public class Car {
    
    private String model;
    private double mileage;
    
    Car(String model,double mileage){
        this.model = model;
        this.mileage = mileage;
    }
    
    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel(){
        return this.model;
    }
}
