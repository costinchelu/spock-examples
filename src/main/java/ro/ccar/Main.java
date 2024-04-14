package ro.ccar;


public class Main {
    public static void main(String[] args) {
        Renderer renderer = new Renderer();
        Polygon polygon = new Polygon(6, renderer);
        polygon.draw();
    }
}