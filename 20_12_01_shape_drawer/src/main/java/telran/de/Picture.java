package telran.de;


public class Picture extends Shape {

    Shape[] shapes;
    private final int LENGTH = 50;

    public Picture(Shape[] shapes, char symbol) {

        this.shapes = shapes;
        this.symbol = symbol;
    }

    @Override
    public void draw(){


        drawPictureLine();

        for(int j = 0; j < shapes.length; j++){

            shapes[j].draw();
        }

        drawPictureLine();

    }

    private void drawPictureLine() {

        System.out.println();
        for(int i = 0; i <= LENGTH; i++) {
            System.out.print(symbol);
        }
    }
}
