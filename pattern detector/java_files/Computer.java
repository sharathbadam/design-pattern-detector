public interface Computer {
    void compute();
}

public class Laptop implements Computer {
    public void compute() {
        System.out.println("Using a laptop for computing");
    }
}

public class Desktop implements Computer {
    public void compute() {
        System.out.println("Using a desktop for computing");
    }
}

public class ComputerFactory {
    public static Computer createComputer(String type) {
        if (type.equals("laptop")) {
            return new Laptop();
        } else if (type.equals("desktop")) {
            return new Desktop();
        } else {
            throw new IllegalArgumentException("Invalid computer type: " + type);
        }
    }
}
