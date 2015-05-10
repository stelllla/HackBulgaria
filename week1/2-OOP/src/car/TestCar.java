package car;

public class TestCar {

    public static void main(String[] args) {
       
        Car audi = new Audi("A4",0);
        System.out.println(audi);
        
        Car bmw = new BMW ("333", 9999);
        System.out.println(bmw);
        
        Car wv = new Wolkswagen("Passat", 100);
        System.out.println(wv);
    }

}
