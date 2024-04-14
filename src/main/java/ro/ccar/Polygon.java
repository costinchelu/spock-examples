package ro.ccar;

public class Polygon {

    private final int numberOfSides;

    private Renderer renderer;

    public Polygon(int numberOfSides) {
        if (numberOfSides < 3) throw new TooFewSidesException("It cannot have less than 3 sides");
        this.numberOfSides = numberOfSides;
    }

    public Polygon(int numberOfSides, Renderer renderer) {
        this.numberOfSides = numberOfSides;
        this.renderer = renderer;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    private int somePrivateMethod() {
        return 3;
    }

    public void draw() {
        for (int i = 1; i <= numberOfSides; i++)
            renderer.drawLine(i);
    }
}
