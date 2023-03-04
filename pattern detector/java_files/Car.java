public interface Car {
    void drive();
}

public class Sedan implements Car {
    public void drive() {
        System.out.println("Driving a sedan");
    }
}

public class SUV implements Car {
    public void drive() {
        System.out.println("Driving an SUV");
    }
}

public class CarFactory {
    public static Car createCar(String type) {
        if (type.equals("sedan")) {
            return new Sedan();
        } else if (type.equals("suv")) {
            return new SUV();
        } else {
            throw new IllegalArgumentException("Invalid car type: " + type);
        }
    }
}



