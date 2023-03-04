public interface Shape {
    void draw();
}

public class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class ShapeFactory {
    public static Shape createShape(String type) {
        if (type.equals("circle")) {
            return new Circle();
        } else if (type.equals("rectangle")) {
            return new Rectangle();
        } else {
            throw new IllegalArgumentException("Invalid shape type: " + type);
        }
    }
}

