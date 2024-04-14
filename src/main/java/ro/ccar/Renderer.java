package ro.ccar;

public class Renderer {

    private Palette palette;

    public Renderer() {
    }

    public Renderer(Palette palette) {
        this.palette = palette;
    }

    public void drawLine(int sideNumber) {
        System.out.println("Line " + sideNumber + " is drawn.");
    }

    public Colour getForegroundColour() {
        return palette.getPrimaryColour();
    }
}
