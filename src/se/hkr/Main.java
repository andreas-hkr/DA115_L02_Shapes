package se.hkr;

import java.util.List;

public class Main {
    private double computeAreaNoPattern(Shape shape) {
        if (shape instanceof Circle) {
        Circle circle = (Circle) shape;
        return Math.PI * circle.radius() * circle.radius();
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.width() * rectangle.height();
        } else {
            throw new IllegalArgumentException("Unknown shape");
        }
    }

    private double computeArea(Shape shape) {
        return switch (shape) {
            case Circle(double r) -> Math.PI * r * r;
            case Rectangle(double w, double h) -> w * h;
            default -> throw new IllegalArgumentException("Unknown shape");
        };
    }

    public static void main(String[] args) {
        Main main = new Main();
        var shapes = List.of(
                new Circle(10),
                new Rectangle(5, 6)
        );

        try {
            for (Shape shape : shapes) {
                System.out.println(main.computeArea(shape));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}